package com.werden.kinedu.api

import com.werden.kinedu.model.activity.Activities
import com.werden.kinedu.model.article.Articles
import com.werden.kinedu.model.detailed.Detailed
import com.werden.kinedu.utils.BASE_URL
import com.werden.kinedu.utils.TOKEN
import io.reactivex.Observable
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

/**
 * The interface which provides methods to get result of webservices
 */

interface ApiServiceInterface {
    /**
     * Get the list of the articles from the API
     */
    @Headers("Authorization: $TOKEN")
    @GET("catalogue/articles?skill_id=5&baby_id=2064732")
    fun getArticles(): Observable<Articles>

    /**
     * Get the detail of an article from the API
     */
    @Headers("Authorization: $TOKEN")
    @GET("articles/{id}")
    fun getArticleDetailed(@Path("id") id: Int): Observable<Detailed>

    /**
     * Get the list of the articles from the API
     */
    @Headers("Authorization: $TOKEN")
    @GET("catalogue/activities?skill_id=5&baby_id=2064732")
    fun getActivities(): Observable<Activities>


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