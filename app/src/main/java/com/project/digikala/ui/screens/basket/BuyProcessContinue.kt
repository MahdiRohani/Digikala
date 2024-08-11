package com.project.digikala.ui.screens.basket

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.project.digikala.R
import com.project.digikala.ui.theme.digikalaRed
import com.project.digikala.ui.theme.elevation
import com.project.digikala.ui.theme.roundedShape
import com.project.digikala.ui.theme.semiDarkText
import com.project.digikala.ui.theme.spacing
import com.project.digikala.util.DigitHelper


@Composable
fun BuyProcessContinue(
    price: Long
) {
    Card(
        shape = MaterialTheme.roundedShape.extraSmall,
        elevation = MaterialTheme.elevation.extraSmall,
        border = BorderStroke(width = 1.dp, color = Color.LightGray.copy(0.2f))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = MaterialTheme.spacing.medium,
                    vertical = MaterialTheme.spacing.semiMedium,
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.digikalaRed),
                shape = MaterialTheme.roundedShape.small
            ) {
                Text(
                    text = stringResource(R.string.purchase_process),
                    color = Color.White,
                    style = androidx.compose.material3.MaterialTheme.typography.labelMedium,
                    modifier = Modifier
                        .padding(
                            horizontal = MaterialTheme.spacing.biggerMedium,
                            vertical = MaterialTheme.spacing.extraSmall,
                        )
                )
            }


            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.goods_total_price),
                    color = MaterialTheme.colors.semiDarkText,
                    style = androidx.compose.material3.MaterialTheme.typography.labelMedium,
                )

                Row() {
                    Text(
                        text = DigitHelper.digitByLocateAndSeparator(price.toString()),
                        style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.SemiBold
                    )

                    Image(
                        painter = painterResource(id = R.drawable.toman),
                        contentDescription = "",
                        modifier = Modifier
                            .size(MaterialTheme.spacing.semiLarge)
                            .padding(horizontal = MaterialTheme.spacing.extraSmall)
                    )
                }

            }
        }
    }
}
