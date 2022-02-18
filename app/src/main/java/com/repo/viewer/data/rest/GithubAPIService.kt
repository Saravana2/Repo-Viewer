package com.repo.viewer.data.rest

import com.repo.viewer.data.model.repo.Repository
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface GithubAPIService {
    companion object {
        const val BASE_URL = "https://api.github.com/"
        const val NO_INTERNET = "No Internet Connection"
    }

    @GET("repositories")
    @Headers("accept:application/vnd.github.v3+json")
    suspend fun getTrendingRepositories(): Response<List<Repository>>
}