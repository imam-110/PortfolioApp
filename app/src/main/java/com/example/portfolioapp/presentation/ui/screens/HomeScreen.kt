package com.example.portfolioapp.presentation.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.portfolioapp.presentation.viewmodel.MainViewModel

@Composable
fun HomeScreen(viewModel: MainViewModel) {
    var selectedTab by remember { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
            BottomNavigationBar(selectedTab) { index ->
                selectedTab = index
            }
        }
    ) { innerPadding ->
        Surface(modifier = Modifier.padding(innerPadding)) {
            when (selectedTab) {
                0 -> ProfileSection(viewModel)
                1 -> SkillsScreen(viewModel)
                2 -> EducationScreen(viewModel)
                3 -> ProjectsScreen(viewModel)
                4 -> CertificationsScreen(viewModel)
            }
        }
    }
}

@Composable
fun BottomNavigationBar(selectedTab: Int, onTabSelected: (Int) -> Unit) {
    NavigationBar {
        val items = listOf("Home", "Skills", "Education", "Projects", "Certs")
        val icons = listOf(
            Icons.Default.Home,
            Icons.Default.Build,
            Icons.Default.Create,
            Icons.Default.AccountBox,
            Icons.Default.Star
        )

        items.forEachIndexed { index, label ->
            NavigationBarItem(
                selected = selectedTab == index,
                onClick = { onTabSelected(index) },
                label = { Text(label) },
                icon = { Icon(icons[index], contentDescription = label) }
            )
        }
    }
}

@Composable
fun ProfileSection(viewModel: MainViewModel) {
    val profile = viewModel.profile

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = rememberAsyncImagePainter(profile.profilePictureUrl),
            contentDescription = "Profile Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.height(16.dp))
        Text(text = profile.name, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text(text = profile.email, fontSize = 14.sp, color = MaterialTheme.colorScheme.primary)
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "📍 ${profile.location}",
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.secondary
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = profile.objective,
            fontSize = 16.sp,
            lineHeight = 22.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(32.dp))

        HighlightSection("Skills", viewModel.skills.joinToString(", ") { it.skillName })
        Spacer(modifier = Modifier.height(16.dp))
        HighlightSection(
            "Education",
            "${viewModel.educationList.first().degree} at ${viewModel.educationList.first().university}"
        )
        Spacer(modifier = Modifier.height(16.dp))
        HighlightSection("Projects", viewModel.projects.joinToString(", ") { it.title })
    }
}

@Composable
fun HighlightSection(title: String, content: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = title, fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = content, fontSize = 14.sp)
        }
    }
}
