package com.example.navigasitugas

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigasitugas.view.FormPendaftaranScreen
import com.example.navigasitugas.view.ListPesertaScreen
import com.example.navigasitugas.view.SplashScreen

enum class Navigasi {
    Splash,
    ListPeserta,
    FormPendaftaran
}

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController()
) {
    Scaffold { isiRuang ->
        NavHost(
            navController = navController,
            startDestination = Navigasi.Splash.name,

            modifier = Modifier.padding(isiRuang)
        ) {

