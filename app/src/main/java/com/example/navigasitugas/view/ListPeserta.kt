List Peserta

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
