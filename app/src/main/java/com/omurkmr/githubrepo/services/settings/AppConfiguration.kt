package com.omurkmr.githubrepo.services.settings

import android.content.Context
import com.omurkmr.githubrepo.R
import com.omurkmr.githubrepo.extentions.resString

class AppConfiguration(val context: Context) {

    val githubBaseUrl = context.resString(R.string.github_base_url)
}