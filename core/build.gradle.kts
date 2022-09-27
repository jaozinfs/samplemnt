plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlin)
}

android {
    compileSdk = ProjectVersions.compileSdk
    namespace = "br.com.sodep.core"

    defaultConfig {
        minSdk = ProjectVersions.minSdk
        targetSdk = ProjectVersions.targetSdk
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    androidDependencies.forEach {
        implementation(it)
    }
    testImplementation(UnitaryTestDependency.jUnit)
}