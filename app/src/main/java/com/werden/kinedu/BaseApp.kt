package com.werden.kinedu

import android.app.Application
import com.werden.kinedu.di.component.ApplicationComponent
import com.werden.kinedu.di.component.DaggerApplicationComponent
import com.werden.kinedu.di.module.ApplicationModule

class BaseApp: Application() {

    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        instance = this
        setup()

        if (BuildConfig.DEBUG) {
        }
    }

    private fun setup() {
        component = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        component.inject(this)
    }

    fun getApplicationComponent(): ApplicationComponent {
        return component
    }

    companion object {
        lateinit var instance: BaseApp private set
    }
}