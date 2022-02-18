package com.repo.viewer.data.repository

import android.util.Log
import com.repo.viewer.data.model.repo.Repository
import com.repo.viewer.data.repository.datasource.RepositoryLocalDataSource
import com.repo.viewer.data.repository.datasource.RepositoryRemoteDataSource
import com.repo.viewer.domain.repository.GitRepoRepository

class GitRepoRepositoryImpl(
    private val repositoryRemoteDataSource: RepositoryRemoteDataSource,
    private val repositoryLocalDataSource: RepositoryLocalDataSource
) : GitRepoRepository {

    override suspend fun getTrendingRepos(): List<Repository> = getReposFromDB()

    override suspend fun updateTrendingRepo(): List<Repository> {
        repositoryLocalDataSource.clearAll()
        return getTrendingRepos()
    }

    private suspend fun getReposFromRemote(): List<Repository> {
        var list: List<Repository> = listOf()
        //try {
            val response = repositoryRemoteDataSource.getTrendingRepos()
            val body = response.body()
            if (body != null) {
                list = body
            }
        /*} catch (e: Exception) {
            Log.i("Remote:Get Repos ", e.message.toString())
        }*/
        return list
    }

    private suspend fun getReposFromDB(): List<Repository> {
        var list: List<Repository> = listOf()
        try {
            list = repositoryLocalDataSource.getRepos()
        } catch (e: Exception) {
            Log.i("DB:Get Repos", e.message.toString())
        }
        if (list.isEmpty()) {
            list = getReposFromRemote()
            repositoryLocalDataSource.saveRepos(list)
        }
        return list
    }
}