package com.project.digikala.ui.screens.basket

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.project.digikala.ui.theme.spacing
import com.project.digikala.R
import com.project.digikala.ui.theme.semiDarkText

@Composable
fun EmptyBasketShopping() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = MaterialTheme.spacing.small),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            painter = painterResource(id = R.drawable.empty_cart),
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.height(200.dp)
        )

        Text(
            text = stringResource(R.string.cart_is_empty),
            fontWeight = FontWeight.Bold,
            style = androidx.compose.material3.MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colors.semiDarkText,
        )
        Spacer(
            modifier = Modifier.height(MaterialTheme.spacing.medium)
        )

    }
}
