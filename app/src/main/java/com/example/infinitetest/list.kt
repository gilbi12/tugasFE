/*package com.example.infinitetest

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
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
import com.example.infinitetest.data.dataprovidermentee
import com.example.infinitetest.data.dataprovidermentor

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun list(modifier: Modifier=Modifier){
    val mentors=remember {dataprovidermentor.mentors}
    val mentee=remember {dataprovidermentee.mentee}
Column(modifier= modifier
    .fillMaxSize()
    .verticalScroll(rememberScrollState())) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        items(
            items = mentors,
            itemContent = {
                HorizontalMentorItem(mentor = it, modifier=Modifier)
            }
        )
    }
    LazyColumn(modifier= modifier
        .height(2000.dp)
        .padding(top = 32.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        userScrollEnabled = false)
    {
        items(
            items = mentee,
            itemContent = {
                MenteeItem(mentee = it, modifier = Modifier)

            }
        )
    }
}

}

@Preview(showBackground = true, device = "id:pixel_3a_xl", showSystemUi = true,
    wallpaper = Wallpapers.NONE
)
@Composable
fun previewlist(){
    list()
}

*/
