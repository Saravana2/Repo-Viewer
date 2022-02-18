package com.repo.viewer.presentation.di

import com.repo.viewer.presentation.di.repo.trendinglist.TrendingRepoSubComponent

interface Injector {
    fun createTrendingRepoSubComponent(): TrendingRepoSubComponent
}