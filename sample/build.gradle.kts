plugins {
    id("common")
}

dependencies {
}

kotlin {
    js {
        browser {
        }
        binaries.executable()
    }
    sourceSets["commonMain"].dependencies {
        implementation(project(":renlin-router"))
    }
    sourceSets["commonTest"].dependencies {
    }
    sourceSets["jvmMain"].dependencies {
    }
    sourceSets["jvmTest"].dependencies {
    }
    sourceSets["jsMain"].dependencies {
    }
    sourceSets["jsTest"].dependencies {
    }
}

