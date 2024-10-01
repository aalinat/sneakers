package com.mglabs.sneakers.ui.components

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.PagerSnapDistance
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.mglabs.sneakers.domain.models.Product


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductCollection(
    listOfItems: List<Product>,
    pagerState: PagerState
) {
    val flingBehavior = PagerDefaults.flingBehavior(
        state = pagerState,
        pagerSnapDistance = PagerSnapDistance.atMost(3),
        lowVelocityAnimationSpec = tween(
            easing = FastOutLinearInEasing,
            durationMillis = 5000
        ),
        highVelocityAnimationSpec = rememberSplineBasedDecay(),
        snapAnimationSpec = tween(
            easing = FastOutSlowInEasing,
            durationMillis = 1000
        ),
    )

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        HorizontalPager(
            pageSize = PageSize.Fill,
            state = pagerState,
            flingBehavior = flingBehavior,
            pageSpacing = 18.dp,
        ) { pageIndex ->
            ProductCard(listOfItems[pageIndex])
        }
    }
}


@Composable
fun ProductCard(
    product: Product,
    cardColors: CardColors = CardColors(
        contentColor = MaterialTheme.colorScheme.primary,
        containerColor = Color.Transparent,
        disabledContentColor = Color.Transparent,
        disabledContainerColor = Color.Transparent
    )
) {
    val textModifier = Modifier.padding(top = 60.dp)
    val cardModifier = Modifier.fillMaxWidth()
    val imageModifier = Modifier
        .rotate(330f)
        .scale(2.4f)

    Card(
        onClick = {},
        modifier = cardModifier,
        colors = cardColors
    ) {
        Image(
            modifier = imageModifier
                .weight(1f)
                .align(Alignment.CenterHorizontally),
            painter = product.image,
            contentDescription = ""
        )
        Text(
            text = product.name,
            modifier = textModifier.align(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.padding(10.dp))
        FilterText("Size  ", "9.5", product.sizes)
        Spacer(modifier = Modifier.padding(10.dp))
        FilterColor("Color", Color.Cyan, product.colors)
        DottedSeparator()
        CTA(product)
    }
}

@Composable
fun DottedSeparator() {
    Spacer(
        modifier = Modifier.padding(10.dp)
    )
    val pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
    Canvas(Modifier.fillMaxWidth().height(3.dp)) {

        drawLine(
            color = Color.Gray,
            start = Offset(0f, 0f),
            end = Offset(size.width, 0f),
            pathEffect = pathEffect
        )
    }
    Spacer(
        modifier = Modifier.padding(5.dp)
    )
}

@Composable
fun CTA(product: Product) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = product.price, style = MaterialTheme.typography.titleLarge)
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Buy Now")
            }
        }
    }
}

@Composable
fun FilterColor(filterLabel: String, filterValue: Color, options: List<Color>) {
    val buttonsPaddingValues = PaddingValues(0.dp)
    val buttonColors = ButtonColors(
        containerColor = Color.Transparent,
        contentColor = Color.Gray,
        disabledContentColor = Color.Unspecified,
        disabledContainerColor = Color.Unspecified
    )
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = filterLabel,
                modifier = Modifier.padding(end = 10.dp),
                style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold)
            )
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                items(options.take(5)) { color ->
                    var borders = BorderStroke(0.dp, Color.Unspecified)
                    val colors = buttonColors.copy(containerColor = color)
                    if (filterValue == color) {
                        borders = BorderStroke(2.dp, Color.Gray)
                    }
                    Button(
                        shape = RoundedCornerShape(10.dp),
                        onClick = { /*TODO*/ },
                        colors = colors,
                        contentPadding = buttonsPaddingValues,
                        border = borders
                    ) {

                    }
                }
            }
        }
    }
}

@Composable
fun FilterText(filterLabel: String, filterValue: String, options: List<String>) {
    val buttonsPaddingValues = PaddingValues(0.dp)
    val buttonColors = ButtonColors(
        containerColor = Color.Transparent,
        contentColor = Color.Gray,
        disabledContentColor = Color.Unspecified,
        disabledContainerColor = Color.Unspecified
    )
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = filterLabel, modifier = Modifier.padding(end = 10.dp),
                style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold)
            )
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                items(options.take(4)) { size ->
                    var colors = buttonColors
                    if (size == filterValue) {
                        colors = buttonColors.copy(
                            containerColor = MaterialTheme.colorScheme.primary,
                            contentColor = Color.White
                        )
                    }
                    Button(
                        onClick = { /*TODO*/ },
                        colors = colors,
                        contentPadding = buttonsPaddingValues,
                        shape = RoundedCornerShape(10.dp),
                    ) {
                        Text(text = size, style = MaterialTheme.typography.bodySmall)
                    }
                }
            }
        }
    }
}
