package co.com.bankuish.mobile.jaime.challenge.infrastructure.data_source.remote

import co.com.bankuish.mobile.jaime.challenge.infrastructure.api.ApiService
import co.com.bankuish.mobile.jaime.challenge.infrastructure.data_source.DataSource
import co.com.bankuish.mobile.jaime.challenge.infrastructure.model.RepositoriesGitHubDTO
import retrofit2.Response
import javax.inject.Inject

internal class RemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : DataSource {

    override suspend fun getPosts(
        query: String,
        perPage: Int,
        page: Int
    ): Response<RepositoriesGitHubDTO> = apiService.getPosts(query, perPage, page)
}