# Thoughts on threading and concurrency 

A tentative high level overview of what threads are used and why we came to this. The new memory model makes everything a lot easier but there are still multiple threads involved

At a high level, Apollo-Kotlin does multiple things:
* HTTP requests 
* Json deserialization (for data)
* Json serialization (for variables)
* Normalization
* De-normalization  
* Cache reading
* Cache writing
* Plumbing: the work of connecting the above steps together

Most of the above steps need to happen in a background thread as they are potentially CPU expensive (normalization), IO expensive (HTTP) or both (SQLite), except maybe the plumbing that is just passing plates around. That being said, running the plumbing in the main thread means that we have to pay the price of a context switch every time we need to perform an operation. So it makes sense to run the plumbing on the same thread as was previously executing to avoid the context switch.  

## Mutable, shared state that requires synchronization

If everything were immutable, we could run each request on a separate thread and let them execute concurrently. Unfortunately, there is some state that requires synchronization:

* Normalized cache
* Store listeners
* Websocket 
* HTTP2 connection state with HTTP2 multiplexing, some state is needed there

## Why coroutines in interceptors?

We went pretty early with coroutine APIs in a lot of places. `HttpEngine`, `Interceptors`. Now that K/N can share mutable data between threads, we could use blocking calls in a lot more places. Still coroutines are interesting because:
* they offer an unified way to handle cancellation.
* for JS there's just no other way

## Sync vs Async HTTP requests

**On iOS**, there isn't much choice as NSURLSession only has an async API. We don't really have control over what thread the callback is called in. This is a bit unfortunate because it means another context switch but we haven't found a way around that.

**On the JVM**, there are less restrictions. OkHttp has as `synchronous` API that we are using to avoid a context switch. Cancellation is happening from a separate thread. I'm not 100% clear on the implications on sharing threadpools. This would have to be further examined if we realize we could save a bit by sharing some threadpools with other users of OkHttp.

## Conclusion

With all that, the typical flows should be:

* iOS (2~4 context changes)
  * Callsite (Main) -> CacheRead (Default) -> Plumbing (Default) -> HTTP (NSURLSession delegateQueue) -> Plumbing (Default) -> CacheWrite (Default) -> Response (Main) 
  * Because the NSURLSession delegateQueue seems to be using GCD under the hood and that's also used by the `Default` dispatcher, it might be that the same thread is reused
* JVM (2 context changes): 
  * Callsite (Main) -> CacheRead (IO) -> Plumbing (IO) -> HTTP (IO) -> Plumbing (IO) -> CacheWrite (IO) -> Response (Main)

Open quetsions:
* Does Android allow concurrent SQLite reads? (looks like yes)

## Appendix: Non-goal: Atomic Cached Requests

Apollo Kotlin has no concept of "Atomic request". Launching the same request twice in a row will most likely end up in the request being sent to the network twice even if the first one will ultimately cache it (but this is not guaranteed either):

```kotlin
val response1 = launch {
    // Since "hero" is not in cache, this will go to the network
    apolloClient.query(HeroQuery()).execute()
}
val response2 = launch {
    // This will most likely go to the network even though it's the same request as above
    // If another request is modifying the cache, what is returned depends the timings of the different request
    apolloClient.query(HeroQuery()).execute()
}
```

On the other hand, waiting for one query to complete before launching the next one is guaranteed to have a predictable cache state. Especially if asynchronous cache write is implemented, the second query should wait until the write is written by the first one to read the cache:

```kotlin
val response1 = apolloClient.query(HeroQuery()).execute()
// If no other request is executing and the first one was cached, response2 will return the cached result
val response2 = apolloClient.query(HeroQuery()).execute()
```
