package com.werden.kinedu.model.detailed

import com.google.gson.annotations.SerializedName

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
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("purpose")
    val purpose: String,
    @SerializedName("age")
    val age: Int,
    @SerializedName("age_group")
    val age_group: Int,
    @SerializedName("video_provider_thumbnails")
    val video_provider_thumbnails: List<String>,
    @SerializedName("video_id")
    val video_id: String,
    @SerializedName("area_id")
    val area_id: Int,
    @SerializedName("shareable_video_url")
    val shareable_video_url: String,
    @SerializedName("shareable_thumbnail")
    val shareable_thumbnail: String,
    @SerializedName("locked")
    val locked: Boolean,
    @SerializedName("picture")
    val picture: String,
    @SerializedName("faved")
    val faved: Boolean
)