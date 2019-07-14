package com.werden.kinedu.model.meta_data

/**
 * Class which provides a model for meta data
 * @constructor Sets all properties of the meta data
 * @property page is the current page
 * @property per_page is the value for many elements each page
 * @property total_pages is the value for total pages
 * @property total is the value for the total of elements
 */

data class MetaData (
    val page: Int,
    val per_page: Int,
    val total_pages: Int,
    val total: Int
)