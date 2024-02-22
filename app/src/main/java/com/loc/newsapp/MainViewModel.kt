package com.loc.newsapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.loc.newsapp.domain.usecases.app_entry.AppEntryUseCases
import com.loc.newsapp.presentation.nav_graph.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val appEntryUseCases: AppEntryUseCases
) : ViewModel() {

   var splashCondition by mutableStateOf(true)
      private set
   var startDestination by mutableStateOf(Route.AppStartNavigation.route)
      private set

  init {
      appEntryUseCases.readAppEntry().onEach {startFromHome ->
         startDestination = if (startFromHome) {
            Route.NewsNavigation.route
         } else {
            Route.AppStartNavigation.route
         }
         delay(300)
         println("Condition: $splashCondition")
         splashCondition = false
         println("Condition: $splashCondition")
      }.launchIn(viewModelScope)
   }
}