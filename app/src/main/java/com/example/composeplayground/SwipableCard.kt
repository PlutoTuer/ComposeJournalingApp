package com.example.composeplayground

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BoxWithShadow(height:Int, red:Int, green:Int, blue:Int, alpha:Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(height.dp)
            .shadow(
                elevation = 20.dp,
                shape = RoundedCornerShape(8.dp),
            )
            .background(Color(red, green, blue, alpha)),

        ) {
        // card content
    }
}


@Preview
@Composable
fun PreviewSwipeableCard() {
    BoxWithShadow(250, 233,233,223,255)
}