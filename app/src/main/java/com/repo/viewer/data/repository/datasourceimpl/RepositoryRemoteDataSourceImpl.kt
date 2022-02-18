package com.repo.viewer.data.repository.datasourceimpl

import com.repo.viewer.data.model.repo.Repository
import com.repo.viewer.data.repository.datasource.RepositoryRemoteDataSource
import com.repo.viewer.data.rest.GithubAPIService
import retrofit2.Response

class RepositoryRemoteDataSourceImpl(
    private val githubAPIService: GithubAPIService
) : RepositoryRemoteDataSource {
    override suspend fun getTrendingRepos(): Response<List<Repository>> =
        githubAPIService.getTrendingRepositories()
}