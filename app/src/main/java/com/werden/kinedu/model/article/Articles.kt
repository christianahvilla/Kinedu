package com.werden.kinedu.model.article

import com.google.gson.annotations.SerializedName
import com.werden.kinedu.model.meta_data.MetaData

/**
* Class which provides a model for meta data
* @constructor Sets all properties of the meta data
* @property data list of activities
* @property metadata important information
*/

data class Articles (
    @SerializedName("data")
    val data: ArticleData,
    @SerializedName("meta")
    val metadata: MetaData
)