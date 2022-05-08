package co.com.bankuish.mobile.jaime.challenge.infrastructure.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
internal data class Post(
    @SerializedName("id") internal val id: Int,
    @SerializedName("name") internal val name: String,
    @SerializedName("owner") internal val author: Author,
    @SerializedName("description") internal val description: String,
    @SerializedName("private") internal val isPrivate: Boolean,
    @SerializedName("watchers") internal val watchers: Int,
    @SerializedName("forks") internal val forks: Int
) : Parcelable
