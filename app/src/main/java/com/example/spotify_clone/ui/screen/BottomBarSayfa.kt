package com.example.spotify_clone.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.spotify_clone.R
import com.example.spotify_clone.ui.theme.SpotifyBackground
import com.example.spotify_clone.ui.theme.SpotifyBlackUpper
import com.example.spotify_clone.ui.theme.SpotifyWhite

@Composable
fun BottomBarSayfa() {
    val secilenItem = remember { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
            BottomAppBar(
                modifier = Modifier.height(56.dp),
                containerColor = SpotifyBackground
            ) {
                val selectedColor = SpotifyWhite
                val unselectedColor = Color.Gray

                NavigationBarItem(
                    selected = secilenItem.value == 0,
                    onClick = { secilenItem.value = 0 },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.anasayfa),
                            contentDescription = "Anasayfa",
                            tint = if (secilenItem.value == 0) selectedColor else unselectedColor
                        )
                    },
                    label = { Text(text = "Ana Sayfa") },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = Color.Transparent
                    )
                )
                NavigationBarItem(
                    selected = secilenItem.value == 1,
                    onClick = { secilenItem.value = 1 },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.arama),
                            contentDescription = "Keşfet",
                            tint = if (secilenItem.value == 1) selectedColor else unselectedColor
                        )
                    },
                    label = { Text(text = "Arama") },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = Color.Transparent
                    )
                )
                NavigationBarItem(
                    selected = secilenItem.value == 2,
                    onClick = { secilenItem.value = 2 },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.kitaplik),
                            contentDescription = "Kitaplık",
                            tint = if (secilenItem.value == 2) selectedColor else unselectedColor
                        )
                    },
                    label = { Text(text = "Kitaplığn") },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = Color.Transparent
                    )
                )
            }
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            when (secilenItem.value) {
                0 -> SayfaGecisleri(secilenSayfa = "anasayfa")
                1 -> SayfaGecisleri(secilenSayfa = "kesfet")
                2 -> SayfaGecisleri(secilenSayfa = "kitaplik")
            }
        }
    }
}
