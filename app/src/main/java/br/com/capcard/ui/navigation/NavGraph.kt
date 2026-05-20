package br.com.capcard.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import br.com.capcard.ui.screens.beneficios.BenefitsScreen
import br.com.capcard.ui.screens.cartoes.MeusCartoesScreen
import br.com.capcard.ui.screens.faturas.FaturasScreen
import br.com.capcard.ui.screens.login.LoginScreen
import br.com.capcard.ui.screens.dashboard.DashboardScreen
import br.com.capcard.ui.screens.resumodegastos.ResumoDeGastosScreen


@Composable
fun NavGraph(navController: NavHostController) {

  NavHost(
      navController = navController,
      startDestination = Routes.LOGIN
  ) {

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