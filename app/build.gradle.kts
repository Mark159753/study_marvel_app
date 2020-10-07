import org.jetbrains.kotlin.config.KotlinCompilerVersion

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdkVersion(29)
    buildToolsVersion = "30.0.0"

    defaultConfig {
        applicationId = "com.example.modulartest"
        minSdkVersion(23)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    compileOptions{
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions{
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(kotlin("stdlib", KotlinCompilerVersion.VERSION))
    implementation("androidx.core:core-ktx:1.3.1")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.1")
    testImplementation("junit:junit:4.12")
    androidTestImplementation("androidx.test.ext:junit:1.1.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")

    implementation(AndroidKotlin.fragmentKtx)
    //MaterialDesign
    implementation(AndroidKotlin.materialDesign)
    //Paging 3 lib
    implementation(Paging3.paging)

    kotlinCoroutines()
    liveData()
    retrofit()
    dagger()
    room()
    navigationComponents()
    //Picasso
    implementation(Picasso.picasso)

    implementation(project(":domain"))
    implementation(project(":data"))
    implementation(project(":home_details_future"))
}