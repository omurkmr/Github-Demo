package com.omurkmr.githubrepo.services.network

import androidx.annotation.WorkerThread
import com.omurkmr.githubrepo.extentions.inject
import com.omurkmr.githubrepo.models.ResponseBody
import com.omurkmr.githubrepo.services.network.apis.GithubApi

class RequestProvider {

    //github api injection
    private val githubApi by inject<GithubApi>()

    @WorkerThread
    suspend fun queries(param: String): ResponseBody = ResponseBody(searchResponse = githubApi.repositories(param))
}