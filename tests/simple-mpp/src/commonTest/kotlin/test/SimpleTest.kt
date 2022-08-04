package test

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.cache.normalized.api.MemoryCacheFactory
import com.apollographql.apollo3.cache.normalized.normalizedCache
import com.apollographql.apollo3.mockserver.MockServer
import com.apollographql.apollo3.mockserver.enqueue
import com.apollographql.apollo3.mpp.currentThreadId
import com.example.GetFooQuery
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

class SimpleTest {
  @Test
  fun simpleTest() = runTest {
    val mockServer = MockServer()
    val apolloClient = ApolloClient.Builder()
        .serverUrl(mockServer.url())
        .normalizedCache(MemoryCacheFactory())
        .build()


    println("Test 1: ${currentThreadId()}")
    mockServer.enqueue("""
      {
        "data": {
          "foo": 42
        }
      }
    """.trimIndent())
    apolloClient.query(GetFooQuery()).execute()
    println("Test 2: ${currentThreadId()}")
  }
}
