package com.repo.viewer.presentation.repo.trendinglist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.repo.viewer.domain.usecase.GetTrendingReposUseCase
import com.repo.viewer.domain.usecase.UpdateTrendingReposUseCase

class TrendingRepoViewModelFactory(
    private val getTrendingReposUseCase: GetTrendingReposUseCase,
    private val updateTrendingReposUseCase: UpdateTrendingReposUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TrendingRepoViewModel(getTrendingReposUseCase,updateTrendingReposUseCase) as T
    }

}