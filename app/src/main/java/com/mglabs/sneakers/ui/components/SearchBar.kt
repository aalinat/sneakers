package com.mglabs.sneakers.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar() {
    val text = ""

    val searchTextFieldValue =
        remember { mutableStateOf(TextFieldValue(text)) }
    TextField(
        modifier = Modifier
            .clip(RoundedCornerShape(30.dp)).wrapContentHeight()
            .fillMaxWidth(),
        value = searchTextFieldValue.value,
        leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "") },
        onValueChange = {
            searchTextFieldValue.value = it
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedTextColor = MaterialTheme.colorScheme.primary,
            unfocusedPlaceholderColor = MaterialTheme.colorScheme.primary,
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent,
            containerColor = MaterialTheme.colorScheme.secondary
        ),
        singleLine = true,
        textStyle = MaterialTheme.typography.bodySmall,
        placeholder = {
            Text(
                text = "Search your shoes here...",
                style = MaterialTheme.typography.bodySmall
            )
        })
}