plugins {
    id("common-library")
}

android {
    defaultConfig {
        minSdk = 21
        compileSdk = 30
        targetSdk = 30

        testInstrumentationRunner = "com.karumi.shot.ShotTestRunner"
        testApplicationId = "com.vanpra.composematerialdialogs.color.test"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                    getDefaultProguardFile("proguard-android.txt"),
                    "proguard-rules.pro"
            )
        }
    }

    buildFeatures.compose = true

    packagingOptions.excludes.addAll(
        listOf(
            "META-INF/LICENSE",
            "META-INF/AL2.0",
            "META-INF/**",
            "META-INF/*.kotlin_module"
        )
    )

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Dependencies.AndroidX.Compose.version
    }
}

dependencies {
    api(project(":core"))
}

shot {
    tolerance = 1.0 // Tolerance needed for CI
}

mavenPublish {
    sonatypeHost = com.vanniktech.maven.publish.SonatypeHost.S01
}
