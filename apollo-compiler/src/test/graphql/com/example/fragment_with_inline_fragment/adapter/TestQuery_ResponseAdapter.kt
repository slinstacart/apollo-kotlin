// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.fragment_with_inline_fragment.adapter

import com.apollographql.apollo3.api.ResponseAdapterCache
import com.apollographql.apollo3.api.ResponseField
import com.apollographql.apollo3.api.internal.IntResponseAdapter
import com.apollographql.apollo3.api.internal.ListResponseAdapter
import com.apollographql.apollo3.api.internal.NullableResponseAdapter
import com.apollographql.apollo3.api.internal.ResponseAdapter
import com.apollographql.apollo3.api.internal.StringResponseAdapter
import com.apollographql.apollo3.api.internal.json.JsonReader
import com.apollographql.apollo3.api.internal.json.JsonWriter
import com.example.fragment_with_inline_fragment.TestQuery
import com.example.fragment_with_inline_fragment.type.Episode
import com.example.fragment_with_inline_fragment.type.Episode_ResponseAdapter
import kotlin.Array
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
class TestQuery_ResponseAdapter(
  responseAdapterCache: ResponseAdapterCache
) : ResponseAdapter<TestQuery.Data> {
  private val nullableHeroAdapter: ResponseAdapter<TestQuery.Data.Hero?> =
      NullableResponseAdapter(Hero(responseAdapterCache))

  override fun fromResponse(reader: JsonReader): TestQuery.Data {
    var hero: TestQuery.Data.Hero? = null
    reader.beginObject()
    while(true) {
      when (reader.selectName(RESPONSE_NAMES)) {
        0 -> hero = nullableHeroAdapter.fromResponse(reader)
        else -> break
      }
    }
    reader.endObject()
    return TestQuery.Data(
      hero = hero
    )
  }

  override fun toResponse(writer: JsonWriter, value: TestQuery.Data) {
    writer.beginObject()
    writer.name("hero")
    nullableHeroAdapter.toResponse(writer, value.hero)
    writer.endObject()
  }

  companion object {
    val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField(
        type = ResponseField.Type.Named.Object("Character"),
        fieldName = "hero",
        fieldSets = listOf(
          ResponseField.FieldSet("Droid", Hero.CharacterDroidHero.RESPONSE_FIELDS),
          ResponseField.FieldSet("Human", Hero.CharacterHumanHero.RESPONSE_FIELDS),
          ResponseField.FieldSet(null, Hero.OtherHero.RESPONSE_FIELDS),
        ),
      )
    )

    val RESPONSE_NAMES: List<String> = RESPONSE_FIELDS.map { it.responseName }
  }

  class Hero(
    responseAdapterCache: ResponseAdapterCache
  ) : ResponseAdapter<TestQuery.Data.Hero> {
    val CharacterDroidHeroAdapter: CharacterDroidHero =
        com.example.fragment_with_inline_fragment.adapter.TestQuery_ResponseAdapter.Hero.CharacterDroidHero(responseAdapterCache)

    val CharacterHumanHeroAdapter: CharacterHumanHero =
        com.example.fragment_with_inline_fragment.adapter.TestQuery_ResponseAdapter.Hero.CharacterHumanHero(responseAdapterCache)

    val OtherHeroAdapter: OtherHero =
        com.example.fragment_with_inline_fragment.adapter.TestQuery_ResponseAdapter.Hero.OtherHero(responseAdapterCache)

    override fun fromResponse(reader: JsonReader): TestQuery.Data.Hero {
      reader.beginObject()
      check(reader.nextName() == "__typename")
      val typename = reader.nextString()

      return when(typename) {
        "Droid" -> CharacterDroidHeroAdapter.fromResponse(reader, typename)
        "Human" -> CharacterHumanHeroAdapter.fromResponse(reader, typename)
        else -> OtherHeroAdapter.fromResponse(reader, typename)
      }
      .also { reader.endObject() }
    }

    override fun toResponse(writer: JsonWriter, value: TestQuery.Data.Hero) {
      when(value) {
        is TestQuery.Data.Hero.CharacterDroidHero -> CharacterDroidHeroAdapter.toResponse(writer, value)
        is TestQuery.Data.Hero.CharacterHumanHero -> CharacterHumanHeroAdapter.toResponse(writer, value)
        is TestQuery.Data.Hero.OtherHero -> OtherHeroAdapter.toResponse(writer, value)
      }
    }

    class CharacterDroidHero(
      responseAdapterCache: ResponseAdapterCache
    ) {
      private val stringAdapter: ResponseAdapter<String> = StringResponseAdapter

      private val listOfNullableEpisodeAdapter: ResponseAdapter<List<Episode?>> =
          ListResponseAdapter(NullableResponseAdapter(Episode_ResponseAdapter))

      private val friendsConnectionAdapter:
          ResponseAdapter<TestQuery.Data.Hero.CharacterDroidHero.FriendsConnection> =
          FriendsConnection(responseAdapterCache)

      private val nullableStringAdapter: ResponseAdapter<String?> =
          NullableResponseAdapter(StringResponseAdapter)

      fun fromResponse(reader: JsonReader, __typename: String?):
          TestQuery.Data.Hero.CharacterDroidHero {
        var __typename: String? = __typename
        var name: String? = null
        var appearsIn: List<Episode?>? = null
        var friendsConnection: TestQuery.Data.Hero.CharacterDroidHero.FriendsConnection? = null
        var primaryFunction: String? = null
        while(true) {
          when (reader.selectName(RESPONSE_NAMES)) {
            0 -> __typename = stringAdapter.fromResponse(reader)
            1 -> name = stringAdapter.fromResponse(reader)
            2 -> appearsIn = listOfNullableEpisodeAdapter.fromResponse(reader)
            3 -> friendsConnection = friendsConnectionAdapter.fromResponse(reader)
            4 -> primaryFunction = nullableStringAdapter.fromResponse(reader)
            else -> break
          }
        }
        return TestQuery.Data.Hero.CharacterDroidHero(
          __typename = __typename!!,
          name = name!!,
          appearsIn = appearsIn!!,
          friendsConnection = friendsConnection!!,
          primaryFunction = primaryFunction
        )
      }

      fun toResponse(writer: JsonWriter, value: TestQuery.Data.Hero.CharacterDroidHero) {
        writer.beginObject()
        writer.name("__typename")
        stringAdapter.toResponse(writer, value.__typename)
        writer.name("name")
        stringAdapter.toResponse(writer, value.name)
        writer.name("appearsIn")
        listOfNullableEpisodeAdapter.toResponse(writer, value.appearsIn)
        writer.name("friendsConnection")
        friendsConnectionAdapter.toResponse(writer, value.friendsConnection)
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
            type =
                ResponseField.Type.NotNull(ResponseField.Type.List(ResponseField.Type.Named.Other("Episode"))),
            fieldName = "appearsIn",
          ),
          ResponseField(
            type = ResponseField.Type.NotNull(ResponseField.Type.Named.Object("FriendsConnection")),
            fieldName = "friendsConnection",
            fieldSets = listOf(
              ResponseField.FieldSet(null, FriendsConnection.RESPONSE_FIELDS)
            ),
          ),
          ResponseField(
            type = ResponseField.Type.Named.Other("String"),
            fieldName = "primaryFunction",
          )
        )

        val RESPONSE_NAMES: List<String> = RESPONSE_FIELDS.map { it.responseName }
      }

      class FriendsConnection(
        responseAdapterCache: ResponseAdapterCache
      ) : ResponseAdapter<TestQuery.Data.Hero.CharacterDroidHero.FriendsConnection> {
        private val nullableIntAdapter: ResponseAdapter<Int?> =
            NullableResponseAdapter(IntResponseAdapter)

        private val nullableListOfNullableEdgesAdapter:
            ResponseAdapter<List<TestQuery.Data.Hero.CharacterDroidHero.FriendsConnection.Edges?>?>
            =
            NullableResponseAdapter(ListResponseAdapter(NullableResponseAdapter(Edges(responseAdapterCache))))

        override fun fromResponse(reader: JsonReader):
            TestQuery.Data.Hero.CharacterDroidHero.FriendsConnection {
          var totalCount: Int? = null
          var edges: List<TestQuery.Data.Hero.CharacterDroidHero.FriendsConnection.Edges?>? = null
          reader.beginObject()
          while(true) {
            when (reader.selectName(RESPONSE_NAMES)) {
              0 -> totalCount = nullableIntAdapter.fromResponse(reader)
              1 -> edges = nullableListOfNullableEdgesAdapter.fromResponse(reader)
              else -> break
            }
          }
          reader.endObject()
          return TestQuery.Data.Hero.CharacterDroidHero.FriendsConnection(
            totalCount = totalCount,
            edges = edges
          )
        }

        override fun toResponse(writer: JsonWriter,
            value: TestQuery.Data.Hero.CharacterDroidHero.FriendsConnection) {
          writer.beginObject()
          writer.name("totalCount")
          nullableIntAdapter.toResponse(writer, value.totalCount)
          writer.name("edges")
          nullableListOfNullableEdgesAdapter.toResponse(writer, value.edges)
          writer.endObject()
        }

        companion object {
          val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
            ResponseField(
              type = ResponseField.Type.Named.Other("Int"),
              fieldName = "totalCount",
            ),
            ResponseField(
              type = ResponseField.Type.List(ResponseField.Type.Named.Object("FriendsEdge")),
              fieldName = "edges",
              fieldSets = listOf(
                ResponseField.FieldSet(null, Edges.RESPONSE_FIELDS)
              ),
            )
          )

          val RESPONSE_NAMES: List<String> = RESPONSE_FIELDS.map { it.responseName }
        }

        class Edges(
          responseAdapterCache: ResponseAdapterCache
        ) : ResponseAdapter<TestQuery.Data.Hero.CharacterDroidHero.FriendsConnection.Edges> {
          private val nullableNodeAdapter:
              ResponseAdapter<TestQuery.Data.Hero.CharacterDroidHero.FriendsConnection.Edges.Node?>
              = NullableResponseAdapter(Node(responseAdapterCache))

          override fun fromResponse(reader: JsonReader):
              TestQuery.Data.Hero.CharacterDroidHero.FriendsConnection.Edges {
            var node: TestQuery.Data.Hero.CharacterDroidHero.FriendsConnection.Edges.Node? = null
            reader.beginObject()
            while(true) {
              when (reader.selectName(RESPONSE_NAMES)) {
                0 -> node = nullableNodeAdapter.fromResponse(reader)
                else -> break
              }
            }
            reader.endObject()
            return TestQuery.Data.Hero.CharacterDroidHero.FriendsConnection.Edges(
              node = node
            )
          }

          override fun toResponse(writer: JsonWriter,
              value: TestQuery.Data.Hero.CharacterDroidHero.FriendsConnection.Edges) {
            writer.beginObject()
            writer.name("node")
            nullableNodeAdapter.toResponse(writer, value.node)
            writer.endObject()
          }

          companion object {
            val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
              ResponseField(
                type = ResponseField.Type.Named.Object("Character"),
                fieldName = "node",
                fieldSets = listOf(
                  ResponseField.FieldSet(null, Node.RESPONSE_FIELDS)
                ),
              )
            )

            val RESPONSE_NAMES: List<String> = RESPONSE_FIELDS.map { it.responseName }
          }

          class Node(
            responseAdapterCache: ResponseAdapterCache
          ) : ResponseAdapter<TestQuery.Data.Hero.CharacterDroidHero.FriendsConnection.Edges.Node> {
            private val stringAdapter: ResponseAdapter<String> = StringResponseAdapter

            override fun fromResponse(reader: JsonReader):
                TestQuery.Data.Hero.CharacterDroidHero.FriendsConnection.Edges.Node {
              var name: String? = null
              reader.beginObject()
              while(true) {
                when (reader.selectName(RESPONSE_NAMES)) {
                  0 -> name = stringAdapter.fromResponse(reader)
                  else -> break
                }
              }
              reader.endObject()
              return TestQuery.Data.Hero.CharacterDroidHero.FriendsConnection.Edges.Node(
                name = name!!
              )
            }

            override fun toResponse(writer: JsonWriter,
                value: TestQuery.Data.Hero.CharacterDroidHero.FriendsConnection.Edges.Node) {
              writer.beginObject()
              writer.name("name")
              stringAdapter.toResponse(writer, value.name)
              writer.endObject()
            }

            companion object {
              val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
                ResponseField(
                  type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("String")),
                  fieldName = "name",
                )
              )

              val RESPONSE_NAMES: List<String> = RESPONSE_FIELDS.map { it.responseName }
            }
          }
        }
      }
    }

    class CharacterHumanHero(
      responseAdapterCache: ResponseAdapterCache
    ) {
      private val stringAdapter: ResponseAdapter<String> = StringResponseAdapter

      private val listOfNullableEpisodeAdapter: ResponseAdapter<List<Episode?>> =
          ListResponseAdapter(NullableResponseAdapter(Episode_ResponseAdapter))

      private val friendsConnectionAdapter:
          ResponseAdapter<TestQuery.Data.Hero.CharacterHumanHero.FriendsConnection> =
          FriendsConnection(responseAdapterCache)

      fun fromResponse(reader: JsonReader, __typename: String?):
          TestQuery.Data.Hero.CharacterHumanHero {
        var __typename: String? = __typename
        var name: String? = null
        var appearsIn: List<Episode?>? = null
        var friendsConnection: TestQuery.Data.Hero.CharacterHumanHero.FriendsConnection? = null
        while(true) {
          when (reader.selectName(RESPONSE_NAMES)) {
            0 -> __typename = stringAdapter.fromResponse(reader)
            1 -> name = stringAdapter.fromResponse(reader)
            2 -> appearsIn = listOfNullableEpisodeAdapter.fromResponse(reader)
            3 -> friendsConnection = friendsConnectionAdapter.fromResponse(reader)
            else -> break
          }
        }
        return TestQuery.Data.Hero.CharacterHumanHero(
          __typename = __typename!!,
          name = name!!,
          appearsIn = appearsIn!!,
          friendsConnection = friendsConnection!!
        )
      }

      fun toResponse(writer: JsonWriter, value: TestQuery.Data.Hero.CharacterHumanHero) {
        writer.beginObject()
        writer.name("__typename")
        stringAdapter.toResponse(writer, value.__typename)
        writer.name("name")
        stringAdapter.toResponse(writer, value.name)
        writer.name("appearsIn")
        listOfNullableEpisodeAdapter.toResponse(writer, value.appearsIn)
        writer.name("friendsConnection")
        friendsConnectionAdapter.toResponse(writer, value.friendsConnection)
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
            type =
                ResponseField.Type.NotNull(ResponseField.Type.List(ResponseField.Type.Named.Other("Episode"))),
            fieldName = "appearsIn",
          ),
          ResponseField(
            type = ResponseField.Type.NotNull(ResponseField.Type.Named.Object("FriendsConnection")),
            fieldName = "friendsConnection",
            fieldSets = listOf(
              ResponseField.FieldSet(null, FriendsConnection.RESPONSE_FIELDS)
            ),
          )
        )

        val RESPONSE_NAMES: List<String> = RESPONSE_FIELDS.map { it.responseName }
      }

      class FriendsConnection(
        responseAdapterCache: ResponseAdapterCache
      ) : ResponseAdapter<TestQuery.Data.Hero.CharacterHumanHero.FriendsConnection> {
        private val nullableIntAdapter: ResponseAdapter<Int?> =
            NullableResponseAdapter(IntResponseAdapter)

        private val nullableListOfNullableEdgesAdapter:
            ResponseAdapter<List<TestQuery.Data.Hero.CharacterHumanHero.FriendsConnection.Edges?>?>
            =
            NullableResponseAdapter(ListResponseAdapter(NullableResponseAdapter(Edges(responseAdapterCache))))

        override fun fromResponse(reader: JsonReader):
            TestQuery.Data.Hero.CharacterHumanHero.FriendsConnection {
          var totalCount: Int? = null
          var edges: List<TestQuery.Data.Hero.CharacterHumanHero.FriendsConnection.Edges?>? = null
          reader.beginObject()
          while(true) {
            when (reader.selectName(RESPONSE_NAMES)) {
              0 -> totalCount = nullableIntAdapter.fromResponse(reader)
              1 -> edges = nullableListOfNullableEdgesAdapter.fromResponse(reader)
              else -> break
            }
          }
          reader.endObject()
          return TestQuery.Data.Hero.CharacterHumanHero.FriendsConnection(
            totalCount = totalCount,
            edges = edges
          )
        }

        override fun toResponse(writer: JsonWriter,
            value: TestQuery.Data.Hero.CharacterHumanHero.FriendsConnection) {
          writer.beginObject()
          writer.name("totalCount")
          nullableIntAdapter.toResponse(writer, value.totalCount)
          writer.name("edges")
          nullableListOfNullableEdgesAdapter.toResponse(writer, value.edges)
          writer.endObject()
        }

        companion object {
          val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
            ResponseField(
              type = ResponseField.Type.Named.Other("Int"),
              fieldName = "totalCount",
            ),
            ResponseField(
              type = ResponseField.Type.List(ResponseField.Type.Named.Object("FriendsEdge")),
              fieldName = "edges",
              fieldSets = listOf(
                ResponseField.FieldSet(null, Edges.RESPONSE_FIELDS)
              ),
            )
          )

          val RESPONSE_NAMES: List<String> = RESPONSE_FIELDS.map { it.responseName }
        }

        class Edges(
          responseAdapterCache: ResponseAdapterCache
        ) : ResponseAdapter<TestQuery.Data.Hero.CharacterHumanHero.FriendsConnection.Edges> {
          private val nullableNodeAdapter:
              ResponseAdapter<TestQuery.Data.Hero.CharacterHumanHero.FriendsConnection.Edges.Node?>
              = NullableResponseAdapter(Node(responseAdapterCache))

          override fun fromResponse(reader: JsonReader):
              TestQuery.Data.Hero.CharacterHumanHero.FriendsConnection.Edges {
            var node: TestQuery.Data.Hero.CharacterHumanHero.FriendsConnection.Edges.Node? = null
            reader.beginObject()
            while(true) {
              when (reader.selectName(RESPONSE_NAMES)) {
                0 -> node = nullableNodeAdapter.fromResponse(reader)
                else -> break
              }
            }
            reader.endObject()
            return TestQuery.Data.Hero.CharacterHumanHero.FriendsConnection.Edges(
              node = node
            )
          }

          override fun toResponse(writer: JsonWriter,
              value: TestQuery.Data.Hero.CharacterHumanHero.FriendsConnection.Edges) {
            writer.beginObject()
            writer.name("node")
            nullableNodeAdapter.toResponse(writer, value.node)
            writer.endObject()
          }

          companion object {
            val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
              ResponseField(
                type = ResponseField.Type.Named.Object("Character"),
                fieldName = "node",
                fieldSets = listOf(
                  ResponseField.FieldSet(null, Node.RESPONSE_FIELDS)
                ),
              )
            )

            val RESPONSE_NAMES: List<String> = RESPONSE_FIELDS.map { it.responseName }
          }

          class Node(
            responseAdapterCache: ResponseAdapterCache
          ) : ResponseAdapter<TestQuery.Data.Hero.CharacterHumanHero.FriendsConnection.Edges.Node> {
            private val stringAdapter: ResponseAdapter<String> = StringResponseAdapter

            override fun fromResponse(reader: JsonReader):
                TestQuery.Data.Hero.CharacterHumanHero.FriendsConnection.Edges.Node {
              var name: String? = null
              reader.beginObject()
              while(true) {
                when (reader.selectName(RESPONSE_NAMES)) {
                  0 -> name = stringAdapter.fromResponse(reader)
                  else -> break
                }
              }
              reader.endObject()
              return TestQuery.Data.Hero.CharacterHumanHero.FriendsConnection.Edges.Node(
                name = name!!
              )
            }

            override fun toResponse(writer: JsonWriter,
                value: TestQuery.Data.Hero.CharacterHumanHero.FriendsConnection.Edges.Node) {
              writer.beginObject()
              writer.name("name")
              stringAdapter.toResponse(writer, value.name)
              writer.endObject()
            }

            companion object {
              val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
                ResponseField(
                  type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("String")),
                  fieldName = "name",
                )
              )

              val RESPONSE_NAMES: List<String> = RESPONSE_FIELDS.map { it.responseName }
            }
          }
        }
      }
    }

    class OtherHero(
      responseAdapterCache: ResponseAdapterCache
    ) {
      private val stringAdapter: ResponseAdapter<String> = StringResponseAdapter

      private val listOfNullableEpisodeAdapter: ResponseAdapter<List<Episode?>> =
          ListResponseAdapter(NullableResponseAdapter(Episode_ResponseAdapter))

      fun fromResponse(reader: JsonReader, __typename: String?): TestQuery.Data.Hero.OtherHero {
        var __typename: String? = __typename
        var name: String? = null
        var appearsIn: List<Episode?>? = null
        while(true) {
          when (reader.selectName(RESPONSE_NAMES)) {
            0 -> __typename = stringAdapter.fromResponse(reader)
            1 -> name = stringAdapter.fromResponse(reader)
            2 -> appearsIn = listOfNullableEpisodeAdapter.fromResponse(reader)
            else -> break
          }
        }
        return TestQuery.Data.Hero.OtherHero(
          __typename = __typename!!,
          name = name!!,
          appearsIn = appearsIn!!
        )
      }

      fun toResponse(writer: JsonWriter, value: TestQuery.Data.Hero.OtherHero) {
        writer.beginObject()
        writer.name("__typename")
        stringAdapter.toResponse(writer, value.__typename)
        writer.name("name")
        stringAdapter.toResponse(writer, value.name)
        writer.name("appearsIn")
        listOfNullableEpisodeAdapter.toResponse(writer, value.appearsIn)
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
            type =
                ResponseField.Type.NotNull(ResponseField.Type.List(ResponseField.Type.Named.Other("Episode"))),
            fieldName = "appearsIn",
          )
        )

        val RESPONSE_NAMES: List<String> = RESPONSE_FIELDS.map { it.responseName }
      }
    }
  }
}