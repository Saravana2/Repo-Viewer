package com.repo.viewer.presentation.di

import android.content.Context
import androidx.room.Room
import com.repo.viewer.data.db.AppDatabase
import com.repo.viewer.data.db.dao.RepositoryDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {
    @Singleton
    @Provides
    fun provideDataBase(context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "repo_viewer").build()

    @Singleton
    @Provides
    fun provideRepoDao(appDatabase: AppDatabase): RepositoryDao = appDatabase.trendingRepositories()
}