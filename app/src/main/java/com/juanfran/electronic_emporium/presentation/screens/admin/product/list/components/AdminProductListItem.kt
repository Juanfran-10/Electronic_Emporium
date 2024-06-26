package com.juanfran.electronic_emporium.presentation.screens.admin.product.list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.juanfran.electronic_emporium.domain.model.Category
import com.juanfran.electronic_emporium.R
import com.juanfran.electronic_emporium.domain.model.Product
import com.juanfran.electronic_emporium.presentation.navigation.Graph
import com.juanfran.electronic_emporium.presentation.navigation.screen.admin.AdminCategoryScreen
import com.juanfran.electronic_emporium.presentation.screens.admin.category.list.AdminCategoryListViewModel
import com.juanfran.electronic_emporium.presentation.screens.admin.product.list.AdminProductListViewModel
import com.juanfran.electronic_emporium.presentation.ui.theme.Gray100
import com.juanfran.electronic_emporium.presentation.ui.theme.Gray200

@Composable
fun AdminProductListItem(
    navController: NavHostController,
    product: Product,
    vm: AdminProductListViewModel = hiltViewModel()
) {
    Column(
        Modifier
            .padding(start = 20.dp, end = 20.dp, top = 15.dp)
            .height(90.dp)
    ) {
        Row() {
            AsyncImage(
                modifier = Modifier
                    .size(70.dp)
                    .clip(RoundedCornerShape(10.dp)),
                model = product.image1,
                contentDescription = ""
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column(
                Modifier.weight(1f)
            ) {
                Text(
                    text = product.name,
                    color = Color.Black,
                    fontSize = 17.sp
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = product.description,
                    color = Color.Gray,
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = product.price.toString() + "€",
                    color = Color.Black,
                    fontSize = 13.sp
                )
            }
            Spacer(Modifier.width(15.dp))
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier
                        .size(27.dp)
                        .clickable {
                            navController.navigate(
                                route = AdminCategoryScreen.ProductUpdate.passProduct(product.toJson())
                            )
                        },
                    painter = painterResource(id = R.drawable.edit),
                    contentDescription = ""
                )
                Spacer(modifier = Modifier.height(5.dp))
                Image(
                    modifier = Modifier
                        .size(27.dp)
                        .clickable { vm.deleteProduct(product.id ?: "") },
                    painter = painterResource(id = R.drawable.trash),
                    contentDescription = ""
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Divider(
            color = Gray100,
            startIndent = 80.dp
        )
    }
}