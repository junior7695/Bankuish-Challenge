package co.com.bankuish.mobile.jaime.challenge.infrastructure.api

import co.com.bankuish.mobile.jaime.challenge.infrastructure.model.RepositoriesGitHubDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

internal interface ApiService {

    @GET("repositories")
    suspend fun getPosts(
        @Query("q") text: String = "kotlin",
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): Response<RepositoriesGitHubDTO>

}