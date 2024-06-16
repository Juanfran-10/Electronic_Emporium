package com.juanfran.electronic_emporium.presentation.screens.client.payments.form.mapper

import com.juanfran.electronic_emporium.domain.model.CardTokenBody
import com.juanfran.electronic_emporium.domain.model.Cardholder
import com.juanfran.electronic_emporium.domain.model.Identification
import com.juanfran.electronic_emporium.presentation.screens.client.payments.form.ClientPaymentsFormState

fun ClientPaymentsFormState.toCardTokenBody(): CardTokenBody {
    return CardTokenBody(
        cardNumber = cardNumber,
        expirationMonth = expirationMonth.toInt(),
        expirationYear = expirationYear,
        securityCode = securityCode,
        cardholder = Cardholder(
            name = name,
            identification = Identification(
                type = type,
                number = number
            )
        )
    )
}