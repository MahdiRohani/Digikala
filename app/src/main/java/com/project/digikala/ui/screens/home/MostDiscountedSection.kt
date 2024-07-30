package com.project.digikala.ui.screens.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.project.digikala.R
import com.project.digikala.data.model.home.StoreProduct
import com.project.digikala.data.remote.NetworkResult
import com.project.digikala.ui.theme.DigikalaBG
import com.project.digikala.ui.theme.darkText
import com.project.digikala.ui.theme.spacing
import com.project.digikala.viewmodel.HomeViewModel


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MostDiscountedSection(
    viewModel: HomeViewModel = hiltViewModel()
) {
    var mostDiscountedList by remember {
        mutableStateOf<List<StoreProduct>>(emptyList())
    }
    var loading by remember {
        mutableStateOf(false)
    }

    val mostDiscountedListResult by viewModel.mostDiscountedItems.collectAsState()
    when (mostDiscountedListResult) {
        is NetworkResult.Success -> {
            mostDiscountedList = mostDiscountedListResult.data ?: emptyList()
            loading = false
        }
        is NetworkResult.Error -> {
            loading = false
            Log.e("3636", "MostDiscountedSection error : ${mostDiscountedListResult.message}")
        }
        is NetworkResult.Loading -> {
            loading = true
        }
    }


    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {


        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(MaterialTheme.spacing.semiSmall),
            text = stringResource(id = R.string.most_discounted_products),
            textAlign = TextAlign.Right,
            style = androidx.compose.material3.MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colors.darkText,
        )

        FlowRow(
            maxItemsInEachRow = 2,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.Center
        ) {

            for (item in mostDiscountedList) {
                MostDiscountedCard(item)
            }

        }

    }

}
