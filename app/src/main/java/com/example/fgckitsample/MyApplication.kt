package com.example.fgckitsample

import android.app.Application
import cat.fatginger.fgckit.FGCKit

import com.facebook.drawee.backends.pipeline.Fresco

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        FGCKit.start("key", "AppId")
        Fresco.initialize(this)
    }
}