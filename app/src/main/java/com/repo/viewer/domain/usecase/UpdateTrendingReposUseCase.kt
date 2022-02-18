package com.repo.viewer.domain.usecase

import com.repo.viewer.domain.repository.GitRepoRepository

class UpdateTrendingReposUseCase(private val gitRepoRepository: GitRepoRepository) {
    suspend fun execute() = gitRepoRepository.updateTrendingRepo()
}