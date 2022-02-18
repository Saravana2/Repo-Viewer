package com.repo.viewer.presentation.di.repo.trendinglist

import com.repo.viewer.presentation.repo.trendinglist.TrendingRepoViewModelFactory
import dagger.Subcomponent

@TrendingRepoScope
@Subcomponent(modules = [TrendingRepoModule::class])
interface TrendingRepoSubComponent {

    fun getTrendingRepoViewModelFactory(): TrendingRepoViewModelFactory

    @Subcomponent.Factory
    interface Factory {
        fun create(): TrendingRepoSubComponent
    }
}