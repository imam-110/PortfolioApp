package com.example.portfolioapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.portfolioapp.data.model.*

class MainViewModel : ViewModel() {

    val profile = Profile(
        name = "Mohd. Imam",
        email = "zaidiimam3@gmail.com",
        location = "Ghaziabad, India",
        profilePictureUrl = "https://drive.google.com/uc?export=view&id=1UbjjAi4Xcal0vOf9aPzqU8jEmSTULeAn\n", // use your GitHub/dp URL
        objective = "A passionate Android Developer with a knack for building elegant and functional apps using Kotlin and Jetpack Compose."
    )

    val educationList = listOf(
        Education("B.Tech in CSE", "Dr. APJ Abdul Kalam Technical University, Lucknow", "2022 - 2026"),
        Education("12th Grade", "SD Public School, Muzaffarnagar", "2020 - 2021"),
        Education("10th Grade", "SD Public School,Muzaffarnagar","2018 - 2019" )


    )

    val skills = listOf(
        Skill("Kotlin"),
        Skill("Jetpack Compose"),
        Skill("MVVM Architecture"),
        Skill("Hilt / Dagger"),
        Skill("Retrofit"),
        Skill("Firebase"),
        Skill("Room DB"),
        Skill("Git & GitHub")
    )

    val projects = listOf(
        Project(
        title = "QuickBlogs",
        description = "A read-only blog app that fetches and caches blog content using Retrofit and Room.",
        technologies = listOf("Kotlin", "Jetpack Compose", "Room", "MVVM")
    ),
        Project(
            title = "Mera College",
            description = "An all-in-one college management system with separate Admin and User sides, built with Kotlin and Jetpack Compose.",
            technologies = listOf("Kotlin", "Jetpack Compose", "Firebase", "MVVM")
        ),
        Project(
            title = "The Power Play",
            description = "A smart AI-based system for predicting electricity peak loads using ML, presented as part of a 4-member team project.",
            technologies = listOf("Jetpack Compose", "Python", "ML", "FastAPI", "Team Project")
        )
    )

    val certifications = listOf(
        Certification("Android Development Bootcamp", "Udemy", "2024"),
        Certification("Git & GitHub Essentials", "Coursera", "2023")
    )

    val hobbies = listOf(
        Hobby("Cycling 🚴"),
        Hobby("Playing Cricket"),
        Hobby("Playing Multiplayer Video Games"),
        Hobby("Reading Islamic Books 📚")
    )
}
