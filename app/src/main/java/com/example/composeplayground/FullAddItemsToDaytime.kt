package com.example.composeplayground

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

val item = FullItem()
@Composable
fun FullAddItemsToDaytime() {
    var userInput by remember {
        mutableStateOf("")
    }
    var isButtonPressed by remember {
        mutableStateOf(false)
    }
    Box(modifier = Modifier.padding(top = 10.dp)){

        BoxWithShadow(160, 166,200,200,255)

        Column {

            Row {

                userInput = addItemsTextField()

                println("FROM FullAddItemsToDaytime.kt; " +
                        "USER INPUT: $userInput")

                Box(modifier = Modifier.align(Alignment.CenterVertically)){

                    isButtonPressed = addActivityButton()

                    LaunchedEffect(isButtonPressed) {
                        println("FROM FullAddItemsToDaytime.kt; IS THE BUTTON PRESSED: $isButtonPressed")
                    }
                }
                //if (isButtonPressed){textValue = ""}
            }
            FullCheckForDaytimeRow()

            val rowList = listOf<Row>(row1, row2, row3)
            val hasChecked = rowList.any { rowIndex -> rowIndex.isChecked }

            val filteredRows = rowList.filter { it.isChecked }
            val daytimeRowList = mutableListOf<Int>()

            for (obj in filteredRows){
                daytimeRowList.add(obj.daytime)
            }
            if (isButtonPressed && hasChecked){
                item.daytimeRowList = daytimeRowList
                item.text = userInput
            }
            println("Objects to be added:")
            println(item.toString())
        }
    }
}

@Preview
@Composable
fun PreviewFullAddItemsToDaytime() {
    FullAddItemsToDaytime()
}