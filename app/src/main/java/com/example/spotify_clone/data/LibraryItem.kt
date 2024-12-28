package com.example.spotify_clone.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class LibraryItem(
    @DrawableRes val drawable: Int,
    @StringRes val title: Int,
    @StringRes val subtitle: Int,
    val imageId: Int

)