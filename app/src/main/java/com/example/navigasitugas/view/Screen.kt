package com.example.navigasitugas.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.navigasitugas.Navigasi
import com.example.navigasitugas.R

@Composable
fun SplashScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {

        Text(
            text = stringResource(id = R.string.selamat_datang),
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.logo_tennis),
                contentDescription = stringResource(id = R.string.logo_description),
                modifier = Modifier
                    .size(200.dp)
                    .padding(bottom = 32.dp)
            )

            Text(
                text = "Fina Novita Ramadhani",
                fontSize = 18.sp,
                modifier = Modifier.padding(bottom = 4.dp)
            )

            Text(
                text = "20230140169",
                fontSize = 18.sp
            )
        }

        Button(
            onClick = {
                navController.navigate(Navigasi.ListPeserta.name) {
                    popUpTo(Navigasi.Splash.name) { inclusive = true }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        ) {
