package br.com.capcard.ui.theme


import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import br.com.capcard.R

data class Icon (
    val icon: ImageVector,
    val contentDescription: String,
    val tint: Color? = null
)/*
object Icons {
    val Voltar = Icon(
        R.drawable.voltar,
        "Voltar"
    )

    val Adicionar = Icon(
        R.drawable.adicionar,
        "Adicionar"
    )
}*/