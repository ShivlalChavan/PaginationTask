package com.example.paginationtask.data.source.remote

import com.example.paginationtask.model.UserResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {

    @GET("users")
    suspend fun discover(@Query("page") page: Int,@Query("per_page")perpage:Int): Response<UserResponse>
}