package com.werden.kinedu.model.article

import com.google.gson.annotations.SerializedName
import com.werden.kinedu.model.meta_data.MetaData

/**
 * Class which provides a model for meta data
 * @constructor Sets all properties of the meta data
 * @property articles list of them
 * @property metadata important information
 */

data class ArticleData(
    @SerializedName("articles")
    val articles: List<Article>,
    @SerializedName("meta")
    val metadata: MetaData
)