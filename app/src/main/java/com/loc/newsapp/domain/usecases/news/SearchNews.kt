package com.loc.newsapp.domain.usecases.news

import com.loc.newsapp.domain.repository.NewsRepository

class SearchNews (
    private val newsRepository: NewsRepository,
) {
    operator fun invoke(query: String, sources: List<String>) = newsRepository.searchNews(query, sources)
}