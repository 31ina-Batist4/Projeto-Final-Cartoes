package br.com.capcard.ui.screens

import android.webkit.WebView
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import br.com.capcard.ui.components.Bandeira
import br.com.capcard.ui.components.Cartao
import br.com.capcard.ui.components.CartaoDinâmico
import androidx.compose.foundation.lazy.items

@Composable
fun HomeScreen (
    navController: NavController
) {
    val listaCartoes = listOf(
        Cartao(
            nome = "Elina M V S Batista",
            numero = "4866 6413 3433 1226",
            bandeira = Bandeira.VISA
        ),
        Cartao(
            nome = "Elina M V S Batista",
            numero = "5093 7241 1554 5933",
            bandeira = Bandeira.MASTERCARD
        ),
        Cartao(
            nome = "Elina M V S Batista",
            numero = "5093 7241 1554 5933",
            bandeira = Bandeira.ELO
        )
    )

    LazyColumn {
        items(listaCartoes) { cartao ->
            CartaoDinâmico(cartao)
        }
    }



}
