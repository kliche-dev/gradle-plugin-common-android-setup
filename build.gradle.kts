plugins {
    `kotlin-dsl`
    id("com.gradle.plugin-publish") version "0.10.1"
}

//group = "com.github.liminal.kliche"
version = "0.7.0"
description = "Plugin for applying common settings to android modules in a multi-module project"

repositories {
    google()
    mavenCentral()
}

gradlePlugin {
    @Suppress("UnstableApiUsage")
    plugins {
        register("commonAndroidSetup") {
            id = "kliche.common-android-setup"
            displayName = "Android Common Setup Plugin"
            description = project.description
            implementationClass = "com.github.liminal.kliche.plugin.android.common.CommonAndroidSetupPlugin"
        }
    }
}

// Ignore warning about using experimental features
kotlinDslPluginOptions {
    experimentalWarning.set(false)
}


dependencies {
    compile("com.android.tools.build:gradle:3.3.0")
    implementation(kotlin("gradle-plugin", "1.3.40"))

    testImplementation(gradleTestKit())
    testImplementation("junit:junit:4.12")

}

pluginBundle {
    website = "https://github.com/kliche-dev/gradle-plugin-common-android-setup"
    vcsUrl = "https://github.com/kliche-dev/gradle-plugin-common-android-setup.git"

    (plugins) {
        "commonAndroidSetup" {
            displayName = "Android Common Setup Plugin"
            tags = listOf("android")
        }
    }
}
