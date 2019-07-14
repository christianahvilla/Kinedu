package com.werden.kinedu.model.detailed

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
    val id: Int,
    val title: String,
    val picture: String,
    val link: String,
    val area_id: Int,
    val body: String,
    val faved: Boolean
)