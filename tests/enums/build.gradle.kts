plugins {
  id("org.jetbrains.kotlin.jvm")
  id("apollo.test")
  id("com.apollographql.apollo3")
}

dependencies {
  implementation(golatac.lib("apollo.runtime"))
  testImplementation(golatac.lib("kotlin.test"))
  testImplementation(golatac.lib("junit"))
}

apollo {
  service("kotlin") {
    packageName.set("enums.kotlin")
  }

  findService("kotlin")!!.apply {
    sealedClassesForEnumsMatching.set(listOf(".*avity", "FooSealed"))
  }

  service("java") {
    packageName.set("enums.java")
    outputDirConnection {
      connectToJavaSourceSet("main")
    }
  }

  findService("java")!!.apply {
    classesForEnumsMatching.set(listOf(".*avity", "FooClass"))
    generateKotlinModels.set(false)
  }
}
