package com.apollographql.apollo3.internal

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.CompiledSelection
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.Query
import com.apollographql.apollo3.api.cache.http.HttpCachePolicy
import com.apollographql.apollo3.api.cache.http.HttpCachePolicy.FetchStrategy
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.fetcher.ApolloResponseFetchers
import com.google.common.truth.Truth
import okhttp3.OkHttpClient
import org.junit.Test

class ResponseFetcherTest {

  private val emptyQuery = object : Query<Query.Data> {
    var operationName: String  ="emptyQuery"

    override fun document(): String {
      return ""
    }

    override fun serializeVariables(writer: JsonWriter, customScalarAdapters: CustomScalarAdapters) {
      writer.beginObject()
      writer.endObject()
    }

    override fun adapter() = throw UnsupportedOperationException()

    override fun name(): String {
      return operationName
    }

    override fun id(): String {
      return ""
    }

    override fun selections(): List<CompiledSelection> {
      return emptyList()
    }
  }

  @Test
  fun setDefaultCachePolicy() {
    val apolloClient = ApolloClient.builder()
        .serverUrl("http://google.com")
        .okHttpClient(OkHttpClient())
        .defaultHttpCachePolicy(HttpCachePolicy.CACHE_ONLY)
        .defaultResponseFetcher(ApolloResponseFetchers.NETWORK_ONLY)
        .build()
    val realApolloCall = apolloClient.query(emptyQuery) as RealApolloCall<*>
    Truth.assertThat(realApolloCall.httpCachePolicy!!.fetchStrategy).isEqualTo(FetchStrategy.CACHE_ONLY)
    Truth.assertThat(realApolloCall.responseFetcher).isEqualTo(ApolloResponseFetchers.NETWORK_ONLY)
  }

  @Test
  fun defaultCacheControl() {
    val apolloClient = ApolloClient.builder()
        .serverUrl("http://google.com")
        .okHttpClient(OkHttpClient())
        .build()
    val realApolloCall = apolloClient.query(emptyQuery) as RealApolloCall<*>
    Truth.assertThat(realApolloCall.httpCachePolicy!!.fetchStrategy).isEqualTo(FetchStrategy.NETWORK_ONLY)
    Truth.assertThat(realApolloCall.responseFetcher).isEqualTo(ApolloResponseFetchers.CACHE_FIRST)
  }
}