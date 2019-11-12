package com.omurkmr.githubrepo.services.repositories

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.omurkmr.githubrepo.extentions.inject
import com.omurkmr.githubrepo.models.search.Item
import kotlinx.coroutines.*

class RepositoryViewModel: ViewModel() {

    /**
     * This is the job for all coroutines started by this ViewModel.
     * Cancelling this will cancel all coroutines started by this ViewModel.
     */
    private val viewModelJob = SupervisorJob()

    /**
     * This is the main scope for all coroutines launched by this ViewModel.
     * Since we pass viewModelJob, you can cancel all coroutines launched by uiScope by calling viewModelJob.cancel()
     */
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    override fun onCleared() {
        viewModelJob.cancel()
    }

    val githubRepository by inject<GithubRepository>()

    val repositories = MutableLiveData<List<Item>>()

    fun refreshRepositories(param: String) {
        uiScope.launch {
            withContext(Dispatchers.IO) {
                repositories.postValue(githubRepository.loadRepositories(param))
            }
        }
    }
}