package com.project.digikala.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.rememberSwipeableState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.project.digikala.util.Constants
import com.project.digikala.util.LocaleUtils
import com.project.digikala.viewmodel.HomeViewModel
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(navController: NavHostController) {
    Home(navController = navController)

}

@Composable
fun Home(
    navController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    LocaleUtils.setLocale(LocalContext.current, Constants.USER_LANGUAGE)
    LaunchedEffect(true) {
        refreshDataFromServer(viewModel)
    }

    SwipeRefreshSection(viewModel = viewModel, navController = navController)

}

@Composable
private fun SwipeRefreshSection(viewModel: HomeViewModel, navController: NavHostController) {
    val refreshScope = rememberCoroutineScope()
    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = false)
    SwipeRefresh(state = swipeRefreshState,
        onRefresh = {
            refreshScope.launch {
                refreshDataFromServer(viewModel)
            }
        }) {

        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 60.dp)) {
            item { SearchBarSection() }
            item { TopSliderSection() }
            item { ShowcaseSection(navController = navController) }
            item{ AmazingOfferSection()}
            item{ ProposalCardSection()}
            item{ SuperMarketOfferSection()}
            item{ CategoryListSection()}
            item{ CenterBannerSection(bannerNumber = 1)}
            item { BestSellerOfferSection() }
            item{ CenterBannerSection(bannerNumber = 2)}
            item { MostFavoriteProductSection() }
            item{ CenterBannerSection(bannerNumber = 3)}
            item { MostVisitedOfferSection() }
            item{ CenterBannerSection(bannerNumber = 4)}

            item{ CenterBannerSection(bannerNumber = 5)}
            item{ MostDiscountedSection()}

        }



    }
}

private suspend fun refreshDataFromServer(viewModel: HomeViewModel) {
    viewModel.getAllDataFromServer()

}