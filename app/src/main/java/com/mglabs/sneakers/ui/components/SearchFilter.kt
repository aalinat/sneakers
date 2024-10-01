package com.mglabs.sneakers.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SearchFilter(
    iconColor: Color = MaterialTheme.colorScheme.background,
    iconColorNotSelected: Color = MaterialTheme.colorScheme.primary
) {
    val buttonsPaddingValues = PaddingValues(start = 20.dp, end = 20.dp)
    val iconTextPadding = PaddingValues(end = 10.dp)
    val buttonColorsNotSelected = ButtonColors(
        containerColor = MaterialTheme.colorScheme.secondary,
        contentColor = Color.Gray,
        disabledContentColor = Color.Unspecified,
        disabledContainerColor = Color.Unspecified
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = {},
                contentPadding = buttonsPaddingValues
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                    tint = iconColor,
                    modifier = Modifier.padding(iconTextPadding)
                )
                Text(text = "Men")
            }
            Button(
                onClick = {},
                contentPadding = buttonsPaddingValues,
                colors = buttonColorsNotSelected
            ) {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = null,
                    tint = iconColorNotSelected,
                    modifier = Modifier.padding(iconTextPadding)
                )
                Text(text = "Women")
            }

            Button(
                onClick = {},
                contentPadding = buttonsPaddingValues,
                colors = buttonColorsNotSelected
            ) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = null,
                    tint = iconColorNotSelected,
                    modifier = Modifier.padding(iconTextPadding)
                )
                Text(text = "Kids")
            }
        }


    }
}