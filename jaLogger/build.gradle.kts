import com.vanniktech.maven.publish.SonatypeHost
import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    id("com.vanniktech.maven.publish") version "0.28.0"
}

kotlin {
    targetHierarchy.default()

    androidTarget {
        publishLibraryVariants("release")
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
        publishLibraryVariants("release", "debug")
    }
    val xcf = XCFramework()
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64(),
    ).forEach {
        it.binaries.framework {
            baseName = "jaLogger"
            isStatic = true
            xcf.add(this)
        }
    }


    sourceSets {
        val commonMain by getting {
            dependencies {
                //put your multiplatform dependencies here
            }
        }

    }
}

android {
    namespace = "io.github.devggaurav"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}

mavenPublishing {
    coordinates(
        groupId = "io.github.devggaurav",
        artifactId = "jaLogger",
        version = "1.0.0"
    )

    // Configure POM metadata for the published artifact
    pom {
        name.set("JaLogger KMP")
        description.set("Library used to print logs on both Android/iOS.")
        inceptionYear.set("2024")
        url.set("https://github.com/devggaurav/JAloggerlib")

        licenses {
            license {
                name.set("Apache-2.0 license")
                url.set(" http://www.apache.org/licenses/")
            }
        }

        // Specify developers information
        developers {
            developer {
                id.set("devggaurav")
                name.set("Gaurav")
                email.set("dev.gauravchauhan@gmail.com")
            }
        }

        // Specify SCM information
        scm {
            url.set("https://github.com/devggaurav/JAloggerlib")
        }
    }

    // Configure publishing to Maven Central
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

    // Enable GPG signing for all publications
    signAllPublications()
}



task("testClasses") {}
