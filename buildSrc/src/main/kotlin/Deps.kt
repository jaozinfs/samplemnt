object AndroidDependency {
    const val androidCoreKtx = "androidx.core:core-ktx:${AndroidVersions.androidCoreKtx}"
    const val appCompat = "androidx.appcompat:appcompat:${AndroidVersions.appCompat}"
    const val material = "com.google.android.material:material:${AndroidVersions.material}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${AndroidVersions.constraintLayout}"

    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${AndroidVersions.navigationComponent}"
    const val navigationKtx = "androidx.navigation:navigation-ui-ktx:${AndroidVersions.navigationComponent}"
    // Koin Core features
    const val koin = "io.insert-koin:koin-core:${KoinVersions.koin_version}"
}

object ComposeDependencies {
    val composeUi by lazy { "androidx.compose.ui:ui:${AndroidVersions.compose}" }
    val composeUiTooling by lazy { "androidx.compose.ui:ui-tooling:${AndroidVersions.compose}" }
    val composeUiToolingPreview by lazy { "androidx.compose.ui:ui-tooling-preview:${AndroidVersions.compose}" }
    val composeFoundation by lazy { "androidx.compose.foundation:foundation:${AndroidVersions.compose}" }
    val composeMaterial by lazy { "androidx.compose.material:material:${AndroidVersions.compose}" }
    val composeMaterialIcons by lazy { "androidx.compose.material:material-icons-core:${AndroidVersions.compose}" }
    val composeMaterialIconsExtended by lazy { "androidx.compose.material:material-icons-extended:${AndroidVersions.compose}" }
    val composeRuntimeLiveData by lazy { "androidx.compose.runtime:runtime-livedata:${AndroidVersions.compose}" }
    val composeActivity by lazy { "androidx.activity:activity-compose:${AndroidVersions.composeActivity}" }
    val composeLifecycleViewModel by lazy { "androidx.lifecycle:lifecycle-viewmodel-compose:${AndroidVersions.composeLifecycleViewModel}" }

    val all by lazy {
        listOf(
            composeUi,
            composeUiTooling,
            composeUiToolingPreview,
            composeFoundation,
            composeMaterial,
            composeMaterialIcons,
            composeMaterialIconsExtended,
            composeRuntimeLiveData,
            composeActivity,
            composeLifecycleViewModel
        )
    }
}

val androidDependencies = listOf(
    AndroidDependency.androidCoreKtx,
    AndroidDependency.appCompat,
    AndroidDependency.material,
    AndroidDependency.constraintLayout,
    AndroidDependency.navigationFragment,
    AndroidDependency.navigationKtx,
    AndroidDependency.koin
) + ComposeDependencies.all


object UnitaryTestDependency {
    const val jUnit = "junit:junit:${UnitaryVersions.jUnit}"
}

object AndroidTestDependency {
    const val jUnit = "androidx.test.ext:junit:${AndroidTestVersions.jUnit}"
    const val espressoCore =
        "androidx.test.espresso:espresso-core:${AndroidTestVersions.espressoCore}"
}