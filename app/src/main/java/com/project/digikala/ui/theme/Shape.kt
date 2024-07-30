package com.project.digikala.ui.theme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.dp


data class RoundedShape(
    val extraSmall : RoundedCornerShape = RoundedCornerShape(4.dp),
    val small : RoundedCornerShape = RoundedCornerShape(8.dp),
    val biggerSmall : RoundedCornerShape = RoundedCornerShape(10.dp),
    val medium : RoundedCornerShape = RoundedCornerShape(16.dp),
    val biggerMedium : RoundedCornerShape = RoundedCornerShape(18.dp),
    val large : RoundedCornerShape = RoundedCornerShape(24.dp),
)

val LocalShape = compositionLocalOf { RoundedShape() }

val MaterialTheme.roundedShape: RoundedShape
    @Composable
    @ReadOnlyComposable
    get() = LocalShape.current