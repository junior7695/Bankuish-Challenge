package co.com.bankuish.mobile.jaime.challenge.infrastructure.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
internal data class Author(
    @SerializedName("id") internal val id: Int,
    @SerializedName("login") internal val name: String
) : Parcelable
