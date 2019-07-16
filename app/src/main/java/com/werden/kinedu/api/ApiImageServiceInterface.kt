package com.werden.kinedu.api

import retrofit2.http.GET
import retrofit2.http.Url
import okhttp3.ResponseBody
import retrofit2.Call


interface ApiImageServiceInterface {

    /**
     * Get the list of the articles from the API
     */
    @GET
    fun getImage(@Url url: String): Call<ResponseBody>

}