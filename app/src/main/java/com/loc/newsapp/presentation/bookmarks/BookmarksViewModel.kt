package com.loc.newsapp.presentation.bookmarks

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.loc.newsapp.domain.usecases.news.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class BookmarksViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases
) : ViewModel(){
    private val _state = mutableStateOf(BookmarkState())
    val state: State<BookmarkState> = _state

    init {
        getBookmarks()
    }

    private fun getBookmarks(){
        newsUseCases.selectBookmarks().onEach {
            _state.value = _state.value.copy(bookmarks = it)
        }.launchIn(viewModelScope)
    }
}