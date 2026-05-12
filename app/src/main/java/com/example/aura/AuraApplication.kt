package com.example.aura

import android.app.Application
import com.example.aura.data.AppContainer
import com.example.aura.data.AppDataContainer

class AuraApplication : Application() {
    /**
     * AppContainer instance used by the rest of classes to obtain dependencies
     */
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}
