package com.repo.viewer.domain.repository

import com.repo.viewer.data.model.repo.Repository

interface GitRepoRepository {
    suspend fun getTrendingRepos(): List<Repository>
    suspend fun updateTrendingRepo() : List<Repository>
}