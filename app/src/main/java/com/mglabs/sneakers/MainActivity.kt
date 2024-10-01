package com.mglabs.sneakers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mglabs.sneakers.ui.components.BottomNav
import com.mglabs.sneakers.ui.components.TopNav
import com.mglabs.sneakers.ui.screens.HomePage
import com.mglabs.sneakers.ui.theme.SneakersTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SneakersTheme {
                Scaffold(modifier = Modifier
                    .fillMaxSize(),
                    bottomBar = { BottomNav() },
                    topBar = {
                        TopNav(
                            Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp, top = 30.dp, end = 10.dp)
                        )
                    }) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    ) {
                        HomePage()
                    }
                }
            }
        }
    }
}