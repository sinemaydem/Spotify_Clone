package com.example.spotify_clone.ui.screen

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.spotify_clone.R
import com.example.spotify_clone.data.LibraryItem
import com.example.spotify_clone.ui.theme.SpotifyBlack
import com.example.spotify_clone.ui.theme.SpotifyBlackUpper
import com.example.spotify_clone.ui.theme.SpotifyWhite

@Composable
fun Kitaplik(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = SpotifyBlack)
            .statusBarsPadding()
            .padding(top = 25.dp, bottom = 12.dp)
    ) {

        SearchTopBarElement()


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {

            LibraryTags()

            Spacer(modifier = Modifier.height(16.dp))

            SortBar()

            LibraryItemsList()
        }
    }
}

@Composable
fun SearchTopBarElement() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.me),
                contentDescription = "Profile Picture",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            )

            Text(
                text = "Kitaplığın",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                ),
                color = SpotifyWhite,
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Icon(
                imageVector = Icons.Outlined.Search,
                contentDescription = "Search",
                tint = SpotifyWhite
            )
            Icon(
                imageVector = Icons.Outlined.Add,
                contentDescription = "Add",
                tint = SpotifyWhite
            )
        }
    }
}

@Composable
fun LibraryTags() {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(vertical = 8.dp)
    ) {
        val libraryTags = listOf("Çalma listeleri", "Podcast'ler", "İndirilenler")
        items(libraryTags) { tag ->
            Surface(
                shape = RoundedCornerShape(20.dp),
                color = SpotifyBlackUpper,
                modifier = Modifier.height(32.dp)
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {
                    Text(
                        text = tag,
                        color = SpotifyWhite,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}

@Composable
fun SortBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.img_1),
                modifier = Modifier.size(24.dp),
                contentDescription = "Sort",
                tint = SpotifyWhite
            )
            Text(
                text = "Son çalınanlar",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                ),
                color = SpotifyWhite
            )
        }

        Icon(
            painter = painterResource(id = R.drawable.img),
            modifier = Modifier.size(24.dp),
            contentDescription = "View Type",
            tint = SpotifyWhite
        )
    }
}


private val yourLibraryData = listOf(
    LibraryItem(R.drawable.liked_songs, R.string.liked_songs, R.string.playlist, 1),
    LibraryItem(R.drawable.mylist_cover4, R.string.library_two, R.string.system_playlist, 2),
    LibraryItem(R.drawable.mylist_cover3, R.string.library_three, R.string.system_playlist, 3),
    LibraryItem(R.drawable.search_image7, R.string.library_four, R.string.library_two_value, 4),
    LibraryItem(R.drawable.mylist_cover1, R.string.library_five, R.string.system_playlist, 5),
    LibraryItem(R.drawable.mylist_cover5, R.string.library_six, R.string.library_three_value, 6),
    LibraryItem(R.drawable.mylist_cover2, R.string.library_seven, R.string.system_playlist, 7)
)

// Updated Composable Functions
@Composable
fun LibraryItemsList() {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        items(yourLibraryData) { item ->
            LibraryItemRow(
                imageId = item.drawable,
                title = stringResource(id = item.title),
                subtitle = stringResource(id = item.subtitle)
            )
        }
    }
}

@Composable
fun LibraryItemRow(
    @DrawableRes imageId: Int,
    title: String,
    subtitle: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = imageId),
            contentDescription = null,
            modifier = Modifier
                .size(56.dp)
        )
        Spacer(modifier = Modifier.width(15.dp))
        Column {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge,
                color = SpotifyWhite
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodySmall,
                color = SpotifyWhite
            )
        }
    }
}