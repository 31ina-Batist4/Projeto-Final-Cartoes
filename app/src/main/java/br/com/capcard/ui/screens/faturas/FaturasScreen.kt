package br.com.capcard.ui.screens.faturas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.capcard.model.FaturaHistorico

@Composable
fun FaturasScreen(
    navController: NavController
) {

    val listaHistorico = listOf(
        FaturaHistorico("Maio", "R$ 1.120,40", "Pago"),
        FaturaHistorico("Abril", "R$ 980,30", "Pago"),
        FaturaHistorico("Março", "R$ 1.300,10", "Pago"),
        FaturaHistorico("Fevereiro", "R$ 509,10", "Pago")
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .statusBarsPadding()
            .padding(16.dp)
    ) {

        // Título
        Text(
            text = "Faturas",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1E1E1E)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Card principal
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF0057FF)
            )
        ) {

            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Text(
                        text = "Fatura atual",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Aberta",
                        color = Color.White
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "R$ 1.250,60",
                    color = Color.White,
                    fontSize = 34.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Column {

                        Text(
                            text = "Vencimento",
                            color = Color(0xFFD9E4FF)
                        )

                        Text(
                            text = "10 JUN",
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Column {

                        Text(
                            text = "Melhor dia de compra",
                            color = Color(0xFFD9E4FF)
                        )

                        Text(
                            text = "05 JUN",
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botão
        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            shape = RoundedCornerShape(14.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF0057FF)
            )
        ) {

            Text(
                text = "Pagar fatura"
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Título histórico
        Text(
            text = "Histórico de faturas",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Lista dinâmica
        LazyColumn {

            items(listaHistorico) { item ->

                ItemHistoricoFatura(item)
            }
        }
    }
}

@Composable
fun ItemHistoricoFatura(
    item: FaturaHistorico
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = item.mes,
            modifier = Modifier.weight(1f),
            fontSize = 18.sp
        )

        Text(
            text = item.valor,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = "• ${item.status}",
            color = Color(0xFF00A651)
        )
    }
}