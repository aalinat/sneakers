package com.mglabs.sneakers.domain.models

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter

data class Product(
    val name: String,
    val image: Painter,
    val price: String = "450$",
    val sizes: List<String> = listOf("9", "9.5", "10", "10.5", "11", "11.5"),
    val colors: List<Color> = listOf(Color.Red, Color.Cyan, Color.Blue, Color.Black)
)
