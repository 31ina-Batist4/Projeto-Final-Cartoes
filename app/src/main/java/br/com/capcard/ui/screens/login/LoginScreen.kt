package br.com.capcard.ui.screens.login

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
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.capcard.R
import br.com.capcard.ui.navigation.Routes
import br.com.capcard.ui.theme.AzulEscuro
import br.com.capcard.ui.theme.AzulMedio
import br.com.capcard.ui.theme.AzulSuave
import br.com.capcard.ui.theme.Branco
import br.com.capcard.ui.theme.BrancoG
import br.com.capcard.ui.theme.Gelo
import br.com.capcard.ui.theme.Texto

@Composable
fun LoginScreen(
    navController: NavController
) {

    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    val titulo = buildAnnotatedString {
        append("Bem-vindo de volta, ")

        pushStringAnnotation(
            tag = "TITULO",
            annotation = "titulo"
        )

        withStyle(
            style = SpanStyle(color = AzulMedio) ) {
            append("MARIA")
        }
        pop()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .background(BrancoG)
    ) {
        Image(
            painter = painterResource(id = R.drawable.cartao_login),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 180.dp)
                .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                .background(Branco)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logomarca_login),
                contentDescription = null,
                modifier = Modifier
                    .height(80.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = titulo,
                style = MaterialTheme.typography.titleLarge,
                color = AzulEscuro
            )

            Text(
                text = "Acesse sua conta e gerencie seus cartões com praticidade e segurança.",
                style = MaterialTheme.typography.labelSmall,
                color = Texto,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 8.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("E-mail",color = Texto) },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                ),
                leadingIcon = {
                    Icon(Icons.Default.Email, contentDescription = null, tint = AzulMedio)
                },
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Texto,
                    unfocusedBorderColor = MaterialTheme.colorScheme.surfaceVariant,
                    focusedLabelColor = Texto,
                    unfocusedLabelColor = Texto,
                    cursorColor = Texto
                ),
                shape = RoundedCornerShape(12.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = senha,
                onValueChange = { senha = it },
                label = { Text("Senha", color = Texto)},
                leadingIcon = {
                    Icon(Icons.Default.Lock, contentDescription = null, tint = AzulMedio)
                },
                trailingIcon = {
                    Icon(Icons.Default.Visibility, contentDescription = null, tint = Texto)
                },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Texto,
                    unfocusedBorderColor = MaterialTheme.colorScheme.surfaceVariant,
                    focusedLabelColor = Texto,
                    unfocusedLabelColor = Texto,
                    cursorColor = Texto
                ),
                shape = RoundedCornerShape(12.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = "Esqueceu sua senha?",
                    style = MaterialTheme.typography.labelSmall,
                    color = AzulMedio
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {navController.navigate(Routes.DASHBOARD)},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = AzulMedio,
                    contentColor = Branco
                )
            ) {
                Text("Entrar", style = MaterialTheme.typography.bodyMedium, color = Branco)
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                HorizontalDivider(modifier = Modifier.weight(1f))
                Text(" ou continue com ", style = MaterialTheme.typography.labelSmall, color = Texto)
                HorizontalDivider(modifier = Modifier.weight(1f))
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                SocialButton("Google", R.drawable.ic_google)
                SocialButton("Apple", R.drawable.ic_apple)
            }

            Spacer(modifier = Modifier.height(20.dp))

            val texto = buildAnnotatedString {
                append("Ainda não tem uma conta? ")

                pushStringAnnotation(
                    tag = "CADASTRO",
                    annotation = "cadastro"
                )
                withStyle(
                    style = SpanStyle(color = AzulMedio) ) {
                        append("Cadastre-se")
                    }
                   pop()
            }
            Text(
                text = texto,
                style = MaterialTheme.typography.labelSmall,
                color = Texto
            )
        }
    }
}


@Composable
fun SocialButton(
    text: String,
    iconRes: Int
) {
    OutlinedButton(
        onClick = {},
        modifier = Modifier
            .height(50.dp)
            .width(140.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = text,
                modifier = Modifier
                    .size(20.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(text)
        }
    }
}
