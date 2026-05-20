package br.com.capcard.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import br.com.capcard.ui.theme.AzulEscuro


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolbarComponent(
    onBack: () -> Unit,
    onAdd: () -> Unit,
    back: Boolean,
    add: Boolean,
    title: String
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                color = AzulEscuro
            )
        },
        navigationIcon = {
          if(back) {
              IconButton(onClick = onBack) {
                  Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Voltar", tint = AzulEscuro)
              }
          }
        },
        actions = {
            if(add) {
                IconButton(onClick = onAdd) {
                    Icon(Icons.Default.Add, contentDescription = "Adicionar", tint = AzulEscuro
                    )
                }
            }
        }
    )
}