package com.omurkmr.githubrepo.services.repositories

import com.omurkmr.githubrepo.extentions.inject
import com.omurkmr.githubrepo.models.search.Item
import com.omurkmr.githubrepo.services.network.RequestProvider
import java.net.UnknownHostException

class GithubRepository {

    val network by inject<RequestProvider>()

    suspend fun loadRepositories(param: String): List<Item>? {
        val response = try {
            network.queries(param = param).searchResponse?.items
        } catch (e: UnknownHostException) {
            null
        } catch (e: Exception) {
            e.printStackTrace()
            null
        } ?: return null

        return response
    }

}