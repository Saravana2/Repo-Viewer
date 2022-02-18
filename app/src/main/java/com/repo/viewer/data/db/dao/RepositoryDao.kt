package com.repo.viewer.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.repo.viewer.data.model.repo.Repository

@Dao
interface RepositoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAll(list: List<Repository>)

    @Query("DELETE FROM repository")
    suspend fun clear()

    @Query("SELECT * FROM repository")
    suspend fun getAll(): List<Repository>

}