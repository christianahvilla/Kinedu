package com.werden.kinedu.model.activity

/**
 * Class which provides a model for meta data
 * @constructor Sets all properties of the meta data
 * @property id is the unique identifier
 * @property name of activity
 * @property type of activity
 * @property activities has them
 */

data class ActivityData (
    val id: Int,
    val name: String,
    val type: String,
    val activities: List<Activity>
)
