package com.werden.kinedu.di.component

import com.werden.kinedu.BaseApp
import com.werden.kinedu.di.module.ApplicationModule
import dagger.Component

/**
 * Component providing inject() methods for presenters.
 */
@Component(modules = [(ApplicationModule::class)])
interface ApplicationComponent {
    /**
     * Injects required dependencies into the specified Application.
     * @param application in which to inject the dependencies
     */
    fun inject(application: BaseApp)
}