package co.com.bankuish.mobile.jaime.challenge.infrastructure.repository

import co.com.bankuish.mobile.jaime.challenge.infrastructure.converters.Result
import co.com.bankuish.mobile.jaime.challenge.infrastructure.dtos.RepositoriesGitHubDTO
import co.com.bankuish.mobile.jaime.challenge.infrastructure.data_source.DataSource
import java.lang.Exception
import javax.inject.Inject

internal class PostRepositoryImpl @Inject constructor(
    private val remoteDataSource: DataSource
) : PostRepository {

    override suspend fun getPosts(
        query: String,
        perPage: Int,
        page: Int
    ): Result<RepositoriesGitHubDTO> {
        return try {
            val response = remoteDataSource.getPosts(query, perPage, page)
            Result.Success(response.body()!!)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}