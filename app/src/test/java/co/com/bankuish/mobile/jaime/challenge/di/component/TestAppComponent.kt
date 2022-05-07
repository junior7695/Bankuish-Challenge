package co.com.bankuish.mobile.jaime.challenge.di.component

import android.content.Context
import co.com.bankuish.mobile.jaime.challenge.TestMainApplication
import dagger.BindsInstance
import dagger.Component

interface TestAppComponent : AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): TestAppComponent
    }

    fun inject(app: TestMainApplication)
}