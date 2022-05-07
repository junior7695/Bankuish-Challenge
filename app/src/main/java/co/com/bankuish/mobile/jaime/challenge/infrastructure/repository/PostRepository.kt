package co.com.bankuish.mobile.jaime.challenge.infrastructure.repository

import co.com.bankuish.mobile.jaime.challenge.infrastructure.converters.Result
import co.com.bankuish.mobile.jaime.challenge.infrastructure.model.RepositoriesGitHubDTO

internal interface PostRepository {

    suspend fun getPosts(query: String, perPage: Int, page: Int): Result<RepositoriesGitHubDTO>
}