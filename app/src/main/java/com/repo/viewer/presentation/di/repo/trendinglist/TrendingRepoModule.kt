package com.repo.viewer.presentation.di.repo.trendinglist

import com.repo.viewer.domain.usecase.GetTrendingReposUseCase
import com.repo.viewer.domain.usecase.UpdateTrendingReposUseCase
import com.repo.viewer.presentation.repo.trendinglist.TrendingRepoViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TrendingRepoModule {

    @TrendingRepoScope
    @Provides
    fun provideTrendingRepoViewModelFactory(
        getTrendingReposUseCase: GetTrendingReposUseCase,
        updateTrendingReposUseCase: UpdateTrendingReposUseCase
    ) =
        TrendingRepoViewModelFactory(getTrendingReposUseCase,updateTrendingReposUseCase)

}