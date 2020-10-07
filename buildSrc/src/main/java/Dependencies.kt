object Versions{
    const val kotlin_version = "1.4.10"
    const val androidxCore = "1.3.1"
    const val androidxAppcompat = "1.2.0"
    const val constraintlayout_2 = "2.0.1"

    const val junit = "4.12"
    const val androidJunit = "1.1.2"
    const val espressoCore = "3.3.0"

    const val materialDesign ="1.2.1"

    const val navigation = "2.3.0"

    const val lifecycle = "2.2.0"

    const val room = "2.3.0-alpha02"

    const val coroutinesCore = "1.3.9"

    const val picasso = "2.71828"

    const val dagger = "2.29.1"

    const val retrofit = "2.9.0"
    const val okhttp = "4.9.0"

    const val hilt = "2.29.1-alpha"

    const val paging_version = "3.0.0-alpha06"

    const val fragmentKtx = "1.2.5"
}

object AndroidKotlin{
    val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin_version}"
    val androidxCore = "androidx.core:core-ktx:${Versions.androidxCore}"
    val androidxAppcompat = "androidx.appcompat:appcompat:${Versions.androidxAppcompat}"
    val constraintlayout_2 = "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout_2}"
    val materialDesign = "com.google.android.material:material:${Versions.materialDesign}"

    val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"

}

object AndroidTesting{
    val junit = "junit:junit:${Versions.junit}"
    val androidJunit = "androidx.test.ext:junit:${Versions.androidJunit}"
    val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
}

object NavigationComponents{
    val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    val navigationDynamicFeatures = "androidx.navigation:navigation-dynamic-features-fragment:${Versions.navigation}"
    val navigationTesting = "androidx.navigation:navigation-testing:${Versions.navigation}" //androidTestImplementation

    val navClasspathSafeArg = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"//classpath
}

object LiveData{
    val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    val lifecycleLivedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}" //kapt
    val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
}

object Room{
    val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    val roomCompiler = "androidx.room:room-compiler:${Versions.room}"//kapt
    val room = "androidx.room:room-ktx:${Versions.room}"
    val roomTest = "androidx.room:room-testing:${Versions.room}"//androidTestImplementation
}

object KotlinCoroutines{
    val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesCore}"
    val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesCore}"
}

object Picasso{
    val picasso = "com.squareup.picasso:picasso:${Versions.picasso}"
}

object Dagger{
    val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"//kapt
}

object Retrofit{
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    val okhttp3Interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
}

object Hilt{
    val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    val hiltViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hilt}"
    val hiltCompiler = "androidx.hilt:hilt-compiler:${Versions.hilt}"//kapt
    val hiltDaggerCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    val hiltClasspath = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"//classpath
}

object Paging3{
    val paging = "androidx.paging:paging-runtime:${Versions.paging_version}"
}

