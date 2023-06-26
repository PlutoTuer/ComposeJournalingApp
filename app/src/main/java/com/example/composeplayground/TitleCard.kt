package com.example.composeplayground

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Title() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 24.dp, top = 12.dp)
    ) {
        Text(
            text = "Thursday June 1st",
            fontSize = 32.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color(102, 80, 163, 255)
        )
        Text(
            text = "2023",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

    }
}

@Composable
fun FullTitleCard() {
    //BoxWithShadow(100, 255,180,180,255)
    Title()
}

@Preview
@Composable
fun PreviewTitle() {
    BoxWithShadow(100, 245,208,208,255)
    Title()
}