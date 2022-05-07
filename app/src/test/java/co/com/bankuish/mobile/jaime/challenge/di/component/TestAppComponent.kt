package co.com.bankuish.mobile.jaime.challenge.di.component

import android.content.Context
import co.com.bankuish.mobile.jaime.challenge.application.TestMainApplication
import co.com.bankuish.mobile.jaime.challenge.di.module.TestAppModule
import co.com.bankuish.mobile.jaime.challenge.di.modules.AppModule
import co.com.bankuish.mobile.jaime.challenge.di.modules.AppModuleBinds
import co.com.bankuish.mobile.jaime.challenge.di.modules.NetworkModule
import co.com.bankuish.mobile.jaime.challenge.infrastructure.repository.PostRepositoryImplTest
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        NetworkModule::class,
        TestAppModule::class,
        AppModuleBinds::class]
)
interface TestAppComponent : AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): TestAppComponent
    }

    fun inject(app: TestMainApplication)

    fun inject(test: PostRepositoryImplTest)
}