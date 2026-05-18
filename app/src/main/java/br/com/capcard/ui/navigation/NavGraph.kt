package br.com.capcard.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import br.com.capcard.ui.screens.HomeScreen
import br.com.capcard.ui.screens.BenefitsScreen


@Composable
fun NavGraph(navController: NavHostController) {

  NavHost(
      navController = navController,
      startDestination = Routes.HOME
  ) {

      composable(Routes.HOME) {
          HomeScreen(navController)
      }

      composable(Routes.BENEFITS) {
          BenefitsScreen(navController)
      }

  }

}