package com.juanfran.electronic_emporium.presentation.screens.admin.product.create.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material.icons.outlined.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.juanfran.electronic_emporium.R
import com.juanfran.electronic_emporium.presentation.components.DefaultButton
import com.juanfran.electronic_emporium.presentation.components.DefaultTextField
import com.juanfran.electronic_emporium.presentation.components.DialogCapturePicture
import com.juanfran.electronic_emporium.presentation.screens.admin.product.create.AdminProductCreateViewModel

@Composable
fun AdminProductCreateContent(
    paddingValues: PaddingValues,
    vm: AdminProductCreateViewModel = hiltViewModel()
) {
    val state = vm.state
    vm.resultingActivityHandler.handle()
    val stateDialog = remember { mutableStateOf(false) }
    val stateDialogImageNumber = remember { mutableStateOf(1) }

    DialogCapturePicture(
        state = stateDialog,
        takePhoto = { vm.takePhoto(stateDialogImageNumber.value) },
        pickImage = { vm.pickImage(stateDialogImageNumber.value) }
    )
    Column(
        modifier = Modifier
            .padding(paddingValues = paddingValues)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(40.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            if (!state.image1.isNullOrBlank()) {
                AsyncImage(
                    modifier = Modifier
                        .size(125.dp)
                        .clip(CircleShape)
                        .clickable {
                            stateDialog.value = true
                            stateDialogImageNumber.value = 1
                        },
                    model = state.image1,
                    contentDescription = ""
                )
            } else {
                Image(
                    modifier = Modifier
                        .size(125.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .clickable {
                            stateDialog.value = true
                            stateDialogImageNumber.value = 1
                        },
                    painter = painterResource(id = R.drawable.image_add),
                    contentDescription = ""
                )
            }

            Spacer(modifier = Modifier.width(15.dp))

            if (!state.image2.isNullOrBlank()) {
                AsyncImage(
                    modifier = Modifier
                        .size(125.dp)
                        .clip(CircleShape)
                        .clickable {
                            stateDialog.value = true
                            stateDialogImageNumber.value = 2
                        },
                    model = state.image2,
                    contentDescription = ""
                )
            } else {
                Image(
                    modifier = Modifier
                        .size(125.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .clickable {
                            stateDialog.value = true
                            stateDialogImageNumber.value = 2
                        },
                    painter = painterResource(id = R.drawable.image_add),
                    contentDescription = ""
                )
            }
        }

        Spacer(modifier = Modifier.height(40.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            shape = RoundedCornerShape(
                topEnd = 40.dp,
                topStart = 40.dp
            ),
            backgroundColor = Color.White
        ) {

            Column(
                modifier = Modifier.padding(30.dp)
            ) {

                Text(
                    text = vm.category.name.uppercase(),
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(12.dp))
                DefaultTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.name,
                    onValueChange = { vm.onNameInput(it) },
                    label = "Nombre del producto",
                    icon = Icons.Default.Info
                )
                Spacer(modifier = Modifier.height(10.dp))
                DefaultTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.description,
                    onValueChange = { vm.onDescriptionInput(it) },
                    label = "Descripción",
                    icon = Icons.Outlined.List
                )
                Spacer(modifier = Modifier.height(10.dp))
                DefaultTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.price.toString(),
                    onValueChange = { vm.onPriceInput(it) },
                    label = "Precio",
                    icon = Icons.Outlined.KeyboardArrowRight,
                    keyboardType = KeyboardType.Number
                )
                Spacer(modifier = Modifier.weight(1f))
                DefaultButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Crear producto",
                    onClick = { vm.createProduct() }
                )
            }
        }
    }
}