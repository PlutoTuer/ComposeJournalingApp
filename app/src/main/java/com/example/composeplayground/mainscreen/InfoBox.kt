package com.example.composeplayground.mainscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeplayground.evaluatingalgorithm.finalActivitiesList
import com.example.composeplayground.evaluatingalgorithm.finalMood

@Composable
fun InfoBox() {
    Column(modifier = Modifier
        .padding(start = 12.dp, end = 12.dp)
        .fillMaxWidth()
        .requiredHeight(150.dp)
        .fillMaxHeight()
        .clip(RoundedCornerShape(12.dp))
        .background(Color(102, 80, 163, 141))
    ){
        Row() {
    
            Box() {
                Icon(
                    Icons.Filled.Info,
                    contentDescription = "Info Icon",
                    modifier = Modifier.padding(start = 10.dp, top = 10.dp)
                )

            }

        }
        Text(
            text = "It seems like you often feel $finalMood\n" +
                    "when you do the following activities:\n" +
                    "${finalActivitiesList.toList().getOrElse(0) {""}}, " +
                    "${finalActivitiesList.toList().getOrElse(1) {""}}, " +
                    "${finalActivitiesList.toList().getOrElse(2) {""}} \n",
            style = TextStyle(
                fontSize = 22.sp,
                //fontWeight = FontWeight.ExtraBold,
            ),
            modifier = Modifier.padding(start = 12.dp, top = 10.dp)
        )

    }
}