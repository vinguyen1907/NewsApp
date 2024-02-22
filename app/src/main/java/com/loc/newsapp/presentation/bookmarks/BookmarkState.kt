package com.loc.newsapp.presentation.bookmarks

import com.loc.newsapp.domain.model.Article

data class BookmarkState(
    val bookmarks: List<Article> = emptyList()
)