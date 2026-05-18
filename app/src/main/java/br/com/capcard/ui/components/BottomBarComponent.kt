package br.com.capcard.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.capcard.R
import br.com.capcard.ui.theme.AzulMedio
import br.com.capcard.ui.theme.Branco

data class BottomItem(
    val label: String,
    val iconOutline: Int,
    val iconFilled: Int
)

@Composable
fun BottomBarComponent() {

    var selectedItem by remember { mutableStateOf(1) }

    val items = listOf(
        BottomItem("Início", R.drawable.home, R.drawable.home_filled),
        BottomItem("Cartões", R.drawable.credit_card, R.drawable.credit_card ),
        BottomItem("Faturas", R.drawable.docs, R.drawable.docs_filled),
        BottomItem("Benefícios",  R.drawable.favorite,  R.drawable.favorite_filled),
    )

    NavigationBar(
        containerColor = Branco,
        tonalElevation = 8.dp
    ) {

        items.forEachIndexed { index, item ->

            val selected = selectedItem == index

            NavigationBarItem(
                selected = selected,
                onClick = { selectedItem = index },

                icon = {
                    Icon(
                        painter = painterResource(
                            id = if(selected) item.iconFilled else item.iconOutline),
                        contentDescription = item.label,
                        tint = if(selectedItem == index) AzulMedio else Color.Gray,
                        modifier = Modifier.size(24.dp)
                    )
                },

                label = {
                    Text(item.label, style = MaterialTheme.typography.titleSmall)
                },

                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = AzulMedio,
                    selectedTextColor = AzulMedio,
                    unselectedIconColor = Color.Gray,
                    unselectedTextColor = Color.Gray
                )
            )
        }
    }
}
