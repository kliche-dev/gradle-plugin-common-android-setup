# Common Android Setup

Reduces duplication of project setup in android multi-module projects by allowing you to 
share common setup through a project extension

## Getting Started

add the plugin to your root `build.gradle`

```gradle
plugins {
  id "kliche.common-android-setup" version "0.7.0"
}

```

and then configure shared android settings using the `CommonAndroidSetupExtension`

### example: 

Add this to the root build.gradle

```gradle

commonAndroidSetup {
    android {
        compileSdkVersion 28

        defaultConfig {
            minSdkVersion 21
            targetSdkVersion 28
            versionCode 1
            versionName "1.0"

            testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
        }

        buildTypes {
            release {
                minifyEnabled false
                proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
            }
        }

    }
}

```

And those settings will be applied to all the android modules in the project and you don't have
to remember to add all these settings to each module.

The `android` block is applied to all android modules. 
If you want to have specific configuration for app, lib or feature-modules you can add 
`androidApps`, `androidLibs` and `androidFeatures` blocks respectively.

And if you want to override anything for any specific module you can just add your setup
in the `android` block in that modules `build.gradle` like normal. Anything in the
modules `build.gradle` will be applied after the commonAndroidSetup so overriding is simple.


## License

This project is licensed under the Apache 2 License - see the [LICENSE](LICENSE) file for details

