package co.com.bankuish.mobile.jaime.challenge.infrastructure.repository

import co.com.bankuish.mobile.jaime.challenge.application.TestMainApplication
import co.com.bankuish.mobile.jaime.challenge.di.component.DaggerTestAppComponent
import co.com.bankuish.mobile.jaime.challenge.di.component.TestAppComponent
import co.com.bankuish.mobile.jaime.challenge.infrastructure.data_source.DataSource
import co.com.bankuish.mobile.jaime.challenge.infrastructure.model.Author
import co.com.bankuish.mobile.jaime.challenge.infrastructure.model.Post
import co.com.bankuish.mobile.jaime.challenge.infrastructure.model.RepositoriesGitHubDTO
import io.mockk.coEvery
import io.mockk.coVerify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import retrofit2.Response
import javax.inject.Inject

class PostRepositoryImplTest {

    @Inject
    internal lateinit var repository: PostRepositoryImpl

    @Inject
    internal lateinit var remoteDataSource: DataSource

    @Before
    fun setup() {
        val component: TestAppComponent = DaggerTestAppComponent.factory()
            .create(TestMainApplication())
        component.inject(this)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getSearchResponse() = runBlockingTest {
        val postList = mutableListOf<Post>()
        val post = Post(1, "test_repo", Author(1, "junior7695"), "test_desc", false, 1, 1)
        postList.add(post)
        val responseDTO = RepositoriesGitHubDTO(1, postList)

        val responseRetrofit = Response.success(responseDTO)

        coEvery { remoteDataSource.getPosts("kotlin", 1, 1) } returns responseRetrofit

        coVerify { repository.getPosts("kotlin", 1, 1) }

        coVerify { remoteDataSource.getPosts("kotlin", 1, 1) }
    }
}