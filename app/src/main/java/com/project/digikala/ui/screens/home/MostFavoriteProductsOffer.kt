package com.project.digikala.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.project.digikala.R
import com.project.digikala.data.model.home.StoreProduct
import com.project.digikala.ui.theme.DarkCyan
import com.project.digikala.ui.theme.DigikalaDarkRed
import com.project.digikala.ui.theme.darkText
import com.project.digikala.ui.theme.extraBoldNumber
import com.project.digikala.ui.theme.semiDarkText
import com.project.digikala.ui.theme.spacing
import com.project.digikala.util.Constants
import com.project.digikala.util.DigitHelper


@Composable
fun MostFavoriteProductsOffer(item : StoreProduct) {

    Column(
        modifier = Modifier
            .width(170.dp)
            .padding(
                vertical = MaterialTheme.spacing.semiLarge,
                horizontal = MaterialTheme.spacing.semiSmall
            ),
    ) {

        Row {

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(vertical = MaterialTheme.spacing.small)
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = MaterialTheme.spacing.extraSmall)
                ) {


                    Image(
                        painter = rememberAsyncImagePainter(item.image),
                        contentDescription = "",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(130.dp),
                        contentScale = ContentScale.FillBounds
                    )

                }

                Spacer(modifier = Modifier.height(10.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = MaterialTheme.spacing.small)
                ) {

                    Text(
                        text = item.name,
                        modifier = Modifier
                            .fillMaxSize()
                            .height(48.dp)
                            .padding(horizontal = MaterialTheme.spacing.small),
                        style = androidx.compose.material3.MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colors.darkText,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(
                            painter = painterResource(id = R.drawable.in_stock),
                            contentDescription = "",
                            modifier = Modifier
                                .size(22.dp)
                                .padding(2.dp),
                            tint = MaterialTheme.colors.DarkCyan
                        )
                        Text(
                            text = item.seller,
                            style = androidx.compose.material3.MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colors.semiDarkText,
                        )

                    }

                    Spacer(modifier = Modifier.height(10.dp))


                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = MaterialTheme.spacing.small),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.Top
                    ) {

                        Box(
                            modifier = Modifier
                                .width(40.dp)
                                .height(24.dp)
                                .background(
                                    color = MaterialTheme.colors.DigikalaDarkRed,
                                    shape = CircleShape
                                )
                                .wrapContentWidth(Alignment.CenterHorizontally)
                                .wrapContentHeight(Alignment.CenterVertically)
                        ) {
                            Text(
                                text = "${DigitHelper.digitByLocateAndSeparator(item.discountPercent.toString())}%",
                                color = Color.White,
                                style = androidx.compose.material3.MaterialTheme.typography.labelMedium,
                                fontWeight = FontWeight.Bold,
                            )
                        }


                        Column {

                            Row {
                                Text(
                                    text = DigitHelper.digitByLocateAndSeparator(
                                        DigitHelper.applyDiscount(item.price , item.discountPercent)
                                            .toString()),
                                    style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
                                    fontWeight = FontWeight.SemiBold,
                                )

                                Icon(
                                    painter = currencyChangeByLanguage(),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .size(MaterialTheme.spacing.semiLarge)
                                        .padding(horizontal = MaterialTheme.spacing.extraSmall)
                                )

                            }

                            Text(
                                text = DigitHelper.digitByLocateAndSeparator(item.price.toString()),
                                color = Color.LightGray,
                                style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
                                textDecoration = TextDecoration.LineThrough
                            )
                        }

                    }


                }


            }


            Divider(
                Modifier
                    .padding(start = MaterialTheme.spacing.semiMedium)
                    .width(1.dp)
                    .height(320.dp)
                    .alpha(0.4f),
                color = Color.LightGray
            )
        }




    }


}

@Composable
private fun currencyChangeByLanguage(): Painter {
    return if (Constants.USER_LANGUAGE == Constants.ENGLISH_LANG) {
        painterResource(id = R.drawable.dollar)
    } else {
        painterResource(id = R.drawable.toman)
    }
}

