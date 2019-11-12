package com.omurkmr.githubrepo.models

import com.omurkmr.githubrepo.models.search.SearchResult

/**
 * Contains network request responses
 *
 * @property searchResponse response of the repositories search
 */
data class ResponseBody(
    var searchResponse: SearchResult? = null
)