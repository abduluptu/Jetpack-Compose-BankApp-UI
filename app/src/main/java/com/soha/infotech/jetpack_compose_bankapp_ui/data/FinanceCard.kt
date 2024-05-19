package com.soha.infotech.jetpack_compose_bankapp_ui.data

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Step6: create a data class FinanceCard
 */

data class FinanceCard(
    val image: ImageVector,
    val name: String,
    val background: Color
)
