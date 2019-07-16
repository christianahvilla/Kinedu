package com.werden.kinedu.model.detailed

import com.google.gson.annotations.SerializedName

/**
 * Class which provides a model for meta data
 * @constructor Sets all properties of the article detailed
 * @property activities is a list of activities
 * @property articles is a list of articles
 */

data class RelatedItem (
    @SerializedName("activities")
    val activities: List<ActivityRelated>,
    @SerializedName("articles")
    val articles: List<ArticleRelated>
)
