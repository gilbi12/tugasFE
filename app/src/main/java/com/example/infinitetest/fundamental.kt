package com.example.infinitetest

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun apayaa(modifier: Modifier =Modifier) {
Scaffold(

    //topbar
    topBar = {
        CenterAlignedTopAppBar(
            //ini kasih warna top bar
            colors=TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.primary),

            //ini untuk title
            title = {
                Text(text = "anjing") },

            //ini navigasi back
            navigationIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "back"
                    )
                    
                }
            }

        )
    },

    //floatingactino
    floatingActionButton = {
        FloatingActionButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "icon"
            )
        }
            
    },

    //bottombar
    bottomBar = {
        BottomAppBar(
            actions= {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Edit, contentDescription = "edit")
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Place, contentDescription = "place")
                    
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Email, contentDescription = "email")
                }
            }
        )
    }
)
{

    //isian di dalam scaffold
    Box(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(it)
    )
    {

        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()

        )
        {
            Box(
                contentAlignment = Alignment.BottomEnd,
                modifier = Modifier.padding(end = 20.dp)
            )
            {
                Image(
                    painter = painterResource(id = R.drawable.foto),
                    contentDescription = "foto",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .clickable(onClick = {}),

                    )
                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = "check",
                    modifier = modifier.size(20.dp)
                )
            }
            Column() {
                Text(text = "Gilang Bian Asawardhana")
                Text(text = "edit profile")
            }
        }


    }

    Box(contentAlignment=Alignment.Center
        ,modifier=Modifier.fillMaxSize()) {
        Column()
        {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Masuk")
            }
            OutlinedButton(onClick = { /*TODO*/ }) {
                Text(text = "Daftar")
            }
        }
    }

}//akhir dari scaffold

}//kurawal function

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun hm(modifier: Modifier=Modifier) {
    Scaffold(

        //topbar
        topBar = {
            TopAppBar(
                title = { Text(text = "njir") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                )
            )
        },

        //floatingactoinbutton
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }, shape = CircleShape) {
                Icon(imageVector = Icons.Default.Create, contentDescription = "add")

            }
        }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier.fillMaxSize()
        ) {


            Column() {
                //BIKIN CARD
                Card(
                    onClick = {},
                    colors = CardDefaults.cardColors(Color(0xFFEA7D7)),
                    modifier = modifier.size(160.dp),
                ) {
                    Text(
                        text = "Filled Card",
                        modifier = modifier.padding(6.dp)
                    )

                }
                //BIKIN FILTERCHIP
                var selected by remember { mutableStateOf(false) }
                FilterChip(selected = selected,
                    onClick = { selected = !selected },
                    label = { Text(text = "Filter Chip") },
                    leadingIcon = {
                        if (selected) {
                            Icon(
                                imageVector = Icons.Default.Done,
                                contentDescription = "done",
                                modifier = modifier.size(FilterChipDefaults.IconSize)
                            )
                        }
                    }
                )
            }
        }
    }
}
@Composable
fun ExampleAlertDialog() {
    AlertDialog(
            icon = {
                Icon(imageVector = Icons.Default.Delete, contentDescription = "delete")
            },
            title = {
                Text(text = "Hapus Kenangan")
            },
            text = {
                Text(text = "Apakah anda yakin ingin menghapus?")
            },
            onDismissRequest = { /*TODO*/ },
            dismissButton = {
                TextButton(onClick = { /*TODO*/ }) {
                    Text(text = "Gamon")

                }
            },
            confirmButton = {
                TextButton(onClick = { /*TODO*/ }) {
                    Text(text = "Hapus")

                }
            })
}

@Composable
fun ExampleDialog(modifier: Modifier=Modifier){
    Dialog(onDismissRequest = { /*TODO*/ }) {
        Card(modifier= Modifier
            .fillMaxWidth()
            .height(400.dp)
            .padding(16.dp)) {
                Column(modifier=Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter= painterResource(id = R.drawable.foto),
                            contentDescription = "bjir",
                            contentScale = ContentScale.Crop,
                            modifier= Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                        )
                        Text(
                            text = "Apakah kamu menyukai foto di atas?",
                            modifier=Modifier.padding(8.dp)
                        )
                        Row(modifier=Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center) {
                            TextButton(onClick = { /*TODO*/ },
                                modifier=Modifier.padding(horizontal = 8.dp)) {
                                Text(text = "Menyukai")

                            }
                            TextButton(onClick = { /*TODO*/ },
                                modifier=Modifier.padding(horizontal = 8.dp)) {
                                Text(text = "Tidak")

                            }



                        }
                }

            }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExampleSlider(modifier: Modifier=Modifier){
    var sliderValue by remember { mutableStateOf(0f..100f)}

    RangeSlider(
        value = sliderValue,
        onValueChange = {sliderValue=it},
        valueRange=0f..100f,
        steps=20,
        modifier = modifier.padding(16.dp)
    )

}

@Composable
fun ExampleIndicator(modifier: Modifier=Modifier){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
    ) {
        CircularProgressIndicator(
            modifier=Modifier,
            color = MaterialTheme.colorScheme.primary,
        )
        Spacer(modifier = modifier.height(8.dp))
        LinearProgressIndicator(
            modifier=Modifier,
            color = MaterialTheme.colorScheme.primary,
            trackColor = MaterialTheme.colorScheme.surfaceVariant
        )
    }

}

@Composable
fun ExampleSwitch(modifier: Modifier=Modifier){
    var checked by remember {
        mutableStateOf(true)}
    
    Switch(
        checked = checked,
        onCheckedChange ={checked=it},
        thumbContent = {
            if (checked){
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "check",
                    modifier=modifier.size(SwitchDefaults.IconSize)
                )
            }
        },
        modifier = modifier.padding(8.dp)


        )
}




@Preview(showBackground = true, device = "id:pixel_3a_xl", showSystemUi = true,
    wallpaper = Wallpapers.NONE
)
@Composable
    fun preview(){
        ExampleSwitch()
    }
