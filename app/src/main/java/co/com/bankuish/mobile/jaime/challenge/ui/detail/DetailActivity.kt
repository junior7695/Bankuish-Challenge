package co.com.bankuish.mobile.jaime.challenge.ui.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import co.com.bankuish.mobile.jaime.challenge.databinding.ActivityDetailBinding
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class DetailActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<DetailViewModel> { viewModelFactory }

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)

        setContentView(binding.root)

        viewModel.post = intent.getParcelableExtra("post")!!

        setupUi()
    }

    private fun setupUi() {
        binding.name.text = viewModel.post.name

        binding.author.text = viewModel.post.author.name

        binding.description.text = viewModel.post.description

        binding.watchers.text = viewModel.post.watchers.toString()

        binding.forks.text = viewModel.post.forks.toString()
    }
}