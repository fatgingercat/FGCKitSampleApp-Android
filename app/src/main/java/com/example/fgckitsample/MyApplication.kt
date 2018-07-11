package com.example.fgckitsample

import android.app.Application
import cat.fatginger.fgckit.FGCKit

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        FGCKit.start("key", "AppId")
    }
}