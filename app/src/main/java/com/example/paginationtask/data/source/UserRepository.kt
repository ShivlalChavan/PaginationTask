package com.example.paginationtask.data.source

import com.example.paginationtask.data.Result
import com.example.paginationtask.model.User

interface UserRepository {

   fun getDiscoverUser(pageSize: Int,perpage: Int): Result<User>

}