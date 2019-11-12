package com.omurkmr.githubrepo.koin

import com.omurkmr.githubrepo.services.repositories.GithubRepository
import org.koin.dsl.module

/**
 * data source service dependency injection module
 * contains GithubRepository
 */
val dataSourceModule = module {
    single { GithubRepository() }
}