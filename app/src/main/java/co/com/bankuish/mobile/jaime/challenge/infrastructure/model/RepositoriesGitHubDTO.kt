package co.com.bankuish.mobile.jaime.challenge.infrastructure.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
internal data class RepositoriesGitHubDTO(
    @SerializedName("total_count") val totalCount: Int = 0,
    @SerializedName("total_count") val items: List<Post> = emptyList()
) : Parcelable
