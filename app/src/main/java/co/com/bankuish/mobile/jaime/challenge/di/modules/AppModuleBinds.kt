package co.com.bankuish.mobile.jaime.challenge.di.modules

import co.com.bankuish.mobile.jaime.challenge.infrastructure.repository.PostRepository
import co.com.bankuish.mobile.jaime.challenge.infrastructure.repository.PostRepositoryImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
internal interface AppModuleBinds {

    @Singleton
    @Binds
    fun bindRepository(postRepository: PostRepositoryImpl): PostRepository
}