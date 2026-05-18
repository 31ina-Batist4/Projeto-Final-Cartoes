package br.com.capcard.preview

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DirectionsBus
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import br.com.capcard.ui.components.ItemDeCategoria
import br.com.capcard.ui.theme.AzulMedio

data class DespesaMensal(
    val month: String,
    val total: String,
    val variation: String,
    val chartValues: List<Float>,
    val chartLabels: List<String>,
    val categories: List<ItemDeCategoria>
)

data class ItemDeCategoria(
    val name: String,
    val value: String,
    val progress: Float,
    val icon: ImageVector,
    val color: Color
)

val previewData = listOf(

    DespesaMensal(
        month = "Março",
        total = "R$ 2.850,00",
        variation = "▲ 5%",
        chartValues = listOf(80f, 150f, 120f, 200f, 180f, 220f),
        chartLabels = listOf("01", "07", "14", "21", "28", "31"),
        categories = listOf(
            ItemDeCategoria("Compras", "R$ 1.000,00", 0.35f, Icons.Default.ShoppingCart, AzulMedio),
            ItemDeCategoria("Transporte", "R$ 500,00", 0.18f, Icons.Default.DirectionsBus, Color(0xFF4CAF50)),
            ItemDeCategoria("Alimentação", "R$ 600,00", 0.21f, Icons.Default.Restaurant, Color(0xFFFF9800)
            )
        )
    ),

    DespesaMensal(
        month = "Abril",
        total = "R$ 2.900,00",
        variation = "▲ 2%",
        chartValues = listOf(100f, 180f, 140f, 250f, 200f, 260f),
        chartLabels = listOf("01", "07", "14", "21", "28", "31"),
        categories = listOf(
            ItemDeCategoria("Compras", "R$ 1.200,00", 0.40f, Icons.Default.ShoppingCart, AzulMedio),
            ItemDeCategoria("Transporte", "R$ 550,00", 0.19f, Icons.Default.DirectionsBus, Color(0xFF4CAF50)),
            ItemDeCategoria("Alimentação", "R$ 620,00", 0.22f, Icons.Default.Restaurant, Color(0xFFFF9800))
        )
    ),

    DespesaMensal(
        month = "Maio",
        total = "R$ 3.250,80",
        variation = "▼ 12%",
        chartValues = listOf(100f, 200f, 150f, 300f, 250f, 290f),
        chartLabels = listOf("01", "07", "14", "21", "28", "31"),
        categories = listOf(
            ItemDeCategoria("Compras", "R$ 1.460,90", 0.44f, Icons.Default.ShoppingCart, AzulMedio),
            ItemDeCategoria("Transporte", "R$ 680,50", 0.21f, Icons.Default.DirectionsBus, Color(0xFF4CAF50)),
            ItemDeCategoria("Alimentação", "R$ 640,20", 0.18f, Icons.Default.Restaurant, Color(0xFFFF9800))
        )
    )
)