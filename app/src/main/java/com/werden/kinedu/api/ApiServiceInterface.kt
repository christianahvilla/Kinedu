package com.werden.kinedu.api

import com.werden.kinedu.model.activity.Activity
import com.werden.kinedu.model.article.Article
import com.werden.kinedu.model.detailed.Detailed
import com.werden.kinedu.utils.BASE_URL
import io.reactivex.Observable
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * The interface which provides methods to get result of webservices
 */

interface ApiServiceInterface {
    /**
     * Get the list of the articles from the API
     */
    @GET("/articles")
    fun getArticles(): Observable<List<Article>>

    /**
     * Get the list of the articles from the API
     */
    @GET("/a")
    fun getArticleDetailed(): Observable<Detailed>

    /**
     * Get the list of the articles from the API
     */
    @GET("/activity")
    fun getActivities(): Observable<List<Activity>>

    /*
    * It is just an object associated to the interface has one singleton instance
     */
    companion object Factory {
        fun create(): ApiServiceInterface {
            val retrofit = retrofit2.Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(ApiServiceInterface::class.java)
        }
    }

}