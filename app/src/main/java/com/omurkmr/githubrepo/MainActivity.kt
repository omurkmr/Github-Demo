package com.omurkmr.githubrepo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.omurkmr.githubrepo.extentions.viewModel
import com.omurkmr.githubrepo.services.repositories.RepositoryViewModel

class MainActivity : AppCompatActivity() {

    private val repositoryViewModel by viewModel<RepositoryViewModel>(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setObservers()
        repositoryViewModel.refreshRepositories("fhg")
    }

    private fun setObservers() {
        repositoryViewModel.repositories.observe(this, Observer {
            Log.i("tttt","${it}")
        })
    }
}
