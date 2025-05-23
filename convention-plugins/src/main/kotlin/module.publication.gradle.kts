plugins {
    `maven-publish`
    signing
}

publishing {
    // Configure all publications
    publications.withType<MavenPublication> {
        // disabled https://github.com/vanniktech/gradle-maven-publish-plugin/issues/754
        // and configured at library build.gradle.kts using `JavadocJar.Dokka("dokkaHtml")`.
        /*
        // Stub javadoc.jar artifact
        artifact(tasks.register("${name}JavadocJar", Jar::class) {
            archiveClassifier.set("javadoc")
            archiveAppendix.set(this@withType.name)
        })*/

        // Provide artifacts information required by Maven Central
        pom {
            name = "renlin-router"
            description = "routing library for renlin"
            url = "https://github.com/Code-Sakura/renlin-router"
            properties = mapOf(
            )
            licenses {
                license {
                    name.set("MIT License")
                    url.set("http://www.opensource.org/licenses/mit-license.php")
                }
            }
            developers {
                developer {
                    id.set("net.kigawa")
                    name.set("kigawa")
                    email.set("contact@kigawa.net")
                }
                developer {
                    id.set("io.github.seizavl")
                    name.set("seizavl")
                    email.set("")
                }
            }
            scm {
                connection.set("scm:git:https://github.com/Code-Sakura/renlin-router.git")
                developerConnection.set("scm:git:https://github.com/Code-Sakura/renlin-router.git")
                url.set("https://github.com/Code-Sakura/renlin-router")
            }
        }
    }
}

signing {
    if (project.hasProperty("mavenCentralUsername") ||
        System.getenv("ORG_GRADLE_PROJECT_mavenCentralUsername") != null
    ) {
        useGpgCmd()
        // It is not perfect (fails at some dependency assertions), better handled as
        // `signAllPublications()` (as in vanniktech maven publish plugin) at build.gradle.kts.
        //sign(publishing.publications)
    }
}
