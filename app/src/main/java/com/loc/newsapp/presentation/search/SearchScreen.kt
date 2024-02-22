package com.loc.newsapp.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.collectAsLazyPagingItems
import com.loc.newsapp.domain.model.Article
import com.loc.newsapp.presentation.Dimens.MediumPadding1
import com.loc.newsapp.presentation.common.ArticlesList
import com.loc.newsapp.presentation.common.SearchBar

@Composable
fun SearchScreen(
    state: SearchState,
    event: (SearchEvent) -> Unit,
    navigateToDetails: (Article) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(top = MediumPadding1)
            .statusBarsPadding()
    ) {
        SearchBar(
            modifier = Modifier.padding(horizontal = MediumPadding1),
            text = state.searchQuery,
            onValueChange = {
                event(SearchEvent.UpdateSearchQuery(it))
            },
             onSearch = {
                 event(SearchEvent.Search)
             }
        )
        Spacer(modifier = Modifier.height(MediumPadding1))
        state.articles?.let {articlesPagingFlow ->
            val articles = articlesPagingFlow.collectAsLazyPagingItems()
            ArticlesList(articles = articles, onClick = navigateToDetails)
        }
    }
}