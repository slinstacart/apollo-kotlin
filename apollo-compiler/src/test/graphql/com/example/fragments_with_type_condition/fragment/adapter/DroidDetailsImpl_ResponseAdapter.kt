// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.fragments_with_type_condition.fragment.adapter

import com.apollographql.apollo3.api.ResponseAdapterCache
import com.apollographql.apollo3.api.ResponseField
import com.apollographql.apollo3.api.internal.NullableResponseAdapter
import com.apollographql.apollo3.api.internal.ResponseAdapter
import com.apollographql.apollo3.api.internal.StringResponseAdapter
import com.apollographql.apollo3.api.internal.json.JsonReader
import com.apollographql.apollo3.api.internal.json.JsonWriter
import com.example.fragments_with_type_condition.fragment.DroidDetailsImpl
import kotlin.Array
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
class DroidDetailsImpl_ResponseAdapter(
  responseAdapterCache: ResponseAdapterCache
) : ResponseAdapter<DroidDetailsImpl.Data> {
  private val stringAdapter: ResponseAdapter<String> = StringResponseAdapter

  private val nullableStringAdapter: ResponseAdapter<String?> =
      NullableResponseAdapter(StringResponseAdapter)

  override fun fromResponse(reader: JsonReader): DroidDetailsImpl.Data {
    var __typename: String? = null
    var name: String? = null
    var primaryFunction: String? = null
    reader.beginObject()
    while(true) {
      when (reader.selectName(RESPONSE_NAMES)) {
        0 -> __typename = stringAdapter.fromResponse(reader)
        1 -> name = stringAdapter.fromResponse(reader)
        2 -> primaryFunction = nullableStringAdapter.fromResponse(reader)
        else -> break
      }
    }
    reader.endObject()
    return DroidDetailsImpl.Data(
      __typename = __typename!!,
      name = name!!,
      primaryFunction = primaryFunction
    )
  }

  override fun toResponse(writer: JsonWriter, value: DroidDetailsImpl.Data) {
    writer.beginObject()
    writer.name("__typename")
    stringAdapter.toResponse(writer, value.__typename)
    writer.name("name")
    stringAdapter.toResponse(writer, value.name)
    writer.name("primaryFunction")
    nullableStringAdapter.toResponse(writer, value.primaryFunction)
    writer.endObject()
  }

  companion object {
    val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField.Typename,
      ResponseField(
        type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("String")),
        fieldName = "name",
      ),
      ResponseField(
        type = ResponseField.Type.Named.Other("String"),
        fieldName = "primaryFunction",
      )
    )

    val RESPONSE_NAMES: List<String> = RESPONSE_FIELDS.map { it.responseName }
  }
}