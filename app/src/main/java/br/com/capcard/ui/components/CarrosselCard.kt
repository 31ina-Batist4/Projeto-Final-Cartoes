package br.com.capcard.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.com.capcard.R
import br.com.capcard.ui.theme.AzulClaro
import br.com.capcard.ui.theme.AzulEscuro

@Composable
fun CardCarousel() {
    Image(
        painter = painterResource(R.drawable.cartao_maria),
        contentDescription = "Cartao Principal",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(RoundedCornerShape(24.dp))
            .padding(horizontal = 16.dp)
            .background(
                Brush.horizontalGradient(
                    colors = listOf(
                        AzulClaro,
                        AzulEscuro
                    )
                ),
                shape = RoundedCornerShape(24.dp),
            )
    ) //{
//Tentativa de fazer um cartao
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(16.dp),
//            verticalArrangement = Arrangement.SpaceBetween
//        ) {
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.SpaceBetween) {
//                Image(
//                    painter = painterResource(R.drawable.logobranca),
//                    contentDescription = null,
//                    modifier = Modifier.height(24.dp),
//                    alpha = 1f)
//            }
//            Icon(
//                painter = painterResource(R.drawable.chipcartao),
//                contentDescription = null,
//                modifier = Modifier.height(30.dp),
//                tint = Branco)
//            Text(
//                "****    ****    ****    1234",
//                color = Color.White,
//                fontSize = 16.sp)
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.SpaceBetween) {
//                Text(
//                    "MARIA L M BARROS",
//                    color = Color.White,
//                    fontSize = 12.sp)
//                Text(
//                    "VISA",
//                    color = Color.White,
//                    fontWeight = FontWeight.Bold)
//            }
//        }
 //   }
    Spacer(modifier = Modifier.height(8.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center) {
        repeat(4) {
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .size(if (it == 0) 10.dp else 6.dp)
                    .background(
                        if (it == 0) Color.Blue else Color.LightGray,
                        shape = CircleShape
                    )
            )
        }
    }
}

