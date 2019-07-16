package com.werden.kinedu.model.detailed

import com.google.gson.annotations.SerializedName

/**
 * Class which provides a model for meta data
 * @constructor Sets all properties of the article detailed
 * @property data is an article detailed
 */

data class Detailed (
    @SerializedName("data")
    val data: DetailedData
)
