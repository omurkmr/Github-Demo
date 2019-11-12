package com.omurkmr.githubrepo.koin

import com.omurkmr.githubrepo.services.settings.AppConfiguration
import org.koin.dsl.module

/**
 * config service dependency injection module
 * contains AppConfiguration
 */
val configuration = module {
    single { AppConfiguration(get()) }
}