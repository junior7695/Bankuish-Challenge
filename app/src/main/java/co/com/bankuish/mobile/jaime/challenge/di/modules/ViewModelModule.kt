package co.com.bankuish.mobile.jaime.challenge.di.modules

import androidx.lifecycle.ViewModel
import co.com.bankuish.mobile.jaime.challenge.di.ViewModelKey
import co.com.bankuish.mobile.jaime.challenge.ui.detail.DetailViewModel
import co.com.bankuish.mobile.jaime.challenge.ui.post.PostViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(PostViewModel::class)
    fun bindPostViewModel(postViewModel: PostViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    fun bindDetailViewModel(detailViewModel: DetailViewModel): ViewModel

}