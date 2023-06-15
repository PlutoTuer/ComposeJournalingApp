package com.example.composeplayground

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Objects

@Composable
fun checkForDaytime(text:String):Boolean {
    var isChecked by remember {
        mutableStateOf(false)
    }
    Box(
        modifier = Modifier
            .wrapContentHeight()
            .wrapContentWidth()
            .shadow(
                elevation = 20.dp,
                shape = RoundedCornerShape(8.dp),
            )
            .background(
                Color(255, 255, 255, 255)
            )
            .padding(2.dp)
    ) {
        // card content
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = text,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                ),
                modifier = Modifier.padding(start = 10.dp)
            )
            Checkbox(
                checked = isChecked,
                onCheckedChange = {
                    isChecked = it
                } )
        }
    }
    println("FROM CheckForDaytime.kt; " +
            "IS FIELD CHECKED: $isChecked")
    return isChecked
}
var row1 = Row(0)
var row2 = Row(1)
var row3 = Row(2)
@Composable
fun FullCheckForDaytimeRow() {
    var firstRowChecked by remember {
        mutableStateOf(false)
    }
    var secondRowChecked by remember {
        mutableStateOf(false)
    }
    var thirdRowChecked by remember {
        mutableStateOf(false)
    }
    row1.isChecked = firstRowChecked
    row2.isChecked = secondRowChecked
    row3.isChecked = thirdRowChecked

    Row() {
        println("###################")

        Spacer(modifier = Modifier.weight(0.1F))
        firstRowChecked = checkForDaytime("Morning")

        Spacer(modifier = Modifier.weight(0.1F))
        secondRowChecked = checkForDaytime("Mid-Day"
        )
        Spacer(modifier = Modifier.weight(0.1F))
        thirdRowChecked = checkForDaytime("Evening")

        Spacer(modifier = Modifier.weight(0.1F))

    }

    println("###################")
    println("Rows:")
    println("Row 1: " + row1.toString())
    println("Row 2: " + row2.toString())
    println("Row 3: " + row3.toString())

}

@Preview
@Composable
fun PreviewCheckForDaytime() {
    checkForDaytime("Morning")
}