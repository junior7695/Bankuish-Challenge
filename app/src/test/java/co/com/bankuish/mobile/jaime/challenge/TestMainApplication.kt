package co.com.bankuish.mobile.jaime.challenge

import co.com.bankuish.mobile.jaime.challenge.di.component.TestAppComponent
import co.com.bankuish.mobile.jaime.challenge.di.component.AppComponent

class TestMainApplication : MainApplication() {

    override fun initializeDaggerComponent(): AppComponent {
        val component: TestAppComponent = DaggerTestAppComponent.factory()
            .create(this)

        component.inject(this)

        return component
    }

}