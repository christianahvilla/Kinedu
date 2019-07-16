package com.werden.kinedu.model.activity

import com.google.gson.annotations.SerializedName

/**
 * Class which provides a model for meta data
 * @constructor Sets all properties of the meta data
 * @property id is the unique identifier
 * @property name of activity
 * @property age is the target
 * @property age_group is the activity belonging
 * @property activity_type of activity
 * @property is_holiday to know if it is a holiday
 * @property domain_id is the activity belonging
 * @property area_id is the activity belonging
 * @property purpose of activity
 * @property thumbnail images link
 * @property active_milestones of activity
 * @property completed_milestones of activity
 */

data class Activity (
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("age")
    val age: Int,
    @SerializedName("age_group")
    val age_group: String,
    @SerializedName("activity_type")
    val activity_type: String,
    @SerializedName("is_holiday")
    val is_holiday: Boolean,
    @SerializedName("domain_id")
    val domain_id: Int,
    @SerializedName("area_id")
    val area_id: Int,
    @SerializedName("purpose")
    val purpose: String,
    @SerializedName("thumbnail")
    val thumbnail: String,
    @SerializedName("active_milestones")
    val active_milestones: Int,
    @SerializedName("completed_milestones")
    val completed_milestones: Int
)
