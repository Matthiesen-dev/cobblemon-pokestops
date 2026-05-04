import org.gradle.kotlin.dsl.invoke
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    id("java")
    id("java-library")
    kotlin("jvm") version("2.2.20")
    id("com.gradleup.shadow") version "9.3.1" apply false
    id("dev.architectury.loom") version("1.11-SNAPSHOT") apply false
    id("architectury-plugin") version("3.4-SNAPSHOT") apply false
}

allprojects {
    apply(plugin = "java")
    apply(plugin = "org.jetbrains.kotlin.jvm")

    version = project.properties["mod_version"]!!
    group = project.properties["maven_group"]!!

    repositories {
        mavenCentral()
        maven("https://artefacts.cobblemon.com/releases/")
        maven("https://repo.spongepowered.org/repository/maven-public")
        maven("https://dl.cloudsmith.io/public/geckolib3/geckolib/maven/")
        maven("https://api.modrinth.com/maven")
    }

    tasks {
        test {
            useJUnitPlatform()
        }

        java {
            withSourcesJar()
            sourceCompatibility = JavaVersion.VERSION_21
            targetCompatibility = JavaVersion.VERSION_21
        }

        compileJava {
            options.release = 21
        }

        compileKotlin {
            compilerOptions {
                jvmTarget.set(JvmTarget.JVM_21)
            }
        }
    }
}

tasks.register<Copy>("copyJars") {
    group = "build"
    description = "Copies JAR files from fabric and neoforge to output directory"

    from("./common/build/libs/") {
        include("*-sources.jar")
    }
    from("./fabric/build/libs/") {
        include("*.jar")
        exclude("*-dev-shadow.jar")
    }
    from("./neoforge/build/libs/") {
        include("*.jar")
        exclude("*-dev-shadow.jar")
    }
    into("./output/")

    doFirst {
        delete(fileTree("./output/") {
            include("**/*")
        })
        file("./output/").mkdirs()
    }
}
