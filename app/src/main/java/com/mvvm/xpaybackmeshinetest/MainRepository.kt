package com.mvvm.xpaybackmeshinetest

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData

class MainRepository constructor(private val retrofitService: RetrofitService) {

    fun getAllMovies(): LiveData<PagingData<users>> {

        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = false,
                initialLoadSize = 2
            ),
            pagingSourceFactory = {
                MoviePagingSource(retrofitService)
            }
        , initialKey = 1
        ).liveData
    }

}