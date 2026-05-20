package br.com.capcard.ui.screens.beneficios

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.capcard.ui.components.BottomBarComponent
import br.com.capcard.ui.components.ToolbarComponent
import br.com.capcard.ui.theme.*

@Composable
fun BenefitsScreen(navController: NavController) {
    var showDialog by remember { mutableStateOf(false) }
    var dialogTitle by remember { mutableStateOf("") }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text(text = "Funcionalidade") },
            text = { Text(text = "A funcionalidade para '$dialogTitle' será implementada em breve.") },
            confirmButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text("OK")
                }
            }
        )
    }

    Scaffold(
        topBar = {
            ToolbarComponent(
                onBack = { navController.popBackStack() },
                onAdd = {},
                true,
                false,
                "Benefícios"
            )
        },
        bottomBar = {
            BottomBarComponent(navController)
        },
        containerColor = Gelo
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                MainBenefitCard(onButtonClick = {
                    dialogTitle = "Ver Pontos"
                    showDialog = true
                })
            }

            items(benefitItems) { item ->
                BenefitListItem(
                    item = item,
                    onItemClick = {
                        dialogTitle = item.title
                        showDialog = true
                    }
                )
            }
            
            item {
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Composable
fun MainBenefitCard(onButtonClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xFFE3F2FD), Color(0xFFBBDEFB))
                    )
                )
                .padding(20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(
                            text = "Acumule pontos",
                            style = AppTypography.titleMedium,
                            color = AzulEscuro
                        )
                        Text(
                            text = "A cada compra, você acumula pontos!",
                            style = AppTypography.labelSmall,
                            color = Texto,
                            modifier = Modifier.padding(top = 4.dp, bottom = 15.dp)
                        )
                    }

                    Button(
                        onClick = onButtonClick,
                        colors = ButtonDefaults.buttonColors(containerColor = Branco),
                        shape = RoundedCornerShape(12.dp),
                        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                        elevation = ButtonDefaults.buttonElevation(defaultElevation = 2.dp)
                    ) {
                        Text(
                            text = "Ver pontos",
                            color = AzulMedio,
                            style = AppTypography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .align(Alignment.CenterVertically),
                    contentAlignment = Alignment.Center
                ) {
                    Box(contentAlignment = Alignment.BottomEnd) {
                        Icon(
                            imageVector = Icons.Default.CardGiftcard,
                            contentDescription = "Ícone de presente",
                            modifier = Modifier.size(80.dp),
                            tint = AzulMedio
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun BenefitListItem(item: BenefitItem, onItemClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick() },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Branco),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier.size(48.dp),
                shape = RoundedCornerShape(12.dp),
                color = Gelo
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = null,
                        tint = AzulMedio,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    text = item.title,
                    style = AppTypography.bodyLarge.copy(fontWeight = FontWeight.SemiBold),
                    color = AzulEscuro
                )
                Text(
                    text = item.description,
                    style = AppTypography.labelSmall,
                    color = Texto
                )
            }

            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = null,
                tint = AzulMedio
            )
        }
    }
}

data class BenefitItem(
    val title: String,
    val description: String,
    val icon: ImageVector
)

val benefitItems = listOf(
    BenefitItem("Salas VIP", "Acesse salas VIP em aeroportos", Icons.Default.Star),
    BenefitItem("Seguros", "Proteção para você e sua família", Icons.Default.Lock),
    BenefitItem("Descontos", "Ofertas exclusivas para clientes", Icons.Default.Info),
    BenefitItem("Parceiros", "Confira todos nossos parceiros", Icons.Default.Person)
)

@Preview(showBackground = true)
@Composable
fun BenefitsScreenPreview() {
    CapCardTheme {
        BenefitsScreen(navController = rememberNavController())
    }
}
