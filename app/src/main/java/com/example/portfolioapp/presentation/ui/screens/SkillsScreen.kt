package com.example.portfolioapp.presentation.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.portfolioapp.data.model.Skill
import com.example.portfolioapp.presentation.viewmodel.MainViewModel

@Composable
fun SkillsScreen(viewModel: MainViewModel) {
    val skills = viewModel.skills

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text(
            text = "Technical Skills 💻",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(skills) { skill ->
                SkillCard(skill)
            }
        }
    }
}

@Composable
fun SkillCard(skill: Skill) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Text(
            text = "⭐ ${skill.skillName}",
            fontSize = 16.sp,
            modifier = Modifier.padding(16.dp)
        )
    }
}
