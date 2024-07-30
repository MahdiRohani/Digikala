package com.project.digikala.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.project.digikala.ui.theme.DarkCyan
import com.project.digikala.ui.theme.darkText
import com.project.digikala.ui.theme.extraBoldNumber
import com.project.digikala.ui.theme.spacing


@Composable
fun ProductHorizontalCard(
    name: String,
    id: String,
    imageUrl: String
) {
    Row(
        modifier = Modifier
            .width(320.dp)
            .padding(bottom = MaterialTheme.spacing.extraSmall),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painter = rememberAsyncImagePainter(imageUrl),
            contentDescription = "",
            modifier = Modifier
                .weight(.3f)
                .fillMaxHeight()
        )

        Text(
            text = id,
            style = androidx.compose.material3.MaterialTheme.typography.extraBoldNumber,
            fontWeight = FontWeight.Black,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colors.DarkCyan,
            modifier = Modifier
                .weight(.15f)
                .padding(horizontal = MaterialTheme.spacing.small, vertical = MaterialTheme.spacing.biggerSmall)
        )

        Column(
            modifier = Modifier
                .weight(.55f)
                .fillMaxHeight()
                .padding(vertical = MaterialTheme.spacing.small),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = name,
                style = androidx.compose.material3.MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colors.darkText,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(top = MaterialTheme.spacing.small)
            )
        }

    }
}
