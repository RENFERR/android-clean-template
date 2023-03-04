object Dependencies {

    object Project {
        const val buildSrc = ":buildSrc"
        const val domain = ":domain"
        const val data = ":data"
    }

    object Android {
        const val coreKtx = "androidx.core:core-ktx:1.9.0"
        const val appCompat = "androidx.appcompat:appcompat:1.6.1"
    }

    object Lifecycle {
        const val lifecycleKtx = "androidx.lifecycle:lifecycle-runtime-ktx:2.3.1"
        const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1"
        const val activityCompose = "androidx.activity:activity-compose:1.6.1"
    }

    object Compose {
        const val version = "1.3.2"
        private const val iconsVersion = "1.3.1"

        const val ui = "androidx.compose.ui:ui:$version"
        const val material3 = "androidx.compose.material3:material3:1.0.1"
        const val materialIcons = "androidx.compose.material:material-icons-core:$iconsVersion"
        const val materialIconsExtended = "androidx.compose.material:material-icons-extended:$iconsVersion"
        const val tooling = "androidx.compose.ui:ui-tooling-preview:$version"
        const val livedata = "androidx.compose.runtime:runtime-livedata:$version"

        const val manifest = "androidx.compose.ui:ui-test-manifest:$version"
        const val toolingTest = "androidx.compose.ui:ui-tooling:$version"
        const val uiTest = "androidx.compose.ui:ui-test-junit4:$version"

        object Accompanist {
            const val version = "0.28.0"
            const val permissions = "com.google.accompanist:accompanist-permissions:$version"
            const val swiperefresh = "com.google.accompanist:accompanist-swiperefresh:$version"
        }
    }

    object Navigation {
        const val navigationCompose = "androidx.navigation:navigation-compose:2.5.3"
    }

    object Hilt {
        const val version = "2.44"
        const val android = "com.google.dagger:hilt-android:$version"
        const val navigation = "androidx.hilt:hilt-navigation-compose:1.0.0"
        const val compiler = "com.google.dagger:hilt-compiler:$version"
    }

    object Network {
        private const val retrofitVersion = "2.9.0"
        private const val okHttpVersion = "4.10.0"
        const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"
        const val gson = "com.google.code.gson:gson:$retrofitVersion"
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:$retrofitVersion"
        const val okHttp = "com.squareup.okhttp3:okhttp:$okHttpVersion"
        const val okHttpInterceptor = "com.squareup.okhttp3:logging-interceptor:$okHttpVersion"

    }

    object Room {
        private const val version = "2.5.0"
        const val ktx = "androidx.room:room-ktx:$version"
        const val runtime = "androidx.room:room-runtime:$version"
        const val paging = "androidx.room:room-paging:$version"
        const val compiler = "androidx.room:room-compiler:$version"
    }

    object Test {
        const val jUnit = "junit:junit:4.+"
        const val androidJUnit = "androidx.test.ext:junit:1.1.5"
        const val androidJUnitKtx = "androidx.test.ext:junit-ktx:1.1.5"
        const val espresso = "androidx.test.espresso:espresso-core:3.5.1"
    }
}