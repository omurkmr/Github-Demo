package com.omurkmr.githubrepo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import com.omurkmr.githubrepo.databinding.ActivityMainBinding
import com.omurkmr.githubrepo.extentions.viewModel
import com.omurkmr.githubrepo.services.repositories.RepositoryViewModel
import com.omurkmr.githubrepo.ui.adapter.GithubSearchAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val repositoryViewModel by viewModel<RepositoryViewModel>(this)

    lateinit var binding: ActivityMainBinding

    private val itemAdapter = GithubSearchAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setAdapter()
        setObservers()
        setListeners()
    }

    override fun onDestroy() {
        super.onDestroy()
        repositoryViewModel.repositories.removeObservers(this)
    }

    private fun setAdapter() {
        if (::binding.isInitialized){
            binding.repositoryListRV.layoutManager = LinearLayoutManager(this, VERTICAL, false)
            binding.repositoryListRV.adapter = itemAdapter
        }
    }

    private fun setListeners() {
        search_button.setOnClickListener {
            repositoryViewModel.refreshRepositories(repo_search_ET.text.toString())
        }
    }


    private fun setObservers() {
        repositoryViewModel.repositories.observe(this, Observer {

            if (!it.isNullOrEmpty()) {
                itemAdapter.items = it
            } else {
                Toast.makeText(this, "No result Found", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
