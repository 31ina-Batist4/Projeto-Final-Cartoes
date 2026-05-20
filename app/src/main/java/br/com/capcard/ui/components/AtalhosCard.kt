package br.com.capcard.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.capcard.R
import br.com.capcard.ui.navigation.Routes
import br.com.capcard.ui.theme.AzulClaro
import br.com.capcard.ui.theme.AzulEscuro
import br.com.capcard.ui.theme.Texto

@Composable
fun Atalho(navController: NavController) {
    Column {
        Text("Atalhos", style = MaterialTheme.typography.bodyMedium, color = AzulEscuro)
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween) {
            AtalhoItem(
                "Pagar fatura",
                painterResource(R.drawable.docs),
                { navController.navigate(Routes.FATURAS) }
            )
            AtalhoItem(
                "Resumo",
                painterResource(R.drawable.baseline_bar_chart_24),
                { navController.navigate(Routes.RESUME) }
            )
            AtalhoItem(
                "Cartões",
                painterResource(R.drawable.credit_card),
                { navController.navigate(Routes.CARTOES) }
            )
            AtalhoItem(
                "Mais Opções",
                painterResource(R.drawable.outline_apps_24),
                {}
            )
        }
    }
}

@Composable
fun AtalhoItem(text: String, icon: Painter, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
       IconButton(onClick = { onClick() }) {
           Icon(
               painter = icon,
               contentDescription = null,
               tint = AzulClaro,
               modifier = Modifier.size(24.dp
               )
           )
       }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text,
            style = MaterialTheme.typography.labelSmall,
            color = Texto
        )
    }
}

