package com.project.digikala.ui.screens

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.project.digikala.MainActivity
import com.project.digikala.util.Constants.ENGLISH_LANG
import com.project.digikala.util.Constants.PERSIAN_LANG
import com.project.digikala.viewmodel.DataStoreViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun ProfileScreen(navController: NavHostController,
                  daraStore: DataStoreViewModel = hiltViewModel()){

    val activity = LocalContext.current as Activity


    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text(text = "ProfileScreen")
        Button(onClick = {
            daraStore.saveUserLanguage(PERSIAN_LANG)
            activity.apply {
                finish()
                startActivity(Intent(activity, MainActivity::class.java))
            }

        }) {
            Text(text = "fa")
        }
        Button(onClick = {
            daraStore.saveUserLanguage(ENGLISH_LANG)
            activity.apply {
                finish()
                startActivity(Intent(activity, MainActivity::class.java))
            }
        }) {
            Text(text = "en")
        }
    }

}