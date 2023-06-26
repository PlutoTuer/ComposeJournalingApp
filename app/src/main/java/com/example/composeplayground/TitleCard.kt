package com.example.composeplayground

import android.os.Build
import androidx.annotation.RequiresApi
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
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Title(dateTime: LocalDateTime) {
    val dayOfWeek = dateTime.format(DateTimeFormatter.ofPattern("EEEE", Locale.getDefault()))
    val dayOfMonth = dateTime.format(DateTimeFormatter.ofPattern("dd"))
    val month = dateTime.format(DateTimeFormatter.ofPattern("MMMM", Locale.getDefault()))
    val year = dateTime.year
    //println("$dayOfMonth, $dayOfWeek, $month, $year")
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 24.dp, top = 12.dp)
    ) {
        Text(
            text = "$dayOfWeek $month $dayOfMonth" + "st",
            fontSize = 32.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color(102, 80, 163, 255)
        )
        Text(
            text = "$year",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun FullTitleCard(dateTime: LocalDateTime) {
    //BoxWithShadow(100, 255,180,180,255)
    Title(dateTime)
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun PreviewTitle() {
    val dateTime = LocalDateTime.parse("2023-06-26T16:02:34.956", DateTimeFormatter.ISO_LOCAL_DATE_TIME)
    BoxWithShadow(100, 245,208,208,255)
    Title(dateTime)
}