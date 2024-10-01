package com.mglabs.sneakers.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mglabs.sneakers.R
import com.mglabs.sneakers.domain.models.Product
import com.mglabs.sneakers.ui.components.ProductCollection
import com.mglabs.sneakers.ui.components.SearchBar
import com.mglabs.sneakers.ui.components.SearchFilter
import com.mglabs.sneakers.ui.theme.SneakersTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomePage() {
    val products = (1..10).map {
        Product(
            "Air Zoom Pegasus 41 $it",
            painterResource(R.drawable.air_zoom_pegasus_41),
            price = (it * 10).toString() + "$"
        )
    }
    val scrollCoroutineScope = rememberCoroutineScope()
    val paddingTop = PaddingValues(top = 20.dp)
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { products.size })

    Column(modifier = Modifier.padding(20.dp)) {
        Row {
            SearchBar()
        }
        Row(modifier = Modifier.padding(paddingTop)) {
            SearchFilter()
        }
        Row(
            modifier = Modifier
                .padding(paddingTop)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "New Collection",
                style = MaterialTheme.typography.titleLarge
            )
            Row {
                IconButton(onClick = {
                    scrollCoroutineScope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage.dec())
                    }
                }, enabled = pagerState.currentPage != 0) {
                    Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft, contentDescription = "")
                }
                IconButton(onClick = {
                    scrollCoroutineScope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage.inc())
                    }
                }, enabled = pagerState.currentPage != pagerState.pageCount) {
                    Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "")
                }
            }
        }
        Row(modifier = Modifier.padding(paddingTop)) {
            ProductCollection(products, pagerState)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePagePreview() {
    SneakersTheme {
        HomePage()
    }
}