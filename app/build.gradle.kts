import java.io.FileInputStream
import java.util.Properties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
    id ("com.google.dagger.hilt.android")
}

val apikeyPropertiesFile: File = rootProject.file("key.properties")
val apikeyProperties = Properties()
apikeyProperties.load(FileInputStream(apikeyPropertiesFile))
val xApiKey = apikeyProperties.getProperty("X_API_KEY")


android {
    namespace = "com.project.digikala"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.project.digikala"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        buildConfigField("String", "X_API_KEY", "\"$xApiKey\"")

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    buildFeatures {
        buildConfig = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.3")
    implementation("androidx.activity:activity-compose:1.9.0")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.material:material:1.4.3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    //retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.10.0")

    //room
    implementation("androidx.room:room-runtime:2.6.1")
    kapt("androidx.room:room-compiler:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")

    //datastore
    implementation("androidx.datastore:datastore-preferences:1.0.0")

    //hilt di
    implementation("com.google.dagger:hilt-android:2.46")
    kapt("com.google.dagger:hilt-compiler:2.46")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")

    //compose navigation
    implementation("androidx.navigation:navigation-compose:2.6.0-alpha04")

    //animation
    implementation("com.airbnb.android:lottie-compose:5.2.0")

    //coil - load image from url
    implementation("io.coil-kt:coil-compose:2.0.0-rc01")

    //swipe refresh
    implementation("com.google.accompanist:accompanist-swiperefresh:0.27.0")

    //system ui controller
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.28.0")

    //Accompanist-Pager
    implementation ("com.google.accompanist:accompanist-pager:0.29.0-alpha")
    implementation ("com.google.accompanist:accompanist-pager-indicators:0.29.0-alpha")

}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}
