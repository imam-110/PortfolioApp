package com.example.portfolioapp.presentation.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.portfolioapp.data.model.Certification
import com.example.portfolioapp.presentation.viewmodel.MainViewModel

@Composable
fun CertificationsScreen(viewModel: MainViewModel) {
    val certifications = viewModel.certifications

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text(
            text = "Certifications 📜",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(certifications) { cert ->
                CertificationCard(cert)
            }
        }
    }
}

@Composable
fun CertificationCard(cert: Certification) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = cert.title, fontSize = 16.sp, fontWeight = MaterialTheme.typography.titleMedium.fontWeight)
            Text(text = cert.authority, fontSize = 14.sp, color = MaterialTheme.colorScheme.primary)
            Text(text = cert.year, fontSize = 12.sp, color = MaterialTheme.colorScheme.secondary)
        }
    }
}
