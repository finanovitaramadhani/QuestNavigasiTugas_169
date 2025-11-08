package com.example.navigasitugas.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.navigasitugas.Navigasi
import com.example.navigasitugas.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListPesertaScreen(navController: NavController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = { Text(stringResource(id = R.string.list_daftarpeserta)) })
        },
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = { navController.navigate(Navigasi.Splash.name) { popUpTo(Navigasi.Splash.name) { inclusive = true } } },
                    modifier = Modifier.weight(1f).padding(end = 8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary)
                ) { Text(stringResource(id = R.string.beranda)) }

                Button(
                    onClick = { navController.navigate(Navigasi.FormPendaftaran.name) },
                    modifier = Modifier.weight(1f).padding(start = 8.dp)
                ) { Text(stringResource(id = R.string.formulir)) }
            }
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp, vertical = 16.dp)
        ) {

            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = stringResource(id = R.string.nama_lengkap),
                            fontWeight = FontWeight.Bold
                        )
                        Text("Putra Ramadhan")
                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = stringResource(id = R.string.status_perkawinan),
                            fontWeight = FontWeight.Bold
                        )
                        Text("Kawin")
                    }

                    Column(modifier = Modifier.weight(1f).padding(start = 8.dp)) {
                        Text(
                            text = stringResource(id = R.string.jenis_kelamin),
                            fontWeight = FontWeight.Bold
                        )
                        Text("Laki-laki")

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = stringResource(id = R.string.alamat),
                            fontWeight = FontWeight.Bold
                        )
                        Text("Sleman")
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = stringResource(id = R.string.nama_lengkap),
                            fontWeight = FontWeight.Bold
                        )
                        Text("Fina Novita")
                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = stringResource(id = R.string.status_perkawinan),
                            fontWeight = FontWeight.Bold
                        )
                        Text("Lajang")
                    }

                    Column(modifier = Modifier.weight(1f).padding(start = 8.dp)) {
                        Text(
                            text = stringResource(id = R.string.jenis_kelamin),
                            fontWeight = FontWeight.Bold
                        )
                        Text("Perempuan")
                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = stringResource(id = R.string.alamat),
                            fontWeight = FontWeight.Bold
                        )
                        Text("Bantul")
                    }
                }
            }
        }
    }
}