package com.juanfran.electronic_emporium.presentation.navigation.screen.client

sealed class ClientProductScreen(val route: String) {
    object ProductDetail : ClientProductScreen("client/products/detail/{product}") {
        fun passProduct(product: String) = "client/products/detail/$product"
    }
}

