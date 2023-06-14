package com.example.composeplayground

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DaytimeTable() {
    val yourList =
        listOf(
            "a", "b", "c","a", "b", "c","a", "b", "c","a", "b", "c","a", "b", "c","a", "b", "c","a", "b", "c",
        )
    Column(modifier = Modifier
        .padding(start = 12.dp ,end = 12.dp)
        .fillMaxWidth()
        .clip(RoundedCornerShape(12.dp))
        .background(Color(253, 164, 104, 255))
    )
    {
        LazyRow()
        {
            items(yourList.chunked(2)){ chunkedItems ->

                Column() {

                    for (item in chunkedItems){
                        AddedActivity()
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewDaytimeTable() {
    DaytimeTable()
}