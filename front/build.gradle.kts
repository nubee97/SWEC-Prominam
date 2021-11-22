plugins {
    kotlin("js") version "1.6.0"
}

repositories {
    mavenCentral()
}

dependencies {
}

kotlin {
    js{
        borwser{
            distribution {
                directory = File("$projectDir/node/")
            }
        }
        binaries.executable()
    }
}