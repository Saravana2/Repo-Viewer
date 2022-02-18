package com.repo.viewer.data.repository.datasource

import com.repo.viewer.data.model.repo.Repository

interface RepositoryLocalDataSource {
    suspend fun clearAll()
    suspend fun saveRepos(items: List<Repository>)
    suspend fun getRepos(): List<Repository>
}