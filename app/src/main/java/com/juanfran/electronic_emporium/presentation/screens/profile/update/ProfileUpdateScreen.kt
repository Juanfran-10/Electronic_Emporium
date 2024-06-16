package com.juanfran.electronic_emporium.presentation.screens.profile.update

import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.juanfran.electronic_emporium.presentation.components.DefaultTopBar
import com.juanfran.electronic_emporium.presentation.screens.profile.info.components.ProfileContent
import com.juanfran.electronic_emporium.presentation.screens.profile.update.components.ProfileUpdateContent
import com.juanfran.electronic_emporium.presentation.screens.profile.update.components.UpdateUser

@Composable
fun ProfileUpdateScreen(navController: NavHostController, userParam: String) {
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Actualizar perfil",
                navController = navController,
                upAvailable = true
            )
        }
    ) { paddingValues ->
        ProfileUpdateContent(paddingValues = paddingValues)
    }
    UpdateUser()
}