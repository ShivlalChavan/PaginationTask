
package com.example.paginationtask

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations.map
import androidx.lifecycle.Transformations.switchMap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.paginationtask.data.repository.DefaultMovieRepository
import com.example.paginationtask.data.source.remote.UserAPI

class MainViewModel : ViewModel() {

  private val repo = DefaultMovieRepository(UserAPI.movieService, viewModelScope)
  private val loader = MutableLiveData<Unit>()
  private val repoResult = map(loader) { repo.getDiscoverUser(3,5) }

  val movies = switchMap(repoResult) { it.pagedList }
  val networkState = switchMap(repoResult) { it.networkState }
  val refreshState = switchMap(repoResult) { it.refreshState }

  init {
    loader.postValue(Unit)
  }

  fun refresh() {
    repoResult.value?.refresh?.invoke()
  }

  fun retry() {
    repoResult.value?.retry?.invoke()
  }
}