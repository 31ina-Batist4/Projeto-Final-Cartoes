package br.com.capcard.model

data class CartaoUI(
    val nome: String,
    val numeroCartao: String,
    val limite: String,
    val disponivel: String,
    val bandeira: String
)