package com.example.composeplayground

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FullAddItemsToDaytime() {
    Box(modifier = Modifier.padding(top = 10.dp)){
        BoxWithShadow(160, 166,200,200,255)
        Column {
            Row {
                AddItemsTextField()
                Box(modifier = Modifier.align(Alignment.CenterVertically)){
                    AddActivityButton()
                }
            }
            FullCheckForDaytimeRow()
        }
    }
}

@Preview
@Composable
fun PreviewFullAddItemsToDaytime() {
    FullAddItemsToDaytime()
}