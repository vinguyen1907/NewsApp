package com.loc.newsapp.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.loc.newsapp.domain.model.Article
import com.loc.newsapp.util.Constants

class NewsPagingSource (
    private val newsApi: NewsApi,
    private val sources: String,
) : PagingSource<Int, Article>() {
    private var totalNewsCount  = 0;

    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let {anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            return anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        val page = params.key ?: 1
        return try {
            val response = newsApi.getNews(page = page, sources = sources, pageSize = 10, apiKey = Constants.API_KEY)
            totalNewsCount += response.articles.size
            return LoadResult.Page(
                data = response.articles,
                nextKey = if (totalNewsCount >= response.totalResults) null else page + 1,
                prevKey = if (page == 1) null else page - 1
            )
        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(
                throwable = e
            )
        }
    }
}