package com.d121211041.jadwalsholat

import android.app.Application
import com.d121211041.jadwalsholat.data.AppContainer
import com.d121211041.jadwalsholat.data.DefaultAppContainer


class MyApplication: Application()  {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}
