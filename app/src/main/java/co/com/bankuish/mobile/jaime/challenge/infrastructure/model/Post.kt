package co.com.bankuish.mobile.jaime.challenge.infrastructure.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
internal data class Post(
    internal val id: Int,
    internal val name: String,
    @SerializedName("owner")
    internal val author: Author,
    internal val description: String,
    @SerializedName("private")
    internal val isPrivate: Boolean,
    internal val visibility: String,
    internal val watchers: Int,
    internal val forks: Int
) : Parcelable
