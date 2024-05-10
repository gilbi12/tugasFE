package com.example.infinitetest

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.infinitetest.data.Mentee
import com.example.infinitetest.data.Mentor
import com.example.infinitetest.navigation.Screen
/*
@Composable
fun MenteeItem(mentee: Mentee, modifier: Modifier, navController: NavController) {

        Row(modifier = Modifier.fillMaxSize()
            .clickable { val route = Screen.DetailMentee.route.replace("{mentorId}", mentee.id.toString())
                navController.navigate(route) }) {
            menteeImage(mentee = mentee)
            Column(modifier = Modifier
                .padding(8.dp)
                .fillMaxSize()) {
                Text(text = mentee.nama, style = typography.titleMedium)
                Text(text = mentee.prodi, style = typography.bodySmall)
            }

    }
}


@Composable
fun HorizontalMentorItem(mentor: Mentor, modifier: Modifier= Modifier){
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier=Modifier.clickable { val route=
            Screen.DetailMentor.route.replace("{mentorId}", mentor.id.toString())
            navController.navigate(route) }) {
        mentorImage(mentor = mentor)
        Column(modifier = Modifier
            , horizontalAlignment = Alignment.CenterHorizontally ){
            Text(text = mentor.nama, style = typography.titleMedium)
            Text(text = mentor.prodi, style = typography.bodySmall)
        }

    }
}


@Composable
fun mentorImage(mentor: Mentor){
    Image(painter = painterResource(id = mentor.imageid), contentDescription ="gambar",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(84.dp)
            .clip(CircleShape))
}

@Composable
fun menteeImage(mentee: Mentee){
    Image(painter = painterResource(id = mentee.imageid), contentDescription ="gambar",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(84.dp)
            .clip(CircleShape))
}


 */