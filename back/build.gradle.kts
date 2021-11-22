plugins {
    kotlin("js") version "1.6.0"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(npm("express", "4.17.1"))
}

kotlin {
    js{
        nodejs{}
        binaries.executable()
    }
}