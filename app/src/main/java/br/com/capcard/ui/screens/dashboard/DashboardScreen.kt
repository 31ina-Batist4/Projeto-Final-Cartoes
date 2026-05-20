package br.com.capcard.ui.screens.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import br.com.capcard.ui.components.Atalho
import br.com.capcard.ui.components.BottomBarComponent
import br.com.capcard.ui.components.CardCarousel
import br.com.capcard.ui.components.LimiteCard
import br.com.capcard.ui.components.Transacoes
import br.com.capcard.ui.theme.AzulEscuro
import br.com.capcard.ui.theme.Branco
import br.com.capcard.ui.theme.Texto
import br.com.capcard.R
import br.com.capcard.ui.theme.Gelo

@Composable
fun DashboardScreen(navController: NavHostController) {

    Scaffold (
        bottomBar = {
            BottomBarComponent(navController)
        },
        containerColor = Gelo
    ) { padding ->
        Column(
            modifier = Modifier.fillMaxSize().background(Branco).padding(25.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween) {
                Column {
                    Text("Olá, MARIA", style = MaterialTheme.typography.titleMedium, color = AzulEscuro)
                    Text("Bem-vinda de volta!", color = Texto)
                }
                Icon(
                    painter = painterResource(R.drawable.baseline_notifications_none_24),
                    contentDescription = null,
                    tint = AzulEscuro
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            CardCarousel()
            Spacer(modifier = Modifier.height(10.dp))
            LimiteCard()
            Spacer(modifier = Modifier.height(10.dp))
            Atalho(navController)
            Spacer(modifier = Modifier.height(10.dp))
            Transacoes()
        }
    }
}


