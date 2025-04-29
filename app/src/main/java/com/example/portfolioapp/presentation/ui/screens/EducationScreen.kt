package com.example.portfolioapp.presentation.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.portfolioapp.data.model.Education
import com.example.portfolioapp.presentation.viewmodel.MainViewModel

@Composable
fun EducationScreen(viewModel: MainViewModel) {
    val educationList = viewModel.educationList

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text(
            text = "Education 🎓",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(educationList) { education ->
                EducationCard(education)
            }
        }
    }
}

@Composable
fun EducationCard(education: Education) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = education.degree, fontSize = 16.sp, fontWeight = MaterialTheme.typography.titleMedium.fontWeight)
            Text(text = education.university, fontSize = 14.sp, color = MaterialTheme.colorScheme.primary)
            Text(text = education.year, fontSize = 13.sp, color = MaterialTheme.colorScheme.secondary)
        }
    }
}

