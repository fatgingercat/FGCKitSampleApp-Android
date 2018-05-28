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

In your application gradle file add the dependency:

```
 implementation 'com.github.fatgingercat:FGCKit-Android:0.0.6'
```

### Android Manifest

Add permission for internet access:
```
 <uses-permission android:name="android.permission.INTERNET"/>
```
