package com.soha.infotech.jetpack_compose_bankapp_ui.views.sections

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.soha.infotech.jetpack_compose_bankapp_ui.R
import com.soha.infotech.jetpack_compose_bankapp_ui.data.Card
import com.soha.infotech.jetpack_compose_bankapp_ui.ui.theme.BlueEnd
import com.soha.infotech.jetpack_compose_bankapp_ui.ui.theme.BlueStart
import com.soha.infotech.jetpack_compose_bankapp_ui.ui.theme.GreenEnd
import com.soha.infotech.jetpack_compose_bankapp_ui.ui.theme.GreenStart
import com.soha.infotech.jetpack_compose_bankapp_ui.ui.theme.OrangeEnd
import com.soha.infotech.jetpack_compose_bankapp_ui.ui.theme.OrangeStart
import com.soha.infotech.jetpack_compose_bankapp_ui.ui.theme.PurpleEnd
import com.soha.infotech.jetpack_compose_bankapp_ui.ui.theme.PurpleStart

/**
 * Step5.1: create a CardSection file
 */

private val cardLIst = listOf(
    Card(
        cardType = "VISA",
        cardNumber = "3664 7865 3786 3976",
        cardName = "Business",
        balance = 46.467,
        color = getGradient(PurpleStart, PurpleEnd)
    ),
    Card(
        cardType = "MASTER CARD",
        cardNumber = "4110 1245 4569 1267",
        cardName = "Savings",
        balance = 230.00,
        color = getGradient(BlueStart, BlueEnd),
    ),
    Card(
        cardType = "VISA",
        cardNumber = "1234 5678 0989 6762",
        cardName = "Trips",
        balance = 4.200,
        color = getGradient(OrangeStart, OrangeEnd),
    ),
    Card(
        cardType = "MASTER CARD",
        cardNumber = "9000 9888 7777 6665",
        cardName = "Investments",
        balance = 706.467,
        color = getGradient(GreenStart, GreenEnd),
    )
)

fun getGradient(colorStart: Color, colorEnd: Color): Brush {
    return Brush.horizontalGradient(
        colors = listOf(colorStart, colorEnd)
    )
}

@Preview
@Composable
fun CardSection() {
    LazyRow {
        items(cardLIst.size) { index ->
            CardItem(index)
        }
    }
}

@Composable
fun CardItem(index: Int) {
    val card = cardLIst[index]
    var lastPaddingItem = 0.dp

    if (index == cardLIst.size - 1) {
        lastPaddingItem = 16.dp
    }

    var image = painterResource(id = R.drawable.ic_visa)
    if (card.cardType == "MASTER CARD") {
        image = painterResource(id = R.drawable.ic_mastercard)
    }

    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = lastPaddingItem)
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(card.color)
                .width(250.dp)
                .height(150.dp)
                .clickable { }
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = image,
                contentDescription = card.cardName,
                modifier = Modifier.width(60.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = card.cardName,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Text(
                text = "R$ ${card.balance}",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Text(
                text = card.cardNumber,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}