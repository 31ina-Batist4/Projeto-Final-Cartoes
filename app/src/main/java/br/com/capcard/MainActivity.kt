package br.com.capcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import br.com.capcard.ui.navigation.NavGraph
import br.com.capcard.ui.theme.CapCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CapCardTheme {
                val navController = rememberNavController()
                NavGraph(navController)                }
            }
        }
    }

