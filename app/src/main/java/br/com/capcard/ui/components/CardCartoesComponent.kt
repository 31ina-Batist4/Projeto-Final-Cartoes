package br.com.capcard.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.com.capcard.R
import br.com.capcard.model.CartaoUI
import br.com.capcard.ui.theme.AzulEscuro
import br.com.capcard.ui.theme.Branco
import br.com.capcard.ui.theme.Texto

@Composable
fun CardCartoesComponent(
    cartao: CartaoUI,
    modifier: Modifier = Modifier
) {

    val icone  = when (cartao.bandeira) {
        "VISA" -> R.drawable.ic_visa
        "ELO" -> R.drawable.ic_elo
        "Mastercard" -> R.drawable.ic_mastercard
        else -> R.drawable.ic_visa
    }
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clickable{},
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Branco)
    ) {
        Column (modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = cartao.nome,
                    style = MaterialTheme.typography.bodyMedium,
                    color = AzulEscuro
                )

                Image(
                    painter = painterResource(id = icone),
                    contentDescription = "Bandeira cartão",
                    modifier = Modifier.height(34.dp)
                )

            }
                Spacer(modifier = Modifier.height(8.dp))


                Text(
                    text = cartao.numeroCartao,
                    color = Texto,
                    style = MaterialTheme.typography.labelSmall
                )

                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Column {
                        Text("Limite", color = Texto, style = MaterialTheme.typography.labelSmall)
                        Text(
                            text = cartao.limite,
                            style = MaterialTheme.typography.bodyMedium,
                            color = AzulEscuro
                        )
                    }

                    Column {

                        Text("Disponível", color = Texto, style = MaterialTheme.typography.labelSmall)
                        Text(
                            text = cartao.disponivel,
                            style = MaterialTheme.typography.bodyMedium,
                            color = AzulEscuro
                        )

                    }
                }
        }
    }
}