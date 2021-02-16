// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.interface_on_interface.adapter

import com.apollographql.apollo3.api.ResponseAdapterCache
import com.apollographql.apollo3.api.ResponseField
import com.apollographql.apollo3.api.internal.DoubleResponseAdapter
import com.apollographql.apollo3.api.internal.ResponseAdapter
import com.apollographql.apollo3.api.internal.StringResponseAdapter
import com.apollographql.apollo3.api.internal.json.JsonReader
import com.apollographql.apollo3.api.internal.json.JsonWriter
import com.example.interface_on_interface.GetHuman
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
class GetHuman_ResponseAdapter(
  responseAdapterCache: ResponseAdapterCache
) : ResponseAdapter<GetHuman.Data> {
  private val humanAdapter: ResponseAdapter<GetHuman.Data.Human> = Human(responseAdapterCache)

  private val nodeAdapter: ResponseAdapter<GetHuman.Data.Node> = Node(responseAdapterCache)

  override fun fromResponse(reader: JsonReader): GetHuman.Data {
    var human: GetHuman.Data.Human? = null
    var node: GetHuman.Data.Node? = null
    reader.beginObject()
    while(true) {
      when (reader.selectName(RESPONSE_NAMES)) {
        0 -> human = humanAdapter.fromResponse(reader)
        1 -> node = nodeAdapter.fromResponse(reader)
        else -> break
      }
    }
    reader.endObject()
    return GetHuman.Data(
      human = human!!,
      node = node!!
    )
  }

  override fun toResponse(writer: JsonWriter, value: GetHuman.Data) {
    writer.beginObject()
    writer.name("human")
    humanAdapter.toResponse(writer, value.human)
    writer.name("node")
    nodeAdapter.toResponse(writer, value.node)
    writer.endObject()
  }

  companion object {
    val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField(
        type = ResponseField.Type.NotNull(ResponseField.Type.Named.Object("Human")),
        fieldName = "human",
        fieldSets = listOf(
          ResponseField.FieldSet(null, Human.RESPONSE_FIELDS)
        ),
      ),
      ResponseField(
        type = ResponseField.Type.NotNull(ResponseField.Type.Named.Object("Node")),
        fieldName = "node",
        fieldSets = listOf(
          ResponseField.FieldSet("Human", Node.HumanNode.RESPONSE_FIELDS),
          ResponseField.FieldSet(null, Node.OtherNode.RESPONSE_FIELDS),
        ),
      )
    )

    val RESPONSE_NAMES: List<String> = RESPONSE_FIELDS.map { it.responseName }
  }

  class Human(
    responseAdapterCache: ResponseAdapterCache
  ) : ResponseAdapter<GetHuman.Data.Human> {
    private val stringAdapter: ResponseAdapter<String> = StringResponseAdapter

    private val floatAdapter: ResponseAdapter<Double> = DoubleResponseAdapter

    override fun fromResponse(reader: JsonReader): GetHuman.Data.Human {
      var id: String? = null
      var name: String? = null
      var height: Double? = null
      reader.beginObject()
      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> id = stringAdapter.fromResponse(reader)
          1 -> name = stringAdapter.fromResponse(reader)
          2 -> height = floatAdapter.fromResponse(reader)
          else -> break
        }
      }
      reader.endObject()
      return GetHuman.Data.Human(
        id = id!!,
        name = name!!,
        height = height!!
      )
    }

    override fun toResponse(writer: JsonWriter, value: GetHuman.Data.Human) {
      writer.beginObject()
      writer.name("id")
      stringAdapter.toResponse(writer, value.id)
      writer.name("name")
      stringAdapter.toResponse(writer, value.name)
      writer.name("height")
      floatAdapter.toResponse(writer, value.height)
      writer.endObject()
    }

    companion object {
      val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
        ResponseField(
          type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("String")),
          fieldName = "id",
        ),
        ResponseField(
          type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("String")),
          fieldName = "name",
        ),
        ResponseField(
          type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("Float")),
          fieldName = "height",
        )
      )

      val RESPONSE_NAMES: List<String> = RESPONSE_FIELDS.map { it.responseName }
    }
  }

  class Node(
    responseAdapterCache: ResponseAdapterCache
  ) : ResponseAdapter<GetHuman.Data.Node> {
    val HumanNodeAdapter: HumanNode =
        com.example.interface_on_interface.adapter.GetHuman_ResponseAdapter.Node.HumanNode(responseAdapterCache)

    val OtherNodeAdapter: OtherNode =
        com.example.interface_on_interface.adapter.GetHuman_ResponseAdapter.Node.OtherNode(responseAdapterCache)

    override fun fromResponse(reader: JsonReader): GetHuman.Data.Node {
      reader.beginObject()
      check(reader.nextName() == "__typename")
      val typename = reader.nextString()

      return when(typename) {
        "Human" -> HumanNodeAdapter.fromResponse(reader, typename)
        else -> OtherNodeAdapter.fromResponse(reader, typename)
      }
      .also { reader.endObject() }
    }

    override fun toResponse(writer: JsonWriter, value: GetHuman.Data.Node) {
      when(value) {
        is GetHuman.Data.Node.HumanNode -> HumanNodeAdapter.toResponse(writer, value)
        is GetHuman.Data.Node.OtherNode -> OtherNodeAdapter.toResponse(writer, value)
      }
    }

    class HumanNode(
      responseAdapterCache: ResponseAdapterCache
    ) {
      private val stringAdapter: ResponseAdapter<String> = StringResponseAdapter

      private val floatAdapter: ResponseAdapter<Double> = DoubleResponseAdapter

      fun fromResponse(reader: JsonReader, __typename: String?): GetHuman.Data.Node.HumanNode {
        var __typename: String? = __typename
        var height: Double? = null
        while(true) {
          when (reader.selectName(RESPONSE_NAMES)) {
            0 -> __typename = stringAdapter.fromResponse(reader)
            1 -> height = floatAdapter.fromResponse(reader)
            else -> break
          }
        }
        return GetHuman.Data.Node.HumanNode(
          __typename = __typename!!,
          height = height!!
        )
      }

      fun toResponse(writer: JsonWriter, value: GetHuman.Data.Node.HumanNode) {
        writer.beginObject()
        writer.name("__typename")
        stringAdapter.toResponse(writer, value.__typename)
        writer.name("height")
        floatAdapter.toResponse(writer, value.height)
        writer.endObject()
      }

      companion object {
        val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.Typename,
          ResponseField(
            type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("Float")),
            fieldName = "height",
          )
        )

        val RESPONSE_NAMES: List<String> = RESPONSE_FIELDS.map { it.responseName }
      }
    }

    class OtherNode(
      responseAdapterCache: ResponseAdapterCache
    ) {
      private val stringAdapter: ResponseAdapter<String> = StringResponseAdapter

      fun fromResponse(reader: JsonReader, __typename: String?): GetHuman.Data.Node.OtherNode {
        var __typename: String? = __typename
        while(true) {
          when (reader.selectName(RESPONSE_NAMES)) {
            0 -> __typename = stringAdapter.fromResponse(reader)
            else -> break
          }
        }
        return GetHuman.Data.Node.OtherNode(
          __typename = __typename!!
        )
      }

      fun toResponse(writer: JsonWriter, value: GetHuman.Data.Node.OtherNode) {
        writer.beginObject()
        writer.name("__typename")
        stringAdapter.toResponse(writer, value.__typename)
        writer.endObject()
      }

      companion object {
        val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.Typename
        )

        val RESPONSE_NAMES: List<String> = RESPONSE_FIELDS.map { it.responseName }
      }
    }
  }
}