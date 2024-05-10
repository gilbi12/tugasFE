package com.example.infinitetest

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.BrowseGallery
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Topic
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.infinitetest.data.Grid
import com.example.infinitetest.data.Mentee
import com.example.infinitetest.data.Mentor
import com.example.infinitetest.data.dataprovidergrid
import com.example.infinitetest.data.dataprovidermentee
import com.example.infinitetest.data.dataprovidermentor
import com.example.infinitetest.navigation.NavigationItem
import com.example.infinitetest.navigation.Screen
import com.example.infinitetest.ui.theme.InfinitetestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InfinitetestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    InfiniteApp()
                }
            }
        }

    }


}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InfiniteApp(
    modifier: Modifier=Modifier,
    navController: NavHostController = rememberNavController()
){
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route

    Scaffold(
        topBar =  {
            if (currentRoute == Screen.Home.route) {
                TopAppBar(
                    title = { Text(text = "Home") }
                )
            }
            else if (currentRoute == Screen.Gallery.route){
                TopAppBar(
                    title = { Text(text = "Gallery") }
                )
            }
            else if (currentRoute == Screen.About.route){
                TopAppBar(
                    title = { Text(text = "About") }
                )
            }
        } ,
        bottomBar = {
            BottomBar(navController)
        },
        modifier = modifier
    )


    { contentPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier=Modifier.padding(contentPadding))
        {
            composable(Screen.Home.route){
                HomeScreen(navController)
            }
            composable(Screen.Gallery.route){
                GalleryScreen(navController)
            }
            composable(Screen.About.route){
                AboutScreen()
            }
            composable(Screen.DetailMentor.route){
                    backstackEntry ->
                val mentorId= backstackEntry.arguments?.getString("mentorId") ?.toInt() ?: 0
                MentorDetailScreen( mentorId = mentorId, navController)
            }
            composable(Screen.DetailMentee.route) {
                    backStackEntry ->
                val menteeId=backStackEntry.arguments?.getString("menteeId") ?.toInt() ?: 0
                MenteeDetailScreen( menteeId = menteeId, navController)
            }
            composable(Screen.DetailGrid.route) {
                    backStackEntry ->
                val gridId=backStackEntry.arguments?.getString("gridId") ?.toInt() ?: 0
                gridDetailScreen( gridId = gridId, navController)
            }

        }
    }
}



