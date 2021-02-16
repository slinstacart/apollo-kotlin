// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.named_fragment_with_variables.fragment.adapter

import com.apollographql.apollo3.api.ResponseAdapterCache
import com.apollographql.apollo3.api.ResponseField
import com.apollographql.apollo3.api.internal.ResponseAdapter
import com.apollographql.apollo3.api.internal.StringResponseAdapter
import com.apollographql.apollo3.api.internal.json.JsonReader
import com.apollographql.apollo3.api.internal.json.JsonWriter
import com.example.named_fragment_with_variables.fragment.UserFragmentImpl
import kotlin.Array
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
class UserFragmentImpl_ResponseAdapter(
  responseAdapterCache: ResponseAdapterCache
) : ResponseAdapter<UserFragmentImpl.Data> {
  private val stringAdapter: ResponseAdapter<String> = StringResponseAdapter

  override fun fromResponse(reader: JsonReader): UserFragmentImpl.Data {
    var __typename: String? = null
    var firstName: String? = null
    var lastName: String? = null
    var avatar: String? = null
    reader.beginObject()
    while(true) {
      when (reader.selectName(RESPONSE_NAMES)) {
        0 -> __typename = stringAdapter.fromResponse(reader)
        1 -> firstName = stringAdapter.fromResponse(reader)
        2 -> lastName = stringAdapter.fromResponse(reader)
        3 -> avatar = stringAdapter.fromResponse(reader)
        else -> break
      }
    }
    reader.endObject()
    return UserFragmentImpl.Data(
      __typename = __typename!!,
      firstName = firstName!!,
      lastName = lastName!!,
      avatar = avatar!!
    )
  }

  override fun toResponse(writer: JsonWriter, value: UserFragmentImpl.Data) {
    writer.beginObject()
    writer.name("__typename")
    stringAdapter.toResponse(writer, value.__typename)
    writer.name("firstName")
    stringAdapter.toResponse(writer, value.firstName)
    writer.name("lastName")
    stringAdapter.toResponse(writer, value.lastName)
    writer.name("avatar")
    stringAdapter.toResponse(writer, value.avatar)
    writer.endObject()
  }

  companion object {
    val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField.Typename,
      ResponseField(
        type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("String")),
        fieldName = "firstName",
      ),
      ResponseField(
        type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("String")),
        fieldName = "lastName",
      ),
      ResponseField(
        type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("String")),
        fieldName = "avatar",
        arguments = mapOf<String, Any?>(
          "size" to mapOf<String, Any?>(
            "kind" to "Variable",
            "variableName" to "size")),
      )
    )

    val RESPONSE_NAMES: List<String> = RESPONSE_FIELDS.map { it.responseName }
  }
}