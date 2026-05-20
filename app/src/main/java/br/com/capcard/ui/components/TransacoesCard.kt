package br.com.capcard.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
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
import br.com.capcard.R
import br.com.capcard.ui.theme.AzulClaro
import br.com.capcard.ui.theme.AzulEscuro
import br.com.capcard.ui.theme.AzulMedio
import br.com.capcard.ui.theme.Texto

@Composable
fun Transacoes() {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                "Últimas transações",
                style = MaterialTheme.typography.bodyMedium,
                color = AzulEscuro
            )
            Text(
                "Ver todas",
                color = AzulMedio,
                style = MaterialTheme.typography.bodyMedium
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        TransacoesItem("Mercado Livre", "Compras", "- R$ 128,90", "Hoje",
            icon = painterResource(R.drawable.fatura))
        TransacoesItem("Posto Ipiranga", "Combustível", "- R$ 150,00", "Ontem",
            icon = painterResource(R.drawable.postodegasolina))
        TransacoesItem("Uber", "Transporte", "- R$ 32,40", "30 MAIO",
            icon = painterResource(R.drawable.uber))
    }
}

@Composable
fun TransacoesItem(title: String, subtitle: String, value: String,
                   date: String, icon: Painter) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = icon,
                contentDescription = title,
                tint = AzulEscuro,
                modifier = Modifier.size(22.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Column {
                Text(title, style = MaterialTheme.typography.bodyMedium, color = Color.DarkGray)
                Text(
                    subtitle,
                    style = MaterialTheme.typography.labelSmall,
                    color = Texto
                )
            }
        }
        Column(horizontalAlignment = Alignment.End) {
            Text(
                value,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.DarkGray
            )
            Text(
                date,
                style = MaterialTheme.typography.labelSmall,
                color = Texto
            )
        }
    }
}