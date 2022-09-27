plugins {
    id(Plugins.androidApplication)
    id(Plugins.kotlin)
}

android {
    compileSdk = ProjectVersions.compileSdk
    buildToolsVersion = ProjectVersions.buildToolsVersion
    this.buildFeatures
    defaultConfig {
        applicationId = "br.com.sodep.minetrackrwrk"
        minSdk = ProjectVersions.minSdk
        targetSdk = ProjectVersions.targetSdk
        versionCode = ProjectVersions.versionCode
        versionName = ProjectVersions.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.1"
        kotlinCompilerVersion = "1.4.21"
    }
}

dependencies {
    implementation(project(":core"))
    androidDependencies.forEach {
        implementation(it)
    }
    testImplementation(UnitaryTestDependency.jUnit)
    androidTestImplementation(AndroidTestDependency.jUnit)
    androidTestImplementation(AndroidTestDependency.espressoCore)
}