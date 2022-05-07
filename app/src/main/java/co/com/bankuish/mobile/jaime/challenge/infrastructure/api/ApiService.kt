package co.com.bankuish.mobile.jaime.challenge.infrastructure.api

import co.com.bankuish.mobile.jaime.challenge.infrastructure.dtos.RepositoriesGitHubDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

internal interface ApiService {

    @GET("repositories")
    suspend fun getPosts(
        @Query("q") query: String,
        @Query("per_page") perPage: Int,
        @Query("page") page: Int
    ): Response<RepositoriesGitHubDTO>

}