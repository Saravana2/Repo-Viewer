package com.repo.viewer.presentation.di

import com.repo.viewer.data.repository.datasource.RepositoryRemoteDataSource
import com.repo.viewer.data.repository.datasourceimpl.RepositoryRemoteDataSourceImpl
import com.repo.viewer.data.rest.GithubAPIService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule {

    @Singleton
    @Provides
    fun provideRepoRemoteDataSource(githubAPIService: GithubAPIService): RepositoryRemoteDataSource {
        return RepositoryRemoteDataSourceImpl(githubAPIService)
    }

}