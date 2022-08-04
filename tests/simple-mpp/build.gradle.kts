plugins {
  id("com.apollographql.apollo3")
  id("org.jetbrains.kotlin.multiplatform")
}

configureMppTestsDefaults()

kotlin {
  sourceSets {
    val commonMain by getting {
      dependencies {
        implementation("com.apollographql.apollo3:apollo-runtime")
        implementation("com.apollographql.apollo3:apollo-normalized-cache")
      }
    }

    val commonTest by getting {
      dependencies {
        implementation("com.apollographql.apollo3:apollo-mockserver")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")
      }
    }
  }
}

apollo {
  packageName.set("com.example")
}