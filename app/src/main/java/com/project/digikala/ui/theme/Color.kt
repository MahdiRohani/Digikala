package com.project.digikala.ui.theme



import androidx.compose.material.Colors
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val Purple200 = Color(0xFFed1b34)
val Purple500 = Color(0xFFCE3C4D)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)



val ColorScheme.splashBg: Color
    @Composable
    get() = Color(0xFFed1b34)


val Colors.selectedBottomBar: Color
    @Composable
    get() = if (isLight) Color(0xFF43474C) else Color(0xFFCFD4DA)

val Colors.unSelectedBottomBar: Color
    @Composable
    get() = if (isLight) Color(0xFFA4A1A1) else Color(0xFF575A5E)

val Colors.searchBarBg: Color
    @Composable
    get() = if (isLight) Color(0xFFF1F0EE) else Color(0xFF303235)

val Colors.darkText: Color
    @Composable
    get() = if (isLight) Color(0xFF414244) else Color(0xFFD8D8D8)


val Colors.DigikalaLightRed: Color
    @Composable
    get() = Color(0xffef4056)


val Colors.amber: Color
    @Composable
    get() =  Color(0xffFFBF00)


val Colors.grayCategory: Color
    @Composable
    get() = Color(0xFFF1F0EE)


val Colors.DarkCyan: Color
    @Composable
    get() = Color(0xFF0fabc6)


val Colors.DigikalaDarkRed: Color
    @Composable
    get() = Color(0xFFe6123d)

val Colors.semiDarkText: Color
    @Composable
    get() = if (isLight) Color(0xFF5C5E61) else Color(0xFFD8D8D8)


val Colors.DigikalaLightGreen: Color
    @Composable
    get() = Color(0xff86bf3c)



