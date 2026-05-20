package br.com.capcard.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.navigation.NavController
import br.com.capcard.R
import br.com.capcard.ui.navigation.Routes
import br.com.capcard.ui.theme.AzulMedio
import br.com.capcard.ui.theme.Branco
import br.com.capcard.ui.theme.Texto

data class BottomItem(
    val label: String,
    val iconOutline: Int,
    val iconFilled: Int,
    val route: String
)

@Composable
fun BottomBarComponent(
    navController: NavController
) {

    var selectedItem by remember { mutableStateOf(1) }

    val currentRoute = navController.currentBackStackEntry
        ?.destination
        ?.route

    val items = listOf(
        BottomItem("Início", R.drawable.home, R.drawable.home_filled, Routes.DASHBOARD),
        BottomItem("Cartões", R.drawable.credit_card, R.drawable.credit_card, Routes.CARTOES ),
        BottomItem("Faturas", R.drawable.docs, R.drawable.docs_filled, Routes.FATURAS),
        BottomItem("Benefícios",  R.drawable.favorite,  R.drawable.favorite_filled, Routes.BENEFITS),
    )

    NavigationBar(
        containerColor = Branco,
        tonalElevation = 8.dp
    ) {

        items.forEachIndexed { index, item ->
            
            val selecionado = currentRoute == item.route

            NavigationBarItem(
                selected = selecionado,
                onClick = { selectedItem = index },

                icon = {
                    IconButton( onClick = { navController.navigate(item.route)}) {
                        Icon(
                            painter = painterResource(
                                id = if(selecionado) item.iconFilled else item.iconOutline),
                            contentDescription = item.label,
                            tint = if(selecionado) AzulMedio else Texto,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                },

                label = {
                    Text(item.label, style = MaterialTheme.typography.titleSmall)
                },

                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = AzulMedio,
                    selectedTextColor = AzulMedio,
                    unselectedIconColor = Texto,
                    unselectedTextColor = Texto
                )
            )
        }
    }
}
