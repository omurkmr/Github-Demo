package com.omurkmr.githubrepo.koin

import android.content.Context
import com.omurkmr.githubrepo.R
import com.omurkmr.githubrepo.extentions.resLong
import com.omurkmr.githubrepo.services.network.RequestProvider
import com.omurkmr.githubrepo.services.network.apis.GithubApi
import com.omurkmr.githubrepo.services.settings.AppConfiguration
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * remote source module
 */
val remoteDataSourceModule = module {
    single { RequestProvider() }
    single { createOkHttpClient(get()).build()}
    single { createWebService<GithubApi>(get(), get<AppConfiguration>().githubBaseUrl) }
}

private fun createOkHttpClient(
    context: Context): OkHttpClient.Builder = OkHttpClient.Builder()
    .retryOnConnectionFailure(true)
    .readTimeout(context.resLong(R.integer.timeoutDurationInSeconds), TimeUnit.SECONDS)
    .writeTimeout(context.resLong(R.integer.timeoutDurationInSeconds), TimeUnit.SECONDS)
    .connectTimeout(context.resLong(R.integer.timeoutDurationInSeconds), TimeUnit.SECONDS)

private inline fun <reified T> createWebService(okHttpClient: OkHttpClient, url: String): T = Retrofit.Builder()
    .baseUrl(url)
    .client(okHttpClient)
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(T::class.java)