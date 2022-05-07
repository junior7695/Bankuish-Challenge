package co.com.bankuish.mobile.jaime.challenge.di.modules

import co.com.bankuish.mobile.jaime.challenge.infrastructure.api.ApiService
import co.com.bankuish.mobile.jaime.challenge.infrastructure.data_source.DataSource
import co.com.bankuish.mobile.jaime.challenge.infrastructure.data_source.remote.RemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    internal fun provideTasksRemoteDataSource(
        apiService: ApiService
    ): DataSource {
        return RemoteDataSourceImpl(apiService)
    }
}