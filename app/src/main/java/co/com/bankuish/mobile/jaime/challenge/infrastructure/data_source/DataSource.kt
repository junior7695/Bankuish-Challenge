package co.com.bankuish.mobile.jaime.challenge.infrastructure.data_source

import co.com.bankuish.mobile.jaime.challenge.infrastructure.dtos.RepositoriesGitHubDTO
import retrofit2.Response

internal interface DataSource {

    suspend fun getPosts(query:String, perPage: Int, page: Int): Response<RepositoriesGitHubDTO>
}