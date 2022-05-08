package co.com.bankuish.mobile.jaime.challenge.infrastructure.api

import co.com.bankuish.mobile.jaime.challenge.application.TestMainApplication
import co.com.bankuish.mobile.jaime.challenge.di.component.DaggerTestAppComponent
import co.com.bankuish.mobile.jaime.challenge.di.component.TestAppComponent
import dagger.Module
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import javax.inject.Inject

@Module
class ApiServiceTest {

    @Inject
    internal lateinit var apiService: ApiService

    @Before
    fun setup() {
        val component: TestAppComponent = DaggerTestAppComponent.factory()
            .create(TestMainApplication())
        component.inject(this)
    }

    @Test
    fun `getPosts, should return status code 200`() = runBlocking {
        // When
        val result = apiService.getPosts("kotlin", 30, 1)

        // Then
        Assert.assertEquals(200, result.code())
        Assert.assertNotNull(result.body())
    }
}