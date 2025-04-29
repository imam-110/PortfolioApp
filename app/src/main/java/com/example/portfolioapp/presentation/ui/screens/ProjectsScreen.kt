package com.example.portfolioapp.presentation.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.portfolioapp.data.model.Project
import com.example.portfolioapp.presentation.viewmodel.MainViewModel

@Composable
fun ProjectsScreen(viewModel: MainViewModel) {
    val projects = viewModel.projects

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text(
            text = "My Projects 🚀",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(projects) { project ->
                ProjectCard(project)
            }
        }
    }
}

@Composable
fun ProjectCard(project: Project) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = project.title, fontSize = 18.sp, fontWeight = MaterialTheme.typography.titleMedium.fontWeight)
            Spacer(modifier = Modifier.height(6.dp))
            Text(text = project.description, fontSize = 14.sp)
            Spacer(modifier = Modifier.height(6.dp))
            Text(text = "Tech: ${project.technologies.joinToString(", ")}", fontSize = 12.sp, color = MaterialTheme.colorScheme.secondary)
        }
    }
}
