package com.werden.kinedu.model.detailed

/**
 * Class which provides a model for meta data
 * @constructor Sets all properties of the meta data
 * @property id is the unique identifier
 * @property name of activity
 * @property description of activity
 * @property age is the target
 * @property age_group is the activity belonging
 * @property video_provider_thumbnails is a list about images
 * @property video_id is the unique identifier
 * @property area_id is the activity belonging
 * @property shareable_video_url link to be shared
 * @property shareable_thumbnail link to be shared
 * @property locked status
 * @property picture image of activity
 * @property faved to know if an article is faved
 */

data class ActivityRelated(
    val id: Int,
    val name: String,
    val description: String,
    val purpose: String,
    val age: Int,
    val age_group: Int,
    val video_provider_thumbnails: List<String>,
    val video_id: String,
    val area_id: Int,
    val shareable_video_url: String,
    val shareable_thumbnail: String,
    val locked: Boolean,
    val picture: String,
    val faved: Boolean
)