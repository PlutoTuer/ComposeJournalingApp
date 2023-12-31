package com.example.composeplayground.addscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
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
fun DaytimeTable(itemsList:List<String>, onRemove: (String, List<String>)->Unit) {

    //println("###################")
    //println("List of items to be added to the rows:")
    //println("$itemsList")
    //println("###################")

    Column(modifier = Modifier
        .padding(start = 12.dp, end = 12.dp)
        .fillMaxWidth()
        .requiredHeight(75.dp)
        .fillMaxHeight()
        .clip(RoundedCornerShape(12.dp))
        .background(Color(102, 80, 163, 141))
    )
    {
        LazyRow {

            items(itemsList.chunked(2)){ chunkedItems ->

                Column() {

                    for (item in chunkedItems){

                        val onClickIcon: (String)->Unit = {text ->
                            if (text in itemsList){
                                onRemove(item, itemsList)
                            }
                        }
                        AddedActivity(item,onClickIcon)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewDaytimeTable() {
    //DaytimeTable(listOf("a"),{})
}