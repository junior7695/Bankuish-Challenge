package co.com.bankuish.mobile.jaime.challenge.infrastructure.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
internal data class ResponseDTO(
    @SerializedName("total_count")
    val totalCount: Int,
    val items: List<Post>
) : Parcelable
