package co.com.bankuish.mobile.jaime.challenge.infrastructure.dtos

import android.os.Parcelable
import co.com.bankuish.mobile.jaime.challenge.infrastructure.models.Post
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
internal data class RepositoriesGitHubDTO(
    @SerializedName("total_count") val totalCount: Int = 0,
    @SerializedName("items") val items: List<Post> = emptyList()
) : Parcelable
