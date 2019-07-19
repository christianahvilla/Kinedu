package com.werden.kinedu.di.module

import android.app.Activity
import com.werden.kinedu.api.ApiServiceInterface
import com.werden.kinedu.ui.article.detailed.DetailedContract
import com.werden.kinedu.ui.article.detailed.DetailedPresenter
import com.werden.kinedu.ui.home.HomeContract
import com.werden.kinedu.ui.home.HomePresenter
import dagger.Module
import dagger.Provides

/**
 * Module which provides all required dependencies about Activity
 */
@Module
// Safe here as we are dealing with a Dagger 2 module
@Suppress("unused")
class ActivityModule(private var activity: Activity) {

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

    /**
     * Provides the Application HomeActivity
     * @return the HomePresenter to provided
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