@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MentorDetailScreen(mentorId: Int, navController: NavHostController){
    val mentor = dataprovidermentor.mentors.find { it.id == mentorId }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Mentor Detail") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) {
        if (mentor != null) {
            Column(modifier= Modifier
                .fillMaxSize()
                .padding(vertical = 70.dp, horizontal = 16.dp)) {
                Box (contentAlignment = Alignment.TopCenter){
                    Image(
                        painter = painterResource(id = mentor.imageid),
                        contentDescription = "gambar",
                        modifier = Modifier
                            .padding(bottom = 16.dp)
                            .clip(
                                RoundedCornerShape(32.dp)
                            )
                            .fillMaxWidth()
                            .size(300.dp)
                    )
                }
                Column {

                    Text(text = mentor.nama, style = typography.titleLarge)
                    Text(text = mentor.prodi, style = typography.labelLarge)
                }
                Text(text = mentor.desc, style = typography.bodyMedium, modifier = Modifier.padding(top = 16.dp))
            }
        } else {
            Text(text = "Mentor tidak ada")
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenteeDetailScreen(menteeId: Int, navController: NavHostController){
    val mentee = dataprovidermentee.mentee.find { it.id==menteeId}

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Mentee Detail") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) {
        if(mentee != null){
            Column(modifier= Modifier
                .fillMaxSize()
                .padding(vertical = 70.dp, horizontal = 16.dp)) {

                Box (contentAlignment = Alignment.TopCenter){
                    Image(
                        painter = painterResource(id = mentee.imageid),
                        contentDescription = "gambar",
                        modifier = Modifier
                            .padding(bottom = 16.dp)
                            .clip(
                                RoundedCornerShape(32.dp)
                            )
                            .fillMaxWidth()
                            .size(300.dp)
                    )
                }
                Column {

                    Text(text = mentee.nama, style = typography.titleLarge)
                    Text(text = mentee.prodi, style = typography.labelLarge)
                }
                Text(text = mentee.desc, style = typography.bodyMedium, modifier = Modifier.padding(top = 16.dp))
            }
        }
        else{
            Text(text = "Mentee tidak ada")
        }
    }
}

@Composable
fun MenteeItem(mentee: Mentee,modifier: Modifier=Modifier, navController: NavController) {

    Row(modifier = Modifier
        .fillMaxSize()
        .clickable {
            val route =
                Screen.DetailMentee.route.replace("{menteeId}", mentee.id.toString())
            navController.navigate(route)
        }) {
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
fun menteeImage(mentee: Mentee){
    Image(painter = painterResource(id = mentee.imageid), contentDescription ="gambar",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(84.dp)
            .clip(CircleShape))
}

@Composable
fun HorizontalMentorItem(mentor: Mentor, modifier: Modifier= Modifier, navController: NavHostController){
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
fun HomeScreen(
    navController: NavHostController,modifier: Modifier=Modifier,

){
    val mentors= remember { dataprovidermentor.mentors}
    val mentee= remember { dataprovidermentee.mentee}


    Column(modifier= modifier
        .fillMaxSize().height(1500.dp)
        .verticalScroll(rememberScrollState())) {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            items(
                items = mentors,
                itemContent = {
                    HorizontalMentorItem(mentor = it, navController=navController)
                }
            )
        }
        LazyColumn(modifier= modifier
            .height(1050.dp)
            .padding(top = 32.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            userScrollEnabled = false)
        {
            items(
                items = mentee,
                itemContent = {
                    MenteeItem(mentee = it,navController=navController)

                }
            )
        }
    }
}

@Composable
fun GalleryScreen(navController: NavHostController,modifier: Modifier=Modifier){
    val grid= remember { dataprovidergrid.grids}

    Column(modifier= Modifier
        .fillMaxSize()
       ) {


        LazyVerticalGrid(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            columns = GridCells.Fixed(2),
            modifier = modifier.fillMaxSize()
        ) {
            items(grid) {
                gridItem(grid = it, navController = navController)
            }
        }
    }
}

@Composable
fun gridItem(grid: Grid, modifier: Modifier=Modifier, navController: NavController){

    Card(shape = RoundedCornerShape(16.dp),modifier = Modifier
        .padding(8.dp)
        .clickable {
            val route =
                Screen.DetailGrid.route.replace("{gridId}", grid.id.toString())
            navController.navigate(route)
        },
        elevation = CardDefaults.cardElevation(2.dp))
       {


        Column(modifier = Modifier.fillMaxSize()) {
            gridImage(grid = grid)


        }
    }
}


@Composable
fun gridImage(grid: Grid){
    Image(painter = painterResource(id = grid.imageid), contentDescription ="gambar",
   )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun gridDetailScreen(gridId: Int, navController: NavHostController){
    val grid = dataprovidergrid.grids.find { it.id == gridId }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Card Detail") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ){
        if (grid != null){
            Column(modifier= Modifier
                .fillMaxSize()
                .padding(vertical = 70.dp, horizontal = 16.dp)) {
                Image(painter = painterResource(id = grid.imageid) , contentDescription = "gambar", modifier= Modifier
                    .padding(bottom = 16.dp)
                    .clip(
                        RoundedCornerShape(8.dp)
                    ))
                Column {

                    Text(text = grid.nama, style = typography.titleLarge)
                    Text(text = grid.prodi, style = typography.labelLarge)
                }
                Text(text = grid.desc, style = typography.bodyMedium, modifier = Modifier.padding(top = 16.dp))
            }
        }
        else{
            Text(text = "Card tidak tersedia")
        }
    }

}

@Composable
fun AboutScreen(){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
            ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp), contentAlignment = Alignment.TopCenter
        ) {
            Image(
                painter = painterResource(id = R.drawable.fotogue),
                contentDescription = "backprofil",
                modifier = Modifier
                    .size(235.dp)
                    .clip(CircleShape)
            )
        }



            Card(modifier= Modifier
                .padding(8.dp)
                .fillMaxWidth()) {


                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = "Nama")
                    Text(text = "Gilang Bian Asawardhana")
                }
            }
            Card (modifier= Modifier
                .padding(8.dp)
                .fillMaxWidth()){


                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = "Email")
                    Text(text = "gilangbian22@student.ub.ac.id")
                }
            }
            Card(modifier= Modifier
                .padding(8.dp)
                .fillMaxWidth()) {


                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = "Universitas")
                    Text(text = "Universitas Brawijaya")
                }
            }
            Card(modifier= Modifier
                .padding(8.dp)
                .fillMaxWidth()) {


                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = "Jurusan")
                    Text(text = "Sistem Informasi")
                }
            }
        }
    }




@Preview(showBackground = true, device = "id:pixel_3a_xl", showSystemUi = true,
    wallpaper = Wallpapers.NONE)
@Composable
fun previewwwww(){

}





@Composable
private fun BottomBar(
    navController: NavHostController,
    modifier: Modifier=Modifier
)
{
    NavigationBar(modifier=modifier) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        val navigationItems = listOf(
            NavigationItem(
                title = stringResource(id = R.string.menu_home),
                icon = Icons.Default.Home,
                screen = Screen.Home
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_gallery),
                icon = Icons.Default.BrowseGallery,
                screen = Screen.Gallery
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_about),
                icon = Icons.Default.Person,
                screen = Screen.About
            )
        )
        navigationItems.map {
            item ->
                NavigationBarItem(selected = currentRoute==item.screen.route,
                    onClick = {
                              navController.navigate(item.screen.route){
                                  popUpTo(navController.graph.findStartDestination().id){
                                      saveState=true
                                  }
                                  restoreState=true
                                  launchSingleTop=true
                              }
                    },
                    icon = { Icon(imageVector = item.icon, contentDescription = item.title)
                    },
                    label= { Text(text = item.title)}
                    )
        }
    }



}

