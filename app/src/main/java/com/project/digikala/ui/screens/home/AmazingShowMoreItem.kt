package com.project.digikala.ui.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.project.digikala.ui.theme.roundedShape
import com.project.digikala.ui.theme.spacing
import com.project.digikala.R
import com.project.digikala.ui.theme.DigikalaLightRed
import com.project.digikala.ui.theme.darkText


@Composable
fun AmazingShowMoreItem() {
    Card(
        modifier = Modifier
            .size(180.dp, 365.dp)
            .padding(
                end = MaterialTheme.spacing.medium,
                start = MaterialTheme.spacing.semiSmall,
                top = MaterialTheme.spacing.semiLarge
            ),
        shape = MaterialTheme.roundedShape.small,
        contentColor = Color.White
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {

            Icon(
                painter = painterResource(id = R.drawable.show_more),
                contentDescription = "",
                tint = MaterialTheme.colors.DigikalaLightRed,
                modifier = Modifier.size(40.dp, 40.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = stringResource(id = R.string.see_all),
                style = androidx.compose.material3.MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colors.darkText,
            )


        }


    }
}
