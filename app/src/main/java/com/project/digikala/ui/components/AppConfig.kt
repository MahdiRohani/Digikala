package com.project.digikala.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.project.digikala.util.Constants.USER_LANGUAGE
import com.project.digikala.viewmodel.DataStoreViewModel

@Composable
fun AppConfig(
    dataStore : DataStoreViewModel = hiltViewModel()
){

        getDataStoreVariables(dataStore)


}

private fun getDataStoreVariables(dataStore : DataStoreViewModel){
    USER_LANGUAGE = dataStore.getUserLanguage()
    dataStore.saveUserLanguage(USER_LANGUAGE)
}