package com.repo.viewer.presentation.di

import com.repo.viewer.data.repository.GitRepoRepositoryImpl
import com.repo.viewer.data.repository.datasource.RepositoryLocalDataSource
import com.repo.viewer.data.repository.datasource.RepositoryRemoteDataSource
import com.repo.viewer.domain.repository.GitRepoRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideTrendingRepoRepository(
        remoteDataSource: RepositoryRemoteDataSource,
        localDataSource: RepositoryLocalDataSource
    ): GitRepoRepository {
        return GitRepoRepositoryImpl(
            remoteDataSource,
            localDataSource
        )
    }
}