package com.juanfran.electronic_emporium.presentation.screens.admin.category.update.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.juanfran.electronic_emporium.domain.util.Resource
import com.juanfran.electronic_emporium.presentation.components.ProgressBar
import com.juanfran.electronic_emporium.presentation.screens.admin.category.create.AdminCategoryCreateViewModel
import com.juanfran.electronic_emporium.presentation.screens.admin.category.list.AdminCategoryListViewModel
import com.juanfran.electronic_emporium.presentation.screens.admin.category.list.components.AdminCategoryListContent
import com.juanfran.electronic_emporium.presentation.screens.admin.category.update.AdminCategoryUpdateViewModel

@Composable
fun UpdateCategory(
    vm: AdminCategoryUpdateViewModel = hiltViewModel(),
    vmList: AdminCategoryListViewModel = hiltViewModel()
) {
    when (val response = vm.categoryResponse) {
        Resource.Loading -> {
            ProgressBar()
        }

        is Resource.Success -> {
            LaunchedEffect(Unit) {
                vmList.getCategories()
            }
            Toast.makeText(
                LocalContext.current,
                "Los datos se han actualizado correctamente",
                Toast.LENGTH_LONG
            ).show()
        }

        is Resource.Failure -> {
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_LONG).show()
        }

        else -> {
            if (response != null) {
                Toast.makeText(LocalContext.current, "Hubo error desconocido", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }
}