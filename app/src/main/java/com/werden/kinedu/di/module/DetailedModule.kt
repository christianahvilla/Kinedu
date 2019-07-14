package com.werden.kinedu.di.module

import android.app.Activity
import com.werden.kinedu.api.ApiServiceInterface
import dagger.Module
import dagger.Provides

/**
 * Module which provides all required dependencies about DetailedActivity
 */
@Module
// Safe here as we are dealing with a Dagger 2 module
@Suppress("unused")
class DetailedModule {

    /**
     * Provides the Application Activity
     * @return the Activity to be provided
     */
    @Provides
    fun provideActivity(): Activity {
        return activity
    }

    /**
     * Provides the Application DetailedActivity
     * @return the DetailedPresenter to provided
     */
    @Provides
    fun provideDetailedPresenter(): DetailedContract.Presenter {
        return DetailedPresenter()
    }

    /**
     * Provides the HTTP connections for activity
     * @return the ApiService to provided
     */
    @Provides
    fun provideApiService(): ApiServiceInterface {
        return ApiServiceInterface.create()
    }
}