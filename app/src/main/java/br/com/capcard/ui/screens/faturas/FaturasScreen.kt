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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.capcard.model.FaturaHistorico
import br.com.capcard.ui.components.BottomBarComponent
import br.com.capcard.ui.components.ToolbarComponent
import br.com.capcard.ui.theme.AzulClaro
import br.com.capcard.ui.theme.AzulEscuro
import br.com.capcard.ui.theme.AzulMedio
import br.com.capcard.ui.theme.Branco
import br.com.capcard.ui.theme.BrancoG
import br.com.capcard.ui.theme.Gelo
import java.nio.file.WatchEvent

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
   Scaffold (
       topBar = {
           ToolbarComponent(
               onBack = { navController.popBackStack() },
               onAdd = {},
               true,
               false,
               "Faturas"
           )
       },
       bottomBar = {
           BottomBarComponent(navController)
       },
       containerColor = Gelo

   ) { padding ->
       Column(
           modifier = Modifier
               .fillMaxSize()
               .background(Branco)
               .padding(padding)
       ) {

           Card(
               modifier = Modifier.fillMaxWidth()
                   .padding(horizontal = 16.dp)
                   .background(  Brush.verticalGradient(
                       colors = listOf(
                           AzulClaro,
                           AzulMedio
                       )
                   ), shape = RoundedCornerShape(24.dp)),
               colors = CardDefaults.cardColors(
                   containerColor = Color.Transparent
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
                           color = Branco,
                           fontWeight = FontWeight.Bold
                       )

                       Text(
                           text = "Aberta",
                           color = Branco,
                           modifier = Modifier
                               .background(
                                   color = Color(0xFF5AA6FF),
                                   shape = RoundedCornerShape(16.dp)
                               )
                       )
                   }

                   Spacer(modifier = Modifier.height(12.dp))

                   Text(
                       text = "R$ 1.250,60",
                       color = Branco,
                       style = MaterialTheme.typography.titleLarge,
                   )

                   Spacer(modifier = Modifier.height(24.dp))

                   Row(
                       modifier = Modifier.fillMaxWidth(),
                       horizontalArrangement = Arrangement.SpaceBetween
                   ) {

                       Column {

                           Text(
                               text = "Vencimento",
                               style = MaterialTheme.typography.bodySmall,
                               color =BrancoG
                           )

                           Text(
                               text = "10 JUN",
                               style = MaterialTheme.typography.titleMedium,
                               color = Branco
                           )
                       }

                       Column {

                           Text(
                               text = "Melhor dia de compra",
                               color = BrancoG,
                               style = MaterialTheme.typography.bodySmall,
                           )

                           Text(
                               text = "05 JUN",
                               color = Branco,
                               style = MaterialTheme.typography.titleMedium
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
                   .padding(horizontal = 16.dp)
                   .height(52.dp),
               shape = RoundedCornerShape(14.dp),
               colors = ButtonDefaults.buttonColors(
                   containerColor = AzulMedio
               )
           ) {

               Text(
                   text = "Pagar fatura",
                   style = MaterialTheme.typography.titleMedium,
                   color = Branco
               )
           }

           Spacer(modifier = Modifier.height(24.dp))

           // Título histórico
           Text(
               text = "Histórico de faturas",
              style = MaterialTheme.typography.titleMedium,
               color = AzulEscuro,
               modifier = Modifier
                   .fillMaxWidth()
                   .padding(horizontal = 16.dp)
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
}

@Composable
fun ItemHistoricoFatura(
    item: FaturaHistorico
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 14.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = item.mes,
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.bodyMedium,
            color = AzulEscuro
        )

        Text(
            text = item.valor,
            style = MaterialTheme.typography.bodyMedium,
            color = AzulEscuro
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = "• ${item.status}",
            color = Color(0xFF00A651),
            modifier = Modifier
                .background(
                    color = Color(0xFFE8F5E9),
                    shape = RoundedCornerShape(16.dp)
                )
        )
    }
}