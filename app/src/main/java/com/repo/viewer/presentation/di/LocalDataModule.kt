package com.repo.viewer.presentation.di

import com.repo.viewer.data.db.dao.RepositoryDao
import com.repo.viewer.data.repository.datasource.RepositoryLocalDataSource
import com.repo.viewer.data.repository.datasourceimpl.RepositoryLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideTrendingRepoDataSource(dao: RepositoryDao): RepositoryLocalDataSource {
        return RepositoryLocalDataSourceImpl(dao)
    }

}