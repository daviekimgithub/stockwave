package dev.daviekim.stockwave

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.daviekim.stockwave.common.Route
import dev.daviekim.stockwave.screen.HomeScreen
import dev.daviekim.stockwave.screen.ProgressBarScreen
import dev.daviekim.stockwave.ui.theme.green70
import dev.daviekim.stockwave.viewmodel.StockWaveViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {


    private val stockWaveViewModel by viewModel<StockWaveViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            window.statusBarColor = green70.toArgb()

            LaunchedEffect(key1 = Unit) {
                stockWaveViewModel.onAction(StockWaveViewModel.Action.onFetchStockWave)
            }

            val state = stockWaveViewModel.stockWaveStates

            if (state.isLoading){
                ProgressBarScreen()
            }
            
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                NavHost(
                    navController = navController,
                    startDestination = Route.Home.Home
                ) {
                    composable(Route.Home.Home){
                        HomeScreen(
                            viewModel = stockWaveViewModel,
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}