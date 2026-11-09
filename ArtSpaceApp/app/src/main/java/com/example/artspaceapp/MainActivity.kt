package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    var currentIndex by remember { mutableStateOf(0) }

    val artworks = listOf(
        Artwork(R.drawable.image1, "Title 1", "Artist 1 (2024)"),
        Artwork(R.drawable.image2, "Title 2", "Artist 2 (2023)"),
        Artwork(R.drawable.image3, "Title 3", "Artist 3 (2022)")
    )

    val currentArtwork = artworks[currentIndex]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Картинка
        Image(
            painter = painterResource(id = currentArtwork.imageRes),
            contentDescription = currentArtwork.title,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Название и автор
        Text(text = currentArtwork.title, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text(text = currentArtwork.artist, fontSize = 16.sp)

        Spacer(modifier = Modifier.height(32.dp))

        // Кнопки навигации
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = {
                    if (currentIndex > 0) currentIndex--
                },
                enabled = currentIndex > 0
            ) {
                Text(stringResource(R.string.previous))
            }

            Button(
                onClick = {
                    if (currentIndex < artworks.size - 1) currentIndex++
                },
                enabled = currentIndex < artworks.size - 1
            ) {
                Text(stringResource(R.string.next))
            }
        }
    }
}

data class Artwork(
    val imageRes: Int,
    val title: String,
    val artist: String
)