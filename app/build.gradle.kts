plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("kapt")
}

repositories {
    google()
    mavenCentral()
}

android {
    namespace = "${Config.namespace}.application"
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
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
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    // Project
    implementation(project(Dependencies.Project.domain))
    implementation(project(Dependencies.Project.data))

    // Android
    implementation(Dependencies.Android.appCompat)
    implementation(Dependencies.Android.coreKtx)

    // Lifecycle
    implementation(Dependencies.Lifecycle.lifecycleKtx)
    implementation(Dependencies.Lifecycle.activityCompose)
    implementation(Dependencies.Lifecycle.viewModelCompose)

    // Navigation
    implementation(Dependencies.Navigation.navigationCompose)

    // Compose
    implementation(Dependencies.Compose.material3)
    implementation(Dependencies.Compose.ui)
    implementation(Dependencies.Compose.livedata)
    implementation(Dependencies.Compose.materialIcons)
    implementation(Dependencies.Compose.materialIconsExtended)
    implementation(Dependencies.Compose.tooling)
    implementation(Dependencies.Compose.Accompanist.permissions)
    implementation(Dependencies.Compose.Accompanist.swiperefresh)
    debugImplementation(Dependencies.Compose.toolingTest)
    debugImplementation(Dependencies.Compose.manifest)

    // Hilt
    implementation(Dependencies.Hilt.android)
    implementation(Dependencies.Hilt.navigation)
    kapt(Dependencies.Hilt.compiler)

    // Tests
    testImplementation(Dependencies.Test.jUnit)
    androidTestImplementation(Dependencies.Test.androidJUnit)
    androidTestImplementation(Dependencies.Test.androidJUnitKtx)
    androidTestImplementation(Dependencies.Test.espresso)
    androidTestImplementation(Dependencies.Compose.uiTest)
}