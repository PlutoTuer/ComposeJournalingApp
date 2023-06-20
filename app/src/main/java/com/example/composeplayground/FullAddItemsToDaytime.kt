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
fun FullAddItemsToDaytime(isButtonPressed: () -> Unit, userInput:String, onValueChange: (String) -> Unit) {

    Box(modifier = Modifier.padding(top = 10.dp)){

        BoxWithShadow(160, 166,200,200,255)

        Column {

            Row {

                AddItemsTextField(onValueChange)

                println("FROM FullAddItemsToDaytime.kt; " +
                        "USER INPUT: $userInput")

                Box(modifier = Modifier.align(Alignment.CenterVertically)){

                    AddActivityButton(isButtonPressed)

                }
                //if (isButtonPressed){textValue = ""}
            }
            FullCheckForDaytimeRow()

        }
    }
}

@Preview
@Composable
fun PreviewFullAddItemsToDaytime() {
    FullAddItemsToDaytime({}, "test",{})
}