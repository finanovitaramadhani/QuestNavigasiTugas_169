package com.example.navigasitugas.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.example.navigasitugas.Navigasi
import com.example.navigasitugas.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormPendaftaranScreen(navController: NavController) {

    var namaLengkap by remember { mutableStateOf("") }
    val jenisKelaminOptions = listOf(stringResource(id = R.string.laki_laki), stringResource(id = R.string.perempuan))
    var jenisKelamin by remember { mutableStateOf(jenisKelaminOptions[0]) }
    val statusKawinOptions = listOf(stringResource(id = R.string.janda), stringResource(id = R.string.lajang), stringResource(id = R.string.duda))
    var statusKawin by remember { mutableStateOf(statusKawinOptions[1]) }
    var alamat by remember { mutableStateOf("") }


    var showSuccessDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = { Text(stringResource(id = R.string.formulir_pendaftaran)) }) // Diperbarui
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Card(
                modifier = Modifier.fillMaxWidth().weight(1f),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {

                    Text(stringResource(id = R.string.nama_lengkap), fontWeight = FontWeight.Bold) // Diperbarui
                    OutlinedTextField(
                        value = namaLengkap,
                        onValueChange = { namaLengkap = it },
                        label = { Text(stringResource(id = R.string.isi_nama_lengkap)) }, // Diperbarui
                        modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
                    )

                    Text(stringResource(id = R.string.jenis_kelamin), fontWeight = FontWeight.Bold) // Diperbarui
                    Row(Modifier.fillMaxWidth().selectableGroup()) {
                        jenisKelaminOptions.forEach { text ->
                            Row(
                                Modifier
                                    .selectable(selected = (text == jenisKelamin), onClick = { jenisKelamin = text }, role = Role.RadioButton)
                                    .padding(end = 16.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                RadioButton(selected = (text == jenisKelamin), onClick = null)
                                Text(text, modifier = Modifier.padding(start = 8.dp))
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))

                    Text(stringResource(id = R.string.status_perkawinan), fontWeight = FontWeight.Bold) // Diperbarui
                    Row(Modifier.fillMaxWidth().selectableGroup()) {
                        statusKawinOptions.forEach { text ->
                            Row(
                                Modifier
                                    .selectable(selected = (text == statusKawin), onClick = { statusKawin = text }, role = Role.RadioButton)
                                    .padding(end = 16.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                RadioButton(selected = (text == statusKawin), onClick = null)
                                Text(text, modifier = Modifier.padding(start = 8.dp))
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))


                    Text(stringResource(id = R.string.alamat), fontWeight = FontWeight.Bold) // Diperbarui
                    OutlinedTextField(
                        value = alamat,
                        onValueChange = { alamat = it },
                        label = { Text(stringResource(id = R.string.isi_alamat)) }, // Diperbarui
                        modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
                    )
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = {
                        navController.navigate(Navigasi.ListPeserta.name) {
                            popUpTo(Navigasi.ListPeserta.name) { inclusive = true }
                        }
                    },
                    modifier = Modifier.weight(1f).padding(end = 8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary)
                ) {
                    Text(stringResource(id = R.string.beranda)) // Diperbarui
                }
                Button(
                    onClick = {
                        if (namaLengkap.isNotBlank() && alamat.isNotBlank()) {
                            showSuccessDialog = true
                        }
                    },
                    modifier = Modifier.weight(1f).padding(start = 8.dp)
                ) {
                    Text(stringResource(id = R.string.submit))
                }
            }
        }
    }

