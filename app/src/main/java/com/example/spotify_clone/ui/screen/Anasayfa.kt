package com.example.spotify_clone.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.example.spotify_clone.R
import com.example.spotify_clone.data.Sarkilar
import com.example.spotify_clone.ui.theme.SpotifyBackground
import com.example.spotify_clone.ui.theme.SpotifyBlack
import com.example.spotify_clone.ui.theme.SpotifyBlackUpper
import com.example.spotify_clone.ui.theme.SpotifyDarkGreen2
import com.example.spotify_clone.ui.theme.SpotifyDarkGrey
import com.example.spotify_clone.ui.theme.SpotifyGreen
import com.example.spotify_clone.ui.theme.SpotifyGrey
import com.example.spotify_clone.ui.theme.SpotifyWhite


@Composable
fun Anasayfa(navController: NavController) {
    var seciliSekme by remember { mutableStateOf(0) }
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(SpotifyBackground)
    ) {
        TapBar(
            seciliSekme = seciliSekme,
            sekmeSecildi = { sekili -> seciliSekme = sekili },
            modifier = Modifier
                .padding(top = 25.dp, bottom = 8.dp)
        )

        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(10.dp))

            // Son Çalınanlar Bölümü
            SonCalinanlarBolumu()

            Spacer(modifier = Modifier.height(24.dp))

            // Tavsiye Edilen İstasyonlar Bölümü
            TavsiyeEdilenIstasyonlarBolumu()

            Spacer(modifier = Modifier.height(24.dp))

            // Sizin İçin Tavsiye Bölümü/Günlük Müzik İhtiyacın
            SizinIcinTavsiyeBolumu()
        }
    }
}

@Composable
fun TapBar(
    seciliSekme: Int,
    sekmeSecildi: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val sekmeler = listOf("Tümü", "Müzik", "Podcast'ler")

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(SpotifyBackground)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 8.dp)
        ) {
            // Profile Image
            Image(
                painter = painterResource(id = R.drawable.me),
                contentDescription = "Profile Image",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(1.dp, SpotifyGrey, CircleShape),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(8.dp))

            ScrollableTabRow(
                selectedTabIndex = seciliSekme,
                containerColor = SpotifyBackground,
                contentColor = SpotifyWhite,
                edgePadding = 0.dp,
                divider = {},
                indicator = {},
                modifier = Modifier.weight(1f)
            ) {
                sekmeler.forEachIndexed { index, baslik ->
                    ElevatedFilterChip(
                        selected = seciliSekme == index,
                        onClick = { sekmeSecildi(index) },
                        label = {
                            Text(
                                text = baslik,
                                modifier = Modifier.padding(horizontal = 8.dp),
                                textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.bodyMedium
                            )
                        },
                        colors = FilterChipDefaults.elevatedFilterChipColors(
                            containerColor = if (seciliSekme == index) SpotifyGreen else SpotifyBlackUpper,
                            labelColor = if (seciliSekme == index) SpotifyBlackUpper else SpotifyWhite,
                            selectedContainerColor = SpotifyGreen
                        ),
                        shape = RoundedCornerShape(16.dp),
                        modifier = Modifier
                            .height(32.dp)
                            .padding(horizontal = 4.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun SonCalinanlarBolumu() {
    Column {
        /*
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {


            Text(
                text = "Son çalınanlar",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            TextButton(onClick = {}) {
                Text(
                    text = "Tümünü göster",
                    color = Color.Gray
                )
            }
        }*/

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.height(240.dp)
        ) {
            items(getSonCalinanlar()) { item ->
                SonCalinanItem(item)
            }
        }
    }
}

private fun getSonCalinanlar(): List<Sarkilar> {
    return listOf(
        Sarkilar(1, R.drawable.mylist_cover1, "Life is Like a Song", "Çalma Listesi"),
        Sarkilar(2, R.drawable.liked_songs, "Beğenilen Şarkılar", "Çalma Listesi"),
        Sarkilar(3, R.drawable.tavsiye4, "Coldplay Radyosu", "Sanatçı"),
        Sarkilar(4, R.drawable.dktt_karanlik, "Karanlık", "Çalma Listesi"),
        Sarkilar(5, R.drawable.mylist_cover4, "GYM Playlist", "Çalma Listesi"),
        Sarkilar(6, R.drawable.tarkan_karma, "Karma", "Çalma Listesi"),
        Sarkilar(7, R.drawable.rammstein_sehnsucht, "Sehnsucht", "Çalma Listesi"),
        Sarkilar(8, R.drawable.tavsiye2, "AC/DC Radyosu", "Sanatçı")
    )
}


@Composable
fun SonCalinanItem(item: Sarkilar) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(54.dp),
        color = SpotifyBlackUpper,
        shape = RoundedCornerShape(4.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(4.dp)
        ) {
            Image(
                painter = painterResource(id = item.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(4.dp)),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .weight(1f)
            ) {
                Text(
                    text = item.title,
                    color = Color.White,
                    fontSize = 14.sp,
                    maxLines = 1
                )/*
                Text(
                    text = item.subtitle,
                    color = Color.Gray,
                    fontSize = 12.sp
                )*/
            }
        }
    }
}
@Composable
fun TavsiyeEdilenIstasyonlarBolumu() {
    val sarkiListesi = remember { mutableStateListOf<Sarkilar>() }
    LaunchedEffect(key1 = true) {
        val s1 = Sarkilar(1, R.drawable.tavsiye1, "Arctic Monkeys", "Arctic Monkeys, Coldplay...")
        val s2 = Sarkilar(2, R.drawable.tavsiye2, "AC/DC", "AC/DC, Bon Jovi, Van Halen...")
        val s3 = Sarkilar(3, R.drawable.tavsiye4, "Coldplay", "Harry Styles, Maroon 5, Bruno Mars...")
        val s4 = Sarkilar(4, R.drawable.tavsiye3, "DKTT", "Yüzyüzeyken Konuşuruz, Deniz Tekin, Madrigal...")
        val s5 = Sarkilar(5, R.drawable.tavsiye5, "Rammstein", "Till Lindermann, Marilyn Manson, System Of A Down...")
        sarkiListesi.addAll(listOf(s1, s2, s3, s4, s5))
    }

    TavsiyeBolumu(
        baslik = "Tavsiye Edilen İstasyonlar",
        sarkiListesi = sarkiListesi
    )
}

@Composable
fun SizinIcinTavsiyeBolumu() {
    val sarkiListesi = remember { mutableStateListOf<Sarkilar>() }
    LaunchedEffect(key1 = true) {
        val s1 = Sarkilar(1, R.drawable.gunluk1, "Yılın Şarkıları 2024", "Dedublüman,Zeynep Bastık,Lvbel C5...")
        val s2 = Sarkilar(2, R.drawable.gunluk2, "Hareketli Türkçe", "Hande Yener, KÖFN, İrem Derici...")
        val s3 = Sarkilar(3, R.drawable.gunluk3, "Radar", "Tuana, Lotusx, Rana Türkyılmaz...")
        val s4 = Sarkilar(4, R.drawable.search_image1, "Günlük Müzik İhtiyacın", "Zeynep Bastık, Demet Akalın, Sezen Aksu")
        sarkiListesi.addAll(listOf(s1, s2, s3))
    }

    TavsiyeBolumu(
        baslik = "Günlük Müzik İhtiyacın",
        sarkiListesi = sarkiListesi
    )
}

@Composable
fun TavsiyeBolumu(baslik: String, sarkiListesi: List<Sarkilar>) {
    Column {
        Text(
            text = baslik,
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(sarkiListesi) { sarki ->
                IstasyonKarti(
                    imageRes = sarki.imageRes,
                    title = sarki.title,
                    subtitle = sarki.subtitle
                )
            }
        }
    }
}

@Composable
fun IstasyonKarti(imageRes: Int, title: String, subtitle: String) {
    Column(
        modifier = Modifier.width(160.dp)
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = Modifier
                .size(160.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(8.dp))
        /*Text(
            text = title,
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )*/
        Text(
            text = subtitle,
            color = Color.Gray,
            fontSize = 14.sp,
            maxLines = 2
        )
    }
}



