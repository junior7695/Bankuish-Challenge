package co.com.bankuish.mobile.jaime.challenge.infrastructure.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
internal data class Author(
    internal val id: Int,
    @SerializedName("login")
    internal val name: String
) : Parcelable
