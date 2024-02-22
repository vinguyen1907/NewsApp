package com.loc.newsapp.presentation.nav_graph

sealed class Route (
    val route: String
) {
    object OnboardingScreen: Route("onboarding_screen")
    object HomeScreen: Route("home_screen")
    object SearchScreen: Route("search_screen")
    object BookmarkScreen: Route("bookmark_screen")
    object DetailsScreen: Route("details_screen")
    object  AppStartNavigation: Route("app_start_navigation")
    object NewsNavigation: Route("news_navigation")
    object NewsNavigatorScreen: Route("news_navigator_screen")
}