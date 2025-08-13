plugins {
    id("io.github.gradle-nexus.publish-plugin")
}
object Conf {
    const val GROUP = "net.kigawa"
    const val VERSION = "1.0.0"
}

group = Conf.GROUP
version = Conf.VERSION
allprojects {
    group = Conf.GROUP
    version = Conf.VERSION
}

nexusPublishing {
    // Configure maven central repository
    // https://github.com/gradle-nexus/publish-plugin#publishing-to-maven-central-via-sonatype-ossrh
    repositories {
        sonatype {
            nexusUrl.set(uri("https://s01.oss.sonatype.org/service/local/"))
            snapshotRepositoryUrl.set(uri("https://s01.oss.sonatype.org/content/repositories/snapshots/"))
            username.set(System.getenv("ORG_GRADLE_PROJECT_sonatypeUsername") ?: project.findProperty("sonatypeUsername") as String?)
            password.set(System.getenv("ORG_GRADLE_PROJECT_sonatypePassword") ?: project.findProperty("sonatypePassword") as String?)
        }
    }
}
