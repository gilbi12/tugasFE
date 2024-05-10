package com.example.infinitetest.navigation

sealed class Screen(val route:String) {
    data object Home : Screen("Home")
    data object Gallery : Screen("Gallery")
    data object About : Screen("About")
    data object DetailMentor : Screen ("detail/mentor/{mentorId}")
    data object DetailMentee : Screen ("detail/mentee/{menteeId}")
    data object DetailGrid : Screen ("detail/grid/{gridId}")
}

