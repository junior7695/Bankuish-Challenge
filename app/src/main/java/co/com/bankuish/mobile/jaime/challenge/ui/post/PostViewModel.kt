package co.com.bankuish.mobile.jaime.challenge.ui.post

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.com.bankuish.mobile.jaime.challenge.infrastructure.converters.Result
import co.com.bankuish.mobile.jaime.challenge.di.scopes.ActivityScope
import co.com.bankuish.mobile.jaime.challenge.infrastructure.models.Post
import co.com.bankuish.mobile.jaime.challenge.infrastructure.repository.PostRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@ActivityScope
internal class PostViewModel @Inject constructor(
    private val repository: PostRepository
) : ViewModel() {

    private val tagLog = "PostViewModel: "

    private val _items = MutableLiveData<List<Post>>().apply { value = emptyList() }
    val items: LiveData<List<Post>> = _items

    private val _dataLoading = MutableLiveData<Boolean>()
    val dataLoading: LiveData<Boolean> = _dataLoading

    fun getPosts(
        query: String = "kotlin",
        perPage: Int = 30,
        page: Int = 1,
        errorViewListener: ErrorView
    ) {
        _dataLoading.value = true

        viewModelScope.launch {
            repository.getPosts(query, perPage, page).let { result ->
                when (result) {
                    is Result.Success -> {
                        errorViewListener.showError(false)
                        Log.d(tagLog, "Request -> Success: $result")
                        _dataLoading.value = false
                        _items.value = result.data.items
                    }
                    is Result.Error -> {
                        val msg = "Request -> Error: ${result.exception.message}"
                        Log.d(tagLog, msg)
                        _dataLoading.value = false
                        errorViewListener.showError(true, msg)
                    }
                    Result.Loading -> {
                        errorViewListener.showError(false)
                        Log.d(tagLog, "Request -> Loading...")
                        _dataLoading.value = true
                    }
                }
            }
        }
    }

    internal interface ErrorView {
        fun showError(showErrorScreen: Boolean, errorMessage: String? = null)
    }
}