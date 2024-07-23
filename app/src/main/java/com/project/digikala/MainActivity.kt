package com.project.digikala

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.LayoutDirection
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.project.digikala.navigation.BottomNavigationBar
import com.project.digikala.navigation.SetupNavGraph
import com.project.digikala.ui.components.AppConfig
import com.project.digikala.ui.theme.DigikalaTheme
import com.project.digikala.util.Constants
import com.project.digikala.util.Constants.ENGLISH_LANG
import com.project.digikala.util.Constants.PERSIAN_LANG
import com.project.digikala.util.Constants.USER_LANGUAGE
import com.project.digikala.util.LocaleUtils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DigikalaTheme {
                navController = rememberNavController()
                AppConfig()


                LocaleUtils.setLocale(LocalContext.current, USER_LANGUAGE)
                val direction = if (USER_LANGUAGE == ENGLISH_LANG){
                    androidx.compose.ui.unit.LayoutDirection.Ltr
                }else{
                    androidx.compose.ui.unit.LayoutDirection.Rtl
                }

                CompositionLocalProvider(LocalLayoutDirection provides direction) {
                    Scaffold(
                        bottomBar = {
                            BottomNavigationBar(navController = navController, onItemClick ={
                                navController.navigate(it.route)
                            })
                        }
                    ) {
                        SetupNavGraph(navController = navController)
                    }
                }



            }
        }
    }
}


