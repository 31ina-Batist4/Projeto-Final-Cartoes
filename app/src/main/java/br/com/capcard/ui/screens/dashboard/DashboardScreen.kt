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
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.capcard.ui.theme.AzulEscuro

@Composable
fun DashboardScreen(){
    Column(
        modifier = Modifier.fillMaxSize().background(Color.White).statusBarsPadding().padding(25.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween) {
            Column {
                Text("Olá, MARIA", fontWeight = FontWeight.Bold, color = AzulEscuro)
                Text("Bem-vinda de volta!", color = Color.Gray)
            }
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = null,
                tint = AzulEscuro
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        CardCarousel()
        Spacer(modifier = Modifier.height(10.dp))
        LimiteCard()
        Spacer(modifier = Modifier.height(10.dp))
        Atalho()
        Spacer(modifier = Modifier.height(10.dp))
        Transacoes()
    }
}


