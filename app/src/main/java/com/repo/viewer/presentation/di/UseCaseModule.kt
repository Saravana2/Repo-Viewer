package com.repo.viewer.presentation.di

import com.repo.viewer.domain.repository.GitRepoRepository
import com.repo.viewer.domain.usecase.GetTrendingReposUseCase
import com.repo.viewer.domain.usecase.UpdateTrendingReposUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetTrendingRepoUseCase(repository: GitRepoRepository) =
        GetTrendingReposUseCase(repository)

    @Provides
    fun provideUpdateTrendingRepoUseCase(repository: GitRepoRepository) =
        UpdateTrendingReposUseCase(repository)

}