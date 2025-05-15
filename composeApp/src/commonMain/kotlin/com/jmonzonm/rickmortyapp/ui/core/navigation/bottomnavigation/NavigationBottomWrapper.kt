package com.jmonzonm.rickmortyapp.ui.core.navigation.bottomnavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jmonzonm.rickmortyapp.ui.core.navigation.CharacterDetail
import com.jmonzonm.rickmortyapp.ui.core.navigation.Routes
import com.jmonzonm.rickmortyapp.ui.home.tabs.characters.CharactersScreen
import com.jmonzonm.rickmortyapp.ui.home.tabs.episodes.EpisodesScreen
import kotlinx.serialization.json.Json

@Composable
fun NavigationBottomWrapper(navController: NavHostController, mainNavController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.Episodes.route) {
        composable(route = Routes.Episodes.route) {
            EpisodesScreen()
        }
        composable(route = Routes.Characters.route) {
            CharactersScreen(
                navigateToDetail = { characterModel ->
                    val encode = Json.encodeToString(characterModel)
                    mainNavController.navigate(CharacterDetail(encode))
                }
            )
        }
    }
}