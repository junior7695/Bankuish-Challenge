package co.com.bankuish.mobile.jaime.challenge.di.modules

import co.com.bankuish.mobile.jaime.challenge.di.scopes.ActivityScope
import co.com.bankuish.mobile.jaime.challenge.ui.post.PostActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal interface ActivityBuildersModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [PostModule::class])
    fun contributeMainActivity(): PostActivity

}