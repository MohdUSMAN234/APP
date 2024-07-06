package com.example.thenavrangclub.ui

import com.example.flash.ui.NavViewModel
import com.example.thenavrangclub.R

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

enum class NavrangAppScreen {
    Start,
    Items,
    Cart
}

@Composable
fun NavrangApp(
    navViewModel: NavViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = NavrangAppScreen.Start.name) {
        composable(route = NavrangAppScreen.Start.name) {
            StartScreen(
                navViewModel = navViewModel,
                onCategoryClicked = { category ->
                    navController.navigate(NavrangAppScreen.Items.name)
                }
            )
        }
        composable(route = NavrangAppScreen.Items.name) {
            ItemsScreen(navController = navController)
        }
        composable(route = NavrangAppScreen.Cart.name) {
            CartScreen(navController = navController)
        }
    }
}
