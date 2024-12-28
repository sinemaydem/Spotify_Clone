package com.example.spotify_clone.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun SayfaGecisleri(secilenSayfa: String) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = secilenSayfa
    ) {
        composable("anasayfa") {
            Anasayfa(navController = navController)
        }

        composable("kesfet") {
            DefaultSearchScreen(modifier = Modifier)  // Keşfet sayfası için DefaultSearchScreen'i kullan
        }

        composable("kitaplik") {
            Kitaplik(navController = navController)  // Kitaplık sayfası
        }
    }
}