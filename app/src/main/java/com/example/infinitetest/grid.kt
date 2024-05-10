package com.example.infinitetest



import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.compose.ui.unit.dp
import com.example.infinitetest.data.Mentee
import com.example.infinitetest.data.dataprovidergrid
import com.example.infinitetest.data.dataprovidermentee
import com.example.infinitetest.data.dataprovidermentor

@Composable
fun grid(modifier: Modifier=Modifier){
    val grid= remember {dataprovidergrid.grids}
    
    LazyVerticalGrid(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        columns = GridCells.Fixed(2),
        modifier = modifier.fillMaxSize()){
        items(grid){
            GridItem(grid = it)
        }
    }
}

@Preview(showBackground = true, device = "id:pixel_3a_xl", showSystemUi = true,
    wallpaper = Wallpapers.NONE
)
@Composable
fun gridpreview(){
    grid()
}