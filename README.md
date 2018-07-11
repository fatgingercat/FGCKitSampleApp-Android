# FGCKitSampleApp-Android

Sample application using the FGCKit for Android, which enables developers to easily embed FGC content in native apps.

## Prerequisites

- Android Studio 2+
- Android 5.0+

## Installation

### Gradle

In your root build.gradle, at the end of repositories add: 
```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

In your application build.gradle file add the dependency:

```
 implementation 'com.github.fatgingercat:FGCKit-Android:1.0.2.1'
```

### Android Manifest

Add permission for internet access:
```
 <uses-permission android:name="android.permission.INTERNET"/>
```

The FGCKit only supports landscape mode so be sure to include ```android:screenOrientation="landscape"``` in the activity that's using the Kit.

### Proguard

If you're applying obfuscation to your application be sure to add the following to your proguard-rules.pro file:
```
-dontwarn retrofit2.Platform$Java8
-keepattributes Signature
-keepattributes Exceptions

-dontwarn okhttp3.**
-dontwarn okio.**
-dontwarn javax.annotation.**

-keepnames class okhttp3.internal.publicsuffix.PublicSuffixDatabase
```

