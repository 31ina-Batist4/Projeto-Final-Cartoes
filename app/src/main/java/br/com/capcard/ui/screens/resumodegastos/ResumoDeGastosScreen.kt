package br.com.capcard.ui.screens.resumodegastos

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.capcard.preview.previewData
import br.com.capcard.ui.components.ItemDeCategoria
import br.com.capcard.ui.components.Grafico
import br.com.capcard.ui.theme.AzulEscuro
import br.com.capcard.ui.theme.AzulMedio
import br.com.capcard.ui.theme.Branco
import br.com.capcard.ui.theme.Gelo
import br.com.capcard.ui.theme.Texto

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ResumoDeGastosScreen(navController: NavController) {

    var currentIndex by remember { mutableStateOf(2) }
    var direction by remember { mutableStateOf(1) }
    var expanded by remember { mutableStateOf(false) }

    val currentData = previewData[currentIndex]

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Gelo)
            .pointerInput(Unit) {
                detectHorizontalDragGestures { _, dragAmount ->
                    if (dragAmount > 50 && currentIndex > 0) {
                        direction = -1
                        currentIndex--
                    } else if (dragAmount < -50 && currentIndex < previewData.lastIndex) {
                        direction = 1
                        currentIndex++
                    }
                }
            }
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.ArrowBack, contentDescription = null)
                Spacer(Modifier.weight(1f))
                Text(
                    "Resumo de gastos",
                    fontWeight = FontWeight.Bold,
                    color = AzulEscuro
                )
                Spacer(Modifier.weight(1f))
            }

            Spacer(Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Branco, RoundedCornerShape(20.dp))
                    .padding(vertical = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                IconButton(
                    onClick = {
                        if (currentIndex > 0) {
                            direction = -1
                            currentIndex--
                        }
                    },
                    enabled = currentIndex > 0
                ) {
                    Icon(Icons.Default.ChevronLeft, null)
                }

                Text(
                    currentData.month,
                    color = AzulEscuro,
                    fontWeight = FontWeight.SemiBold
                )

                IconButton(
                    onClick = {
                        if (currentIndex < previewData.lastIndex) {
                            direction = 1
                            currentIndex++
                        }
                    },
                    enabled = currentIndex < previewData.lastIndex
                ) {
                    Icon(Icons.Default.ChevronRight, null)
                }
            }

            Spacer(Modifier.height(20.dp))

            AnimatedContent(
                targetState = currentData,
                transitionSpec = {
                    slideInHorizontally { it * direction } + fadeIn() togetherWith
                            slideOutHorizontally { -it * direction } + fadeOut()
                },
                label = "content_animation"
            ) { data ->

                Column {

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text("Total gasto", color = Texto)
                            Text(
                                data.total,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = AzulEscuro
                            )
                        }

                        Text(
                            data.variation,
                            color = if (data.variation.contains("▼"))
                                Color(0xFF2ECC71)
                            else
                                Color.Red
                        )
                    }

                    Spacer(Modifier.height(16.dp))

                    Grafico(data.chartValues)

                    Spacer(Modifier.height(8.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        data.chartLabels.forEach {
                            Text(it, color = Texto, fontSize = 12.sp)
                        }
                    }

                    Spacer(Modifier.height(20.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            "Categorias",
                            color = AzulEscuro,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            "Ver todas",
                            color = AzulMedio,
                            modifier = Modifier.clickable {
                                expanded = true
                            }
                        )
                    }

                    Spacer(Modifier.height(12.dp))

                    data.categories.forEach {
                        ItemDeCategoria(it)
                        Spacer(Modifier.height(12.dp))
                    }
                }
            }
        }

        if (expanded) {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.4f))
                    .clickable { expanded = false }
            )

            AnimatedVisibility(
                visible = expanded,
                enter = slideInVertically(initialOffsetY = { it }) + fadeIn(),
                exit = slideOutVertically(targetOffsetY = { it }) + fadeOut(),
                modifier = Modifier.align(Alignment.BottomCenter)
            ) {

                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
                    color = Branco
                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    ) {

                        Text(
                            "Categorias",
                            fontWeight = FontWeight.Bold,
                            color = AzulEscuro
                        )

                        Spacer(Modifier.height(16.dp))

                        LazyColumn {
                            items(currentData.categories) {
                                ItemDeCategoria(it)
                                Spacer(Modifier.height(12.dp))
                            }
                        }

                        Text(
                            "Fechar",
                            color = AzulMedio,
                            modifier = Modifier
                                .clickable { expanded = false }
                                .fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}