plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.devkaybee.treyq"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.devkaybee.treyq"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    buildFeatures{
        viewBinding = true
    }


}

dependencies {

    // Added Dependencies
    implementation("com.google.firebase:firebase-auth:22.2.0")
    implementation("com.google.firebase:firebase-database:20.3.0")
    // Added dependencies components
    val lifecycleVersion  = "2.6.2"
    val navVersion = "2.7.5"

    // Retrofit Dependencies
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    // Gson converter factory
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    // Picasso-photo library
    implementation ("com.squareup.picasso:picasso:2.8")

    //LiveData
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion")
    //View model
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")

    // lottie-animation
    implementation ("com.airbnb.android:lottie:6.0.0")
    //circular-image-view
    implementation ("de.hdodenhof:circleimageview:3.1.0")

    implementation ("com.squareup.okhttp3:logging-interceptor:4.2.1")
    //swipeRefresh-layout
    implementation ("androidx.swiperefreshlayout:swiperefreshlayout:1.2.0-alpha01")

    //Navigation-component
    implementation ("androidx.navigation:navigation-fragment-ktx:$navVersion")
    implementation ("androidx.navigation:navigation-ui-ktx:$navVersion")

    // RecyclerView Component
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation("androidx.recyclerview:recyclerview-selection:1.1.0")

    //Paho MQTT
    implementation ("org.eclipse.paho:org.eclipse.paho.client.mqttv3:1.2.4")
    implementation ("org.eclipse.paho:org.eclipse.paho.android.service:1.1.1")

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}