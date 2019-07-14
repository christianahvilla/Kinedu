package com.werden.kinedu.model.activity

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
    val id: Int,
    val name: String,
    val age: Int,
    val age_group: Int,
    val activity_type: String,
    val is_holiday: Boolean,
    val domain_id: Int,
    val area_id: Int,
    val purpose: String,
    val thumbnail: String,
    val active_milestones: Int,
    val completed_milestones: Int
)
