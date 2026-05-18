package br.com.capcard.ui.screens.Cartoes

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.capcard.model.CartaoUI
import br.com.capcard.ui.components.CardCartoesComponent
import br.com.capcard.ui.components.ToolbarComponent
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import br.com.capcard.R
import br.com.capcard.ui.components.BottomBarComponent
import br.com.capcard.ui.navigation.Routes
import br.com.capcard.ui.theme.AzulClaro
import br.com.capcard.ui.theme.AzulEscuro

@Composable
fun MeusCartoesScreen(
    navController: NavController
) {

    val listaCartoes = listOf(
        CartaoUI(
            nome = "Mastercard Gold",
            numeroCartao = "2708 6949 7468 1224",
            limite = "R$ 5.000,00",
            disponivel = "R$ 2.800,00",
            bandeira = "Mastercard"
        ),
        CartaoUI(
            nome = "Cartão Virtual",
            numeroCartao = "4866 6413 3433 1226",
            limite = "R$ 2.000,00",
            disponivel = "R$ 1.200,00",
            bandeira = "VISA"
        ),
        CartaoUI(
            nome = "Cartão Virtual",
            numeroCartao = "5093 7241 1554 5933",
            limite = "R$ 8.000,00",
            disponivel = "R$ 6.200,00",
            bandeira = "ELO"
        )
    )

    Scaffold(
        topBar = {
            ToolbarComponent(
                onBack = {navController.navigate(Routes.HOME)},// navController.popBackStack() },
                onAdd = {}
            )
        },
        bottomBar = {
            BottomBarComponent()
        }

    ) { padding ->
        Column  (
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.cartao),
                contentDescription = "Cartao Principal",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .padding(horizontal = 24.dp)
                    .background(
                        Brush.horizontalGradient(
                            colors = listOf(
                                AzulClaro,
                                AzulEscuro
                            )
                        )
                    )
            )
            LazyColumn {
                items(listaCartoes) { cartao ->
                    CardCartoesComponent(
                        cartao = cartao,
                        modifier = Modifier.padding(4.dp)
                    )
                }
            }

        }
    }

}