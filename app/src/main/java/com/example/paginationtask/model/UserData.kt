package com.example.paginationtask.model

import com.google.gson.annotations.SerializedName

data class User(

    val id: Int,
    @SerializedName(value = "first_name")
    val firstName: String = "",
    @SerializedName(value = "last_name")
    val lastName: String = "",
    @SerializedName(value = "email")
    val email: String = "",
    @SerializedName(value = "avatar")
    val profileImage: String = ""
)

data class Add(

    @SerializedName(value = "company")
    val company: String = "",
    @SerializedName(value = "url")
    val url: String = "",
    @SerializedName(value = "text")
    val text: String = ""
)

data class UserResponse(

val page: Int,
val per_page: Int,
val total: Int,
val total_pages: Int,
@SerializedName(value = "data")
val results:List<User>,
@SerializedName(value = "ad")
val addData:Add


)