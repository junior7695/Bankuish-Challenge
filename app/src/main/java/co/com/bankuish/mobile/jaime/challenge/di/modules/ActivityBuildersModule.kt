package co.com.bankuish.mobile.jaime.challenge.di.modules

import co.com.bankuish.mobile.jaime.challenge.di.scopes.ActivityScope
import co.com.bankuish.mobile.jaime.challenge.ui.detail.DetailActivity
import co.com.bankuish.mobile.jaime.challenge.ui.post.PostActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal interface ActivityBuildersModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    fun contributePostActivity(): PostActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    fun contributeDetailActivity(): DetailActivity

}