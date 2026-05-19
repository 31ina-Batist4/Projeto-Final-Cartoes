package br.com.capcard.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
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
import br.com.capcard.R
import br.com.capcard.ui.theme.AzulClaro
import br.com.capcard.ui.theme.AzulEscuro

@Composable
fun Atalho() {
    Column {
        Text("Atalhos", fontWeight = FontWeight.Bold, color = AzulEscuro)
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround) {
            AtalhoItem(
                "Pagar fatura",
                painterResource(R.drawable.fatura)
            )
            AtalhoItem(
                "Resumo",
                painterResource(R.drawable.grafico)
            )
            AtalhoItem(
                "Cartões",
                painterResource(R.drawable.credit_card)
            )
            AtalhoItem(
                "Mais Opções",
                painterResource(R.drawable.opcoes)
            )
        }
    }
}

@Composable
fun AtalhoItem(text: String, icon: Painter) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = icon,
            contentDescription = null,
            tint = AzulClaro,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text,
            fontSize = 12.sp,
            color = Color.Black
        )
    }
}

