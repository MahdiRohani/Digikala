package com.project.digikala.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.project.digikala.R
import com.project.digikala.ui.theme.selectedBottomBar
import com.project.digikala.ui.theme.unSelectedBottomBar

@Composable
fun BottomNavigationBar(
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit
) {
    val items = listOf(
        BottomNavItem(
            name = "Home",
            route = Screen.Home.route,
            selectedIcon = painterResource(id = R.drawable.digi_logo),
            deSelectedIcon = painterResource(id = R.drawable.digi_logo)
        ),
        BottomNavItem(
            name = "Category",
            route = Screen.Category.route,
            selectedIcon = painterResource(id = R.drawable.digi_logo),
            deSelectedIcon = painterResource(id = R.drawable.digi_logo)
        ),
        BottomNavItem(
            name = "Basket",
            route = Screen.Basket.route,
            selectedIcon = painterResource(id = R.drawable.digi_logo),
            deSelectedIcon = painterResource(id = R.drawable.digi_logo)
        ),
        BottomNavItem(
            name = "Profile",
            route = Screen.Profile.route,
            selectedIcon = painterResource(id = R.drawable.digi_logo),
            deSelectedIcon = painterResource(id = R.drawable.digi_logo)
        )
    )

    val backStackEntry = navController.currentBackStackEntryAsState()
    val showBottomBar = backStackEntry.value?.destination?.route in items.map { it.route }

    if(showBottomBar){
        BottomNavigation(
            modifier = Modifier,
            backgroundColor = Color.White,
            elevation = 5.dp
        ){
            items.forEachIndexed { index, item ->  
                val selected = item.route == backStackEntry.value?.destination?.route
                BottomNavigationItem(selected = selected, onClick = { onItemClick(item) },
                    selectedContentColor = MaterialTheme.colors.selectedBottomBar,
                    unselectedContentColor = MaterialTheme.colors.unSelectedBottomBar,
                    icon = {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            if (selected){
                                Icon(modifier = Modifier.size(24.dp),
                                    painter = item.selectedIcon,
                                    contentDescription = item.name)
                            }else{
                                Icon(modifier = Modifier.size(24.dp),
                                    painter = item.deSelectedIcon,
                                    contentDescription = item.name)
                            }
                            Text(text = item.name,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(top = 5.dp))

                        }

                    })
            }
        }
    }

}