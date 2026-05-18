package br.com.capcard.ui.screens

import android.webkit.WebView
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    val svg = gerarCartaoSvg("Elina Silva")

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier.weight(1f)) {
            AndroidView(factory = {
                WebView(it).apply {
                    loadData(svg, "image/svg+xml", "UTF-8")
                }
            })
        }
    }
}

fun gerarCartaoSvg(nome: String): String {
    return """
        <svg width="300" height="180" xmlns="http://www.w3.org/2000/svg">
            <rect width="100%" height="100%" fill="#4CAF50" rx="16"/>
            <text 
                x="50%" 
                y="50%" 
                dominant-baseline="middle" 
                text-anchor="middle" 
                font-size="20" 
                fill="white"
                font-family="Arial">
                $nome
            </text>
        </svg>
    """.trimIndent()
}
