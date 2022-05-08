package co.com.bankuish.mobile.jaime.challenge.ui.post

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.com.bankuish.mobile.jaime.challenge.databinding.PostListItemBinding
import co.com.bankuish.mobile.jaime.challenge.infrastructure.models.Post

/***
 * Adapter para el Recycler View
 */
internal class PostAdapter(private val listener: BtnViewPostItemListener) :
    RecyclerView.Adapter<PostViewHolder>() {

    /***
     * Declaracion del Listener por medio de la interfaz
     */
    internal interface BtnViewPostItemListener {
        fun onViewPost(post: Post)
    }

    private val items = ArrayList<Post>()

    fun setItems(items: ArrayList<Post>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding: PostListItemBinding =
            PostListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) =
        holder.bindPost(items[position])

    override fun getItemCount(): Int = items.size
}

internal class PostViewHolder(
    private val itemBinding: PostListItemBinding,
    private val listener: PostAdapter.BtnViewPostItemListener
) : RecyclerView.ViewHolder(itemBinding.root as View), View.OnClickListener {

    private lateinit var post: Post

    init {
        itemBinding.root.setOnClickListener(this)
    }

    internal fun bindPost(item: Post) {
        this.post = item
        itemBinding.name.text = item.name
        itemBinding.author.text = item.author.name
        itemBinding.btnSeeDetail.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        listener.onViewPost(post)
    }
}