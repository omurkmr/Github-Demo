package com.omurkmr.githubrepo.services.network.apis

import com.omurkmr.githubrepo.models.search.SearchResult
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubApi {

    @GET("/search/repositories")
    suspend fun repositories(@Query("q") query: String): SearchResult?

}