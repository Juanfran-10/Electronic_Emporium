package com.juanfran.electronic_emporium.presentation.screens.client.order.detail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.juanfran.electronic_emporium.domain.model.Order
import com.juanfran.electronic_emporium.presentation.ui.theme.Gray100
import com.juanfran.electronic_emporium.R
import com.juanfran.electronic_emporium.presentation.components.DefaultButton
import com.juanfran.electronic_emporium.presentation.screens.client.order.detail.ClientOrderDetailViewModel

@Composable
fun ClientOrderDetailContent(
    paddingValues: PaddingValues,
    order: Order,
    vm: ClientOrderDetailViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Gray100)
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxWidth()
                .weight(1f)
        ) {
            items(items = order.orderHasProducts ?: listOf()) { orderHasProducts ->
                ClientOrderDetailItem(orderHasProducts = orderHasProducts)
            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            shape = RoundedCornerShape(topEnd = 40.dp, topStart = 40.dp),
            backgroundColor = Color.White
        ) {
            Column(modifier = Modifier.padding(30.dp)) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Fecha del pedido",
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(3.dp))
                        Text(
                            text = order.createdAt ?: "",
                            fontSize = 14.sp
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Image(
                        modifier = Modifier.size(35.dp),
                        painter = painterResource(id = R.drawable.reloj),
                        contentDescription = ""
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Cliente y teléfono",
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(3.dp))
                        Text(
                            text = "${order.client?.name} ${order.client?.lastname} - ${order.client?.phone}",
                            fontSize = 14.sp
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Image(
                        modifier = Modifier.size(35.dp),
                        painter = painterResource(id = R.drawable.user),
                        contentDescription = ""
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Dirección de entrega",
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(3.dp))
                        Text(
                            text = "${order.address?.address} - ${order.address?.neighborhood}",
                            fontSize = 14.sp
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Image(
                        modifier = Modifier.size(35.dp),
                        painter = painterResource(id = R.drawable.map),
                        contentDescription = ""
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "TOTAL: €${vm.totalToPay}",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }
            }
        }
    }
}