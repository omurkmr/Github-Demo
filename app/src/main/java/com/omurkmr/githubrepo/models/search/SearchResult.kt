package com.omurkmr.githubrepo.models.search

data class SearchResult(
    var incomplete_results: Boolean? = null,
    var items: List<Item>? = null,
    var total_count: Int? = null
)