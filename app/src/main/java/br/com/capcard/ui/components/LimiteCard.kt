package br.com.capcard.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.capcard.R
import br.com.capcard.ui.theme.AzulClaro
import br.com.capcard.ui.theme.AzulEscuro
import br.com.capcard.ui.theme.AzulMedio
import br.com.capcard.ui.theme.Branco
import br.com.capcard.ui.theme.Texto

@Composable
fun LimiteCard() {
    Column {
        Card(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Branco),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()) {
                    Text("Limite disponível", color = Texto, style = MaterialTheme.typography.labelSmall)
                    Icon(
                        painter = painterResource(R.drawable.visualizar),
                        contentDescription = "Mostrar limite",
                        tint = Texto,
                        modifier = Modifier.size(18.dp))
                }
                Text(
                    "R$ 4.250,00",
                    style = MaterialTheme.typography.titleMedium,
                    color = AzulEscuro
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    Text("de R$ 7.500,00", color = Texto, style = MaterialTheme.typography.labelSmall)
                    Text(
                        "56%",
                        color = AzulEscuro,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                LinearProgressIndicator(
                    progress = { 0.56f },
                    modifier = Modifier.fillMaxWidth(),
                    color = AzulMedio
                )
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Card(
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Branco),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text("Gastos deste mês",color = Texto, style = MaterialTheme.typography.labelSmall)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text("R$ 3.250,80", style = MaterialTheme.typography.bodyMedium)
                }
            }
            Card(
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Branco),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text("Melhor dia de compra", color = Texto, style = MaterialTheme.typography.labelSmall)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text("05 MAI", style = MaterialTheme.typography.bodyMedium, color = AzulMedio)
                }
            }
        }
    }
}

