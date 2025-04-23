package com.jmonzonm.rickmortyapp.ui.core.navigation.bottomnavigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import com.jmonzonm.rickmortyapp.ui.core.navigation.Routes

sealed class BottomBarItem {
    abstract var route: String
    abstract var title: String
    abstract var icon: @Composable () -> Unit

    data class Episodes(
        override var route: String = Routes.Episodes.route,
        override var title: String = "Episodes",
        override var icon: @Composable () -> Unit = {
            Icon(imageVector = Icons.Default.Home, "")
        }
    ): BottomBarItem()

    data class Characters(
        override var route: String = Routes.Characters.route,
        override var title: String = "Character",
        override var icon: @Composable () -> Unit = {
            Icon(imageVector = Icons.Default.Person, "")
        }
    ): BottomBarItem()

}