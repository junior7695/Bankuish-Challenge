package co.com.bankuish.mobile.jaime.challenge.di.module

import co.com.bankuish.mobile.jaime.challenge.infrastructure.api.ApiService
import co.com.bankuish.mobile.jaime.challenge.infrastructure.data_source.DataSource
import dagger.Module
import dagger.Provides
import io.mockk.mockk
import javax.inject.Singleton

@Module
class TestAppModule {

    @Singleton
    @Provides
    internal fun provideTasksRemoteDataSource(
        apiService: ApiService
    ): DataSource = mockk()
}