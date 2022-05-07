package co.com.bankuish.mobile.jaime.challenge.di.component

import android.content.Context
import co.com.bankuish.mobile.jaime.challenge.MainApplication
import co.com.bankuish.mobile.jaime.challenge.di.modules.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface AppComponent : AndroidInjector<DaggerApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }

    fun inject(app: MainApplication)
}