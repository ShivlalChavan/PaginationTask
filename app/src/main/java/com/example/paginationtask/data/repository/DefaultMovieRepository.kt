package com.example.paginationtask.data.repository

import androidx.lifecycle.Transformations
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.paginationtask.data.source.UserRepository
import com.example.paginationtask.data.source.remote.UserService
import com.example.paginationtask.data.Result;
import com.example.paginationtask.model.User
import kotlinx.coroutines.CoroutineScope


class DefaultMovieRepository(
    private val service: UserService,
    private val scope: CoroutineScope
) : UserRepository {

    override fun getDiscoverUser(
        pageSize: Int,
        perpage: Int
    ): Result<User> {
        val dataSourceFactory = MovieDataSourceFactory(service, scope)

        val config = PagedList.Config.Builder()
            .setPageSize(pageSize)
            .setEnablePlaceholders(true)
            .build()

        return Result(
            pagedList = LivePagedListBuilder<Int, User>(dataSourceFactory, config).build(),
            networkState = Transformations.switchMap(dataSourceFactory.sourceLiveData) { it.networkState },
            refreshState = Transformations.switchMap(dataSourceFactory.sourceLiveData) { it.initialLoad },
            retry = { dataSourceFactory.sourceLiveData.value?.retryAllFailed() },
            refresh = { dataSourceFactory.sourceLiveData.value?.invalidate() }
        )
    }
}