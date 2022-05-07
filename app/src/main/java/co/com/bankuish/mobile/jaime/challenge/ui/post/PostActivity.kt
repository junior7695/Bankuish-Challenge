package co.com.bankuish.mobile.jaime.challenge.ui.post

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import co.com.bankuish.mobile.jaime.challenge.R
import co.com.bankuish.mobile.jaime.challenge.databinding.ActivityPostBinding
import co.com.bankuish.mobile.jaime.challenge.infrastructure.models.Post
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

internal class PostActivity : DaggerAppCompatActivity(), PostAdapter.BtnViewPostItemListener,
    PostViewModel.ErrorView {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<PostViewModel> { viewModelFactory }

    private lateinit var binding: ActivityPostBinding

    private lateinit var adapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_post)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_post)

        binding.apply {
            viewmodel = viewModel
            lifecycleOwner = this@PostActivity
        }

        setupRecyclerView()

        setupObserveViewData()

        viewModel.getPosts(errorViewListener = this)

        binding.swipeRefresh.setOnRefreshListener {

            viewModel.getPosts(errorViewListener = this)

            binding.swipeRefresh.isRefreshing = false

        }
    }

    private fun setupRecyclerView() {
        adapter = PostAdapter(this)
        binding.recyclerViewSearchResults.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewSearchResults.adapter = adapter
    }

    private fun setupObserveViewData() {

        viewModel.items.observe(this) {
            if (!it.isNullOrEmpty()) {
                adapter.setItems(ArrayList(it))
            }
        }

        viewModel.dataLoading.observe(this) {
            binding.progressBar.visibility = if (it) View.VISIBLE else View.GONE
            binding.recyclerViewSearchResults.visibility = if (it) View.GONE else View.VISIBLE
        }
    }

    override fun onViewPost(post: Post) {
        /*val i = Intent(this, PostActivity::class.java)
        i.putExtra("post", post)
        startActivity(i)*/
    }

    override fun showError(showErrorScreen: Boolean, errorMessage: String?) {
        if (showErrorScreen) {
            binding.recyclerViewSearchResults.visibility = View.GONE
            binding.errorView.root.visibility = View.VISIBLE
            binding.errorView.errorViewText.text = errorMessage
        } else {
            binding.errorView.root.visibility = View.GONE
        }
    }
}