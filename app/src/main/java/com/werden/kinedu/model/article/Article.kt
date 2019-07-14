package com.werden.kinedu.model.article

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
    val type: String,
    val id: Int,
    val name: String,
    val min_age: Int,
    val max_age: Int,
    val picture: String,
    val area_id: Int,
    val short_description: String
)