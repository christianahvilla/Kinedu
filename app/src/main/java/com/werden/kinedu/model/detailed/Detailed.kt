package com.werden.kinedu.model.detailed

/**
 * Class which provides a model for meta data
 * @constructor Sets all properties of the article detailed
 * @property article is an article detailed
 * @property relatedItem is a list of activities and articles
 */

data class Detailed (
    val article: ArticleDetailed,
    val relatedItem: RelatedItem
)
