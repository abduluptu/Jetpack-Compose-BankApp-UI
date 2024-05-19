package com.soha.infotech.jetpack_compose_bankapp_ui.data

import androidx.compose.ui.graphics.Brush

/**
 * Step5: create a data class Card
 */

data class Card(
    val cardType: String,
    val cardNumber: String,
    val cardName: String,
    val balance: Double,
    val color: Brush
)