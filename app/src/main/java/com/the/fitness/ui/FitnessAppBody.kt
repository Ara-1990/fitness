package com.the.fitness.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.the.fitness.R
import com.the.fitness.ui.All_Exercises_Screen
import com.the.fitness.ui.ViewModel
import com.the.fitness.ui.WorkOutsScreen
import com.the.fitness.ui.WorkoutDetails

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FitnessAppBody() {


    val nav = rememberNavController()


    Scaffold(

        topBar = {
            TopAppBar(
                title = { Text("TrainUp") }
            )
        },

        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = false,
                    onClick = {
                        nav.navigate("home") {
                            popUpTo(nav.graph.findStartDestination().id) { saveState = true }
                            launchSingleTop = true; restoreState = true
                        }
                    },

                    icon = { Icon(Icons.Outlined.Home, null) },
                    label = { Text("Exercises") }
                )
                NavigationBarItem(
                    selected = false,
                    onClick = {
                        nav.navigate("workout") {
                            popUpTo(nav.graph.findStartDestination().id) { saveState = true }
                            launchSingleTop = true; restoreState = true
                        }
                    },

                    icon = { Icon(Icons.Outlined.Person, null) },
                    label = { Text("workout") }
                )
            }
        }
    ){
            padding ->
        NavHost(
            navController = nav,
            startDestination = "home",
            modifier = Modifier.padding(padding)
        ) {
            composable("home") {
                All_Exercises_Screen()

            }
            composable("workout") {

                WorkOutsScreen { week, workout ->
                    nav.navigate("workout/$week/$workout")
                }
            }

            composable("workout/{week}/{workout}") { backStackEntry ->
                val week = backStackEntry.arguments?.getString("week")?.toInt() ?: 1
                val workout = backStackEntry.arguments?.getString("workout")?.toInt() ?: 1

                val viewModel: ViewModel = hiltViewModel(backStackEntry)
                WorkoutDetails(viewModel = viewModel,week = week, workout =  workout)
            }
        }

    }

    }
