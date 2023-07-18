package com.example.composeplayground.addscreen

import androidx.compose.foundation.layout.Row
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddItemsTextField(onValueChange: (String) -> Unit) {
    var userInput by remember {
        mutableStateOf("")
    }
    Row() {
        TextField(
            label = { Text("Input activities") },
            value = userInput,
            onValueChange = { newValue ->
                userInput = newValue
                onValueChange.invoke(newValue)
            },
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
    AddItemsTextField({"test"})
}

