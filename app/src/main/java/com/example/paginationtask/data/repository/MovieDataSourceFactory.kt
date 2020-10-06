
package com.example.paginationtask.data.repository

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.paginationtask.data.source.remote.UserService
import com.example.paginationtask.model.User
import kotlinx.coroutines.CoroutineScope

class MovieDataSourceFactory(
  private val movieService: UserService,
  private val scope: CoroutineScope
) : DataSource.Factory<Int, User>() {

  val sourceLiveData = MutableLiveData<PageKeyedMovieDataSource>()

  override fun create(): DataSource<Int, User> {
    val source = PageKeyedMovieDataSource(movieService, scope)
    sourceLiveData.postValue(source)
    return source
  }
}