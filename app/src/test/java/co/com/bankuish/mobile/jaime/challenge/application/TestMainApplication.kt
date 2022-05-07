package co.com.bankuish.mobile.jaime.challenge.application

import co.com.bankuish.mobile.jaime.challenge.MainApplication
import co.com.bankuish.mobile.jaime.challenge.di.component.TestAppComponent
import co.com.bankuish.mobile.jaime.challenge.di.component.AppComponent
import co.com.bankuish.mobile.jaime.challenge.di.component.DaggerTestAppComponent

class TestMainApplication : MainApplication() {

    override fun initializeDaggerComponent(): AppComponent {
        val component: TestAppComponent = DaggerTestAppComponent.factory()
            .create(this)

        component.inject(this)

        return component
    }

}