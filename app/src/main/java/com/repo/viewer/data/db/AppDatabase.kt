package com.repo.viewer.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.repo.viewer.data.db.dao.RepositoryDao
import com.repo.viewer.data.db.typeconvertor.UserListTypeConvertor
import com.repo.viewer.data.model.repo.Repository
import com.repo.viewer.data.model.repo.User

@Database(
    entities = [Repository::class, User::class],
    version = 1,
    exportSchema = false
)

@TypeConverters(UserListTypeConvertor::class)

abstract class AppDatabase : RoomDatabase() {
    abstract fun trendingRepositories(): RepositoryDao
}