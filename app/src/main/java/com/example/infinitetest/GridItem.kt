package com.example.infinitetest

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.compose.ui.unit.dp

import com.example.infinitetest.data.Grid
import com.example.infinitetest.data.Mentee
import com.example.infinitetest.data.Mentor

@Composable
fun GridItem(grid: Grid) {
    Card(shape = RoundedCornerShape(16.dp),modifier = Modifier.padding(8.dp).fillMaxSize(),
        elevation = CardDefaults.cardElevation(2.dp)){



        Column(modifier = Modifier.fillMaxSize()) {
            GridImage(grid = grid)
        }
        }
    }





@Composable
fun GridImage(grid: Grid){
    Image(painter = painterResource(id = grid.imageid), contentDescription ="gambar",
      )
}

