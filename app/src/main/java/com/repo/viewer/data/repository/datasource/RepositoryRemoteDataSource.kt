package com.repo.viewer.data.repository.datasource

import com.repo.viewer.data.model.repo.Repository
import retrofit2.Response

interface RepositoryRemoteDataSource {
    suspend fun getTrendingRepos(): Response<List<Repository>>
}