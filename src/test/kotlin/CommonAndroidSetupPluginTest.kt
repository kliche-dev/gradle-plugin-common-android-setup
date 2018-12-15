package com.github.liminal.kliche.plugin.android.common

import org.gradle.testkit.runner.BuildResult
import org.gradle.testkit.runner.GradleRunner
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder
import java.io.File

class CommonAndroidSetupPluginTest {
    @Rule
    @JvmField
    val temporaryFolder = TemporaryFolder()


    @Test
    fun `test to be implemented later`() {
//        val message = "Hello, TestKit!"
//
//        givenBuildScript("""
//            buildscript {
//                  repositories {
//                        jcenter()
//                        google()
//                    }
//                  dependencies {
//                        classpath("com.android.tools.build:gradle:3.2.0")
//                    }
//            }
//
//            plugins {
//                id("com.android.library")
//                id("apetools.common-android-setup")
//            }
//
//            commonAndroidSetup {
//                baseAndroidSetup {
//                    compileSdkVersion(28)
//                }
//            }
//        """)
//        assertThat(
//                build("build", "-q").output.trimEnd(),
//                equalTo(message))

    }

    private
    fun build(vararg arguments: String): BuildResult =
            GradleRunner
                    .create()
                    .withProjectDir(temporaryFolder.root)
                    .withPluginClasspath()
                    .withArguments(*arguments)
//            .withDebug(true)
                    .build()


    private
    fun givenBuildScript(script: String) =
            newFile("build.gradle").apply {
                writeText(script)
            }

    private
    fun newFile(fileName: String): File =
            temporaryFolder.newFile(fileName)


}
