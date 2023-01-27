package com.mvvm.xpaybackmeshinetest

import androidx.paging.PagingSource
import androidx.paging.PagingState
import java.lang.Exception

class MoviePagingSource(private val apiService: RetrofitService): PagingSource<Int, users>() {


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, users> {

        return try {
            val position = params.key ?: 1
            val response = apiService.getTopRatedMovies(25,0)
            LoadResult.Page(data = response.body()!!.users, prevKey = if (position == 1) null else position - 1,
                nextKey = position + 1)
        } catch (e: Exception) {
            LoadResult.Error(e)
        }

    }

    override fun getRefreshKey(state: PagingState<Int, users>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

}
