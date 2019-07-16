package com.werden.kinedu.model.detailed

import com.google.gson.annotations.SerializedName

/**
 * Class which provides a model for meta data
 * @constructor Sets all properties of the article detailed
 * @property id is the unique identifier
 * @property title is the title of the article
 * @property picture is the picture of article
 * @property area_id is the area which the article belong
 * @property body is the body of article
 * @property faved to know if an article is faved
 */

data class ArticleDetailed(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("picture")
    val picture: String,
    @SerializedName("link")
    val link: String,
    @SerializedName("area_id")
    val area_id: Int,
    @SerializedName("body")
    val body: String,
    @SerializedName("faved")
    val faved: Boolean
)