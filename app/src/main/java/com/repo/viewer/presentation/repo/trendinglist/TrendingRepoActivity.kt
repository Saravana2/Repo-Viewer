package com.repo.viewer.presentation.repo.trendinglist

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.repo.viewer.R
import com.repo.viewer.databinding.ActivityTrendingRepoBinding
import com.repo.viewer.presentation.BaseActivity

class TrendingRepoActivity : BaseActivity() {

    private lateinit var binding: ActivityTrendingRepoBinding
    private lateinit var viewModel: TrendingRepoViewModel
    private lateinit var newsAdapter: RepoAdapter
    private lateinit var searchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = getString(R.string.trending_repositories)
        binding = ActivityTrendingRepoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val factory = getAppInjector()
            .createTrendingRepoSubComponent()
            .getTrendingRepoViewModelFactory()
        viewModel = ViewModelProvider(this, factory)[TrendingRepoViewModel::class.java]

        setClickActions()
        initNewsRecyclerView()

        setUpObserver()
        if (viewModel.itemList.value?.isEmpty() != true)
            fetchRepos()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        val searchView = menu?.findItem(R.id.search)?.actionView as? SearchView
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        searchView?.apply {
            this@TrendingRepoActivity.searchView = this
            setSearchableInfo(searchManager.getSearchableInfo(componentName))
            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    viewModel.filterRepos(query)
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    viewModel.filterRepos(newText)
                    return true
                }

            })
        }
        return super.onCreateOptionsMenu(menu)
    }

    private fun setClickActions() {
        binding.errorLayout.tryAgainButton.apply {
            setOnClickListener {
                updateRepos()
            }
        }
        binding.swipeRefreshLayout.apply {
            setOnRefreshListener {
                updateRepos()
            }
        }
    }

    private fun fetchRepos() {
        viewModel.getTrendingRepos()
    }

    private fun updateRepos() {
        viewModel.updateTrendingRepos()
    }

    private fun setUpObserver() {
        viewModel.itemList.observe(this) {
            newsAdapter.setRepos(it)
        }
        viewModel.state.observe(this) {
            changeViewVisibilityByState(it)
            when (it) {
                is State.Error -> {
                    binding.errorLayout.errorInfoTextView.text = it.message
                }
                else -> {

                }
            }
        }
    }

    private fun initNewsRecyclerView() {
        newsAdapter = RepoAdapter()
        binding.repoRecyclerView.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = newsAdapter
        }
    }

    private fun changeViewVisibilityByState(state: State) {
        binding.repoRecyclerView.isVisible = state == State.Done
        binding.progressBar.isVisible = state == State.InProgress
        binding.errorLayout.root.isVisible = state is State.Error
        if (binding.swipeRefreshLayout.isRefreshing) {
            binding.swipeRefreshLayout.isRefreshing = false
        }
    }

}