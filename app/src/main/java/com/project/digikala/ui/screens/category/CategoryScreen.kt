package com.project.digikala.ui.screens.category

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.project.digikala.ui.screens.home.AmazingOfferSection
import com.project.digikala.ui.screens.home.BestSellerOfferSection
import com.project.digikala.ui.screens.home.CategoryListSection
import com.project.digikala.ui.screens.home.CenterBannerSection
import com.project.digikala.ui.screens.home.MostDiscountedSection
import com.project.digikala.ui.screens.home.MostFavoriteProductSection
import com.project.digikala.ui.screens.home.MostVisitedOfferSection
import com.project.digikala.ui.screens.home.ProposalCardSection
import com.project.digikala.ui.screens.home.SearchBarSection
import com.project.digikala.ui.screens.home.ShowcaseSection
import com.project.digikala.ui.screens.home.SuperMarketOfferSection
import com.project.digikala.util.Constants
import com.project.digikala.util.LocaleUtils
import com.project.digikala.viewmodel.CategoryViewModel
import com.project.digikala.viewmodel.HomeViewModel
import kotlinx.coroutines.launch

@Composable
fun CategoryScreen(navController: NavHostController) {
    Category(navController = navController)

}

@Composable
fun Category(
    navController: NavHostController,
    viewModel: CategoryViewModel = hiltViewModel()
) {

    LaunchedEffect(true) {
        refreshDataFromServer(viewModel)
    }

    SwipeRefreshSection(viewModel = viewModel, navController = navController)

}


@Composable
fun SwipeRefreshSection(viewModel: CategoryViewModel, navController: NavHostController) {
    val refreshScope = rememberCoroutineScope()
    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = false)
    SwipeRefresh(state = swipeRefreshState,
        onRefresh = {
            refreshScope.launch {
                refreshDataFromServer(viewModel)
            }
        }) {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 60.dp)
        ) {
            item { SearchBarSection() }
            item { SubCategorySection() }


        }


    }
}

private suspend fun refreshDataFromServer(viewModel: CategoryViewModel) {
    viewModel.getAllDataFromServer()
}