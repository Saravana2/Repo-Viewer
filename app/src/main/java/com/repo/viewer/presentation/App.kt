package com.repo.viewer.presentation

import android.app.Application
import com.repo.viewer.data.rest.GithubAPIService
import com.repo.viewer.presentation.di.*
import com.repo.viewer.presentation.di.repo.trendinglist.TrendingRepoSubComponent

class App : Application(), Injector{
    private lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder().apply {
            appModule(AppModule(applicationContext))
            netModule(NetModule(GithubAPIService.BASE_URL))
        }.also {
            appComponent = it.build()
        }
    }

    override fun createTrendingRepoSubComponent(): TrendingRepoSubComponent {
        return appComponent.trendingRepoSubComponent().create()
    }

}