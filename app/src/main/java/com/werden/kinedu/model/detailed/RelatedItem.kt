package com.werden.kinedu.model.detailed

/**
 * Class which provides a model for meta data
 * @constructor Sets all properties of the article detailed
 * @property activities is a list of activities
 * @property articles is a list of articles
 */

data class RelatedItem (
    val activities: List<ActivityRelated>,
    val articles: List<ArticleRelated>
)
