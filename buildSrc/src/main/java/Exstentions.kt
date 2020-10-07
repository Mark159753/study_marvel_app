import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.dagger(){
    implementation(Dagger.dagger)
    kapt(Dagger.daggerCompiler)
}

fun DependencyHandler.room(){
    implementation(Room.room)
    implementation(Room.roomRuntime)
    androidTestImplementation(Room.roomTest)
    kapt(Room.roomCompiler)
}

fun DependencyHandler.retrofit(){
    implementation(Retrofit.retrofit)
    implementation(Retrofit.gsonConverter)
    implementation(Retrofit.okhttp3Interceptor)
}

fun DependencyHandler.navigationComponents(){
    implementation(NavigationComponents.navigationDynamicFeatures)
    implementation(NavigationComponents.navigationUi)
    implementation(NavigationComponents.navigationFragment)
    androidTestImplementation(NavigationComponents.navigationTesting)
}

fun DependencyHandler.liveData(){
    implementation(LiveData.lifecycleLivedata)
    implementation(LiveData.lifecycleExtensions)
    implementation(LiveData.lifecycleRuntime)
    implementation(LiveData.lifecycleViewModel)
    kapt(LiveData.lifecycleCompiler)
}

fun DependencyHandler.kotlinCoroutines(){
    implementation(KotlinCoroutines.coroutinesAndroid)
    implementation(KotlinCoroutines.coroutinesCore)
}

fun DependencyHandler.androidKotlin(){
    implementation(AndroidKotlin.androidxAppcompat)
    implementation(AndroidKotlin.androidxCore)
    implementation(AndroidKotlin.kotlinStdlib)
    implementation(AndroidKotlin.constraintlayout_2)
}

fun DependencyHandler.androidTesting(){
    testImplementation(AndroidTesting.junit)
    androidTestImplementation(AndroidTesting.androidJunit)
    androidTestImplementation(AndroidTesting.espressoCore)
}

private fun DependencyHandler.testImplementation(depName: String){
    add("testImplementation", depName)
}

private fun DependencyHandler.androidTestImplementation(depName: String){
    add("androidTestImplementation", depName)
}

private fun DependencyHandler.implementation(depName: String) {
    add("implementation", depName)
}
private fun DependencyHandler.kapt(depName: String) {
    add("kapt", depName)
}
private fun DependencyHandler.compileOnly(depName: String) {
    add("compileOnly", depName)
}
private fun DependencyHandler.api(depName: String) {
    add("api", depName)
}