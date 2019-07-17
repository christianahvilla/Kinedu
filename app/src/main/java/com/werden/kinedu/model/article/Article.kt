package com.werden.kinedu.model.article

import com.google.gson.annotations.SerializedName

/**
 * Class which provides a model for meta data
 * @constructor Sets all properties of the article detailed
 * @property type of article
 * @property id is the unique identifier
 * @property name is the title of the article
 * @property min_age target age
 * @property max_age target age
 * @property picture is the picture of article
 * @property area_id is the area which the article belong
 * @property short_description is the description of article
 */

data class Article (
    @SerializedName("type")
    val type: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("min_age")
    val min_age: Int,
    @SerializedName("max_age")
    val max_age: Int,
    @SerializedName("picture")
    val picture: String,
    @SerializedName("area_id")
    val area_id: Int,
    @SerializedName("short_description")
    val short_description: String
)