package com.repo.viewer.data.repository.datasourceimpl

import com.repo.viewer.data.db.dao.RepositoryDao
import com.repo.viewer.data.model.repo.Repository
import com.repo.viewer.data.repository.datasource.RepositoryLocalDataSource

class RepositoryLocalDataSourceImpl(
    private val repositoryDao: RepositoryDao
) : RepositoryLocalDataSource {
    override suspend fun clearAll() = repositoryDao.clear()

    override suspend fun saveRepos(items: List<Repository>) = repositoryDao.saveAll(items)

    override suspend fun getRepos(): List<Repository> = repositoryDao.getAll()
}