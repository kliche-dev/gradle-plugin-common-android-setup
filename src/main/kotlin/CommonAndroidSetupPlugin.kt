package com.github.liminal.kliche.plugin.android.common

import com.android.build.gradle.AppExtension
import com.android.build.gradle.BaseExtension
import com.android.build.gradle.FeatureExtension
import com.android.build.gradle.LibraryExtension
import org.gradle.api.Action
import org.gradle.api.Plugin
import org.gradle.api.Project

import org.gradle.kotlin.dsl.*


open class CommonAndroidSetupExtension {
    internal var baseAndroidConfig: Action<BaseExtension>? = null
    internal var appsAndroidConfig: Action<AppExtension>? = null
    internal var libsAndroidConfig: Action<LibraryExtension>? = null
    internal var featuresAndroidConfig: Action<FeatureExtension>? = null

    /**
     * Define common settings used by all kinds of android modules in project
     */
    fun android(conf: Action<BaseExtension>) {
        baseAndroidConfig = conf
    }

    /**
     * Define common settings used by android application modules in project
     */
    fun androidApps(conf: Action<AppExtension>) {
        appsAndroidConfig = conf
    }

    /**
     * Define common settings used by android library modules in project
     */
    fun androidLibs(conf: Action<LibraryExtension>) {
        libsAndroidConfig = conf
    }
    /**
     * Define common settings used by android feature modules in project
     */
    fun androidFeatures(conf: Action<FeatureExtension>) {
        featuresAndroidConfig = conf
    }

}

class CommonAndroidSetupPlugin : Plugin<Project> {


    private inline fun <reified T : BaseExtension> Project.applyConfig(setupFn: Action<T>) {
        configure<T> { setupFn.execute(this)}
    }


    override fun apply(project: Project): Unit = project.run {

        val extension = extensions.create<CommonAndroidSetupExtension>("commonAndroidSetup")

        allprojects {
            pluginManager.withPlugin("com.android.application") {
                extension.baseAndroidConfig?.let { setupFn -> applyConfig(setupFn) }
                extension.appsAndroidConfig?.let { setupFn -> applyConfig(setupFn) }
            }
            pluginManager.withPlugin("com.android.library") {
                extension.baseAndroidConfig?.let { setupFn -> applyConfig(setupFn) }
                extension.libsAndroidConfig?.let { setupFn -> applyConfig(setupFn) }
            }
            pluginManager.withPlugin("com.android.feature") {
                extension.baseAndroidConfig?.let { setupFn -> applyConfig(setupFn) }
                extension.featuresAndroidConfig?.let { setupFn -> applyConfig(setupFn) }

            }
        }
    }

}
