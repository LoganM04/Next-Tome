package com.lmcoding.nexttome

import android.app.Application
import com.lmcoding.nexttome.di.AppKoin

class NextTomeApp : Application() {
    override fun onCreate() {
        super.onCreate()
        AppKoin.init()
    }
}