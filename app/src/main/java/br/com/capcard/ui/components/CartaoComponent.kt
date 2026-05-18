package br.com.capcard.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Icon
import androidx.compose.ui.text.font.FontWeight
import br.com.capcard.R
import br.com.capcard.ui.theme.AzulClaro
import br.com.capcard.ui.theme.AzulEscuro
import br.com.capcard.ui.theme.AzulMedio
import br.com.capcard.ui.theme.Branco


data class Cartao(
    val nome: String,
    val numero: String,
    val bandeira: Bandeira
)
enum class Bandeira {
    VISA,
    MASTERCARD,
    ELO
}

@Composable
fun CartaoDinâmico(cartao: Cartao) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(RoundedCornerShape(24.dp))
            .padding(horizontal = 12.dp)
            .background(
                Brush.horizontalGradient(
                    colors = listOf(
                        AzulClaro,
                        AzulEscuro
                    )
                )
            )
            .padding(16.dp)
    ) {

        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("CAPCARD", color = Color.White, fontWeight = FontWeight.Bold)

            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {

                Box(
                    modifier = Modifier
                        .size(width = 40.dp, height = 28.dp)
                        .background(Color.LightGray, RoundedCornerShape(6.dp))
                )

                Spacer(modifier = Modifier.width(8.dp))

                Icon(
                    painter = painterResource(R.drawable.contactless),
                    contentDescription = null,
                    tint = Branco,
                    modifier = Modifier.size(32.dp)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = cartao.numero,
                color = Color.White,
                letterSpacing = 2.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = cartao.nome.uppercase(),
                    color = Color.White
                )

                Image(
                    painter = painterResource(
                        id = getBandeiraIcon(cartao.bandeira)
                    ),
                    contentDescription = null,
                    modifier = Modifier.height(50.dp)
                )
            }
        }
    }
}

fun getBandeiraIcon(bandeira: Bandeira): Int {
    return when (bandeira) {
        Bandeira.VISA -> R.drawable.ic_visa
        Bandeira.MASTERCARD -> R.drawable.ic_mastercard
        Bandeira.ELO -> R.drawable.ic_elo
    }
}
