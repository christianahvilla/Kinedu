package com.werden.kinedu.model.meta_data

import com.google.gson.annotations.SerializedName

/**
 * Class which provides a model for meta data
 * @constructor Sets all properties of the meta data
 * @property page is the current page
 * @property per_page is the value for many elements each page
 * @property total_pages is the value for total pages
 * @property total is the value for the total of elements
 */

data class MetaData (
    @SerializedName("page")
    val page: Int,
    @SerializedName("per_page")
    val per_page: Int,
    @SerializedName("total_pages")
    val total_pages: Int,
    @SerializedName("total")
    val total: Int
)