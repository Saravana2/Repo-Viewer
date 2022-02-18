package com.repo.viewer.presentation.di

import com.repo.viewer.presentation.di.repo.trendinglist.TrendingRepoSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        DataBaseModule::class,
        NetModule::class,
        RemoteDataModule::class,
        LocalDataModule::class,
        RepositoryModule::class,
        UseCaseModule::class
    ]
)
interface AppComponent {
    fun trendingRepoSubComponent(): TrendingRepoSubComponent.Factory
}