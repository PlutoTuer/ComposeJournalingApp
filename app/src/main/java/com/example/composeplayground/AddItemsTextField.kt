package com.example.composeplayground

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddItemsTextField() {
    Row() {
        TextField(
            label = { Text("Input activities") },
            value = "",
            onValueChange ={},
            modifier = Modifier
                .padding(16.dp)
                .width(280.dp)
                //.fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
        )
    }

}

@Preview
@Composable
fun PreviewAddItemsTextField() {
    AddItemsTextField()
}

