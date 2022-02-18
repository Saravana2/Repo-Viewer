package com.repo.viewer.presentation.di

import android.content.Context
import com.repo.viewer.presentation.di.repo.trendinglist.TrendingRepoSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [TrendingRepoSubComponent::class])
class AppModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideAppContext(): Context = context.applicationContext
}