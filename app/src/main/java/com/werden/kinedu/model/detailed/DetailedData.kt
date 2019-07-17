package com.werden.kinedu.model.detailed

import com.google.gson.annotations.SerializedName

/**
 * Class which provides a model for meta data
 * @constructor Sets all properties of the article detailed
 * @property article is an article detailed
 * @property relatedItem is a list of activities and articles
 */

data class DetailedData (
    @SerializedName("article")
    val article: ArticleDetailed,
    @SerializedName("related_items")
    val relatedItem: RelatedItem
)
