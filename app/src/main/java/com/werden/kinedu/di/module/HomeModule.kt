package com.werden.kinedu.di.module

import android.app.Activity
import com.werden.kinedu.ui.home.HomeContract
import com.werden.kinedu.ui.home.HomePresenter
import dagger.Module
import dagger.Provides

/**
 * Module which provides all required dependencies about HomeActivity
 */
@Module
// Safe here as we are dealing with a Dagger 2 module
@Suppress("unused")
class HomeModule(private var activity: Activity) {
    /**
     * Provides the Application Activity
     * @return the Activity to be provided
     */
    @Provides
    fun provideActivity(): Activity {
        return activity
    }

    /**
     * Provides the Application HomeActivity
     * @return the HomePresenter to provided
     */
    @Provides
    fun provideHomePresenter(): HomeContract.Presenter {
        return HomePresenter()
    }

}