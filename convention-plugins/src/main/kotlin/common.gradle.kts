import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
  kotlin("multiplatform")
}



repositories {
  mavenCentral()
  mavenLocal()
}

kotlin {
  jvm {
    @OptIn(ExperimentalKotlinGradlePluginApi::class)
    compilerOptions {
      freeCompilerArgs = listOf("-Xjsr305=strict")
    }
  }
  js {
    browser {
      testTask {
        useKarma {
          useChromeHeadless()
        }
      }
    }
  }
  sourceSets["commonMain"].dependencies {
    implementation("net.kigawa:hakate:3.3.1")
    implementation("net.kigawa:renlin:1.3.1")
  }
  sourceSets["commonTest"].dependencies {

  }
  sourceSets["jvmMain"].dependencies {
  }
  sourceSets["jvmTest"].dependencies {
// https://mvnrepository.com/artifact/org.jetbrains.kotlin/kotlin-test-junit
    implementation("org.jetbrains.kotlin:kotlin-test-junit:${Version.KOTLIN}")
  }

  sourceSets["jsMain"].dependencies {
    // https://mvnrepository.com/artifact/org.jetbrains.kotlin/kotlin-stdlib-js
    implementation("org.jetbrains.kotlin:kotlin-stdlib-js:${Version.KOTLIN}")
  }
  sourceSets["jsTest"].dependencies {
    implementation(kotlin("test-js"))
  }
}