package co.com.bankuish.mobile.jaime.challenge.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import co.com.bankuish.mobile.jaime.challenge.di.scopes.ActivityScope
import co.com.bankuish.mobile.jaime.challenge.infrastructure.models.Post
import javax.inject.Inject

@ActivityScope
internal class DetailViewModel @Inject constructor() : ViewModel() {

    lateinit var post: Post

}