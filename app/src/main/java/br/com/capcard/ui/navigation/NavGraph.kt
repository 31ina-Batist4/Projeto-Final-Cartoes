package br.com.capcard.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import br.com.capcard.ui.screens.HomeScreen
import br.com.capcard.ui.screens.BenefitsScreen
import br.com.capcard.ui.screens.Cartoes.MeusCartoesScreen
import br.com.capcard.ui.screens.Faturas.FaturasScreen
import br.com.capcard.ui.screens.Login.LoginScreen
import br.com.capcard.ui.screens.dashboard.DashboardScreen
import br.com.capcard.ui.screens.resumodegastos.ResumoDeGastosScreen


@Composable
fun NavGraph(navController: NavHostController) {

  NavHost(
      navController = navController,
      startDestination = Routes.LOGIN
  ) {

      composable(Routes.HOME) {
          HomeScreen(navController)
      }

      composable(Routes.LOGIN){
          LoginScreen(navController)
      }

      composable(Routes.BENEFITS) {
          BenefitsScreen(navController)
      }

      composable(Routes.RESUME) {
          ResumoDeGastosScreen(navController)
      }

      composable(Routes.CARTOES) {
          MeusCartoesScreen(navController)
      }

      composable(Routes.FATURAS){
          FaturasScreen(navController)
      }

      composable(Routes.DASHBOARD){
          DashboardScreen(navController)
      }
  }

}