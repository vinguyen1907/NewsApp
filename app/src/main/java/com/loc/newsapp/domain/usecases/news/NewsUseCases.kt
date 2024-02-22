package com.loc.newsapp.domain.usecases.news

data class NewsUseCases (
    val getNews: GetNews,
    val searchNews: SearchNews,
    val upsertBookmark: UpsertBookmark,
    val selectBookmarks: SelectBookmarks,
    val deleteBookmark: DeleteBookmark,
    val selectArticle: SelectArticle
)