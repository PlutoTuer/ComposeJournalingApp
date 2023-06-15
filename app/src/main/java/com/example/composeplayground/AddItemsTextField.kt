package com.example.composeplayground

import android.widget.NumberPicker.OnValueChangeListener
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun addItemsTextField():String {
    var userInput by remember {
        mutableStateOf("")
    }
    var tempInput:String by remember {
        mutableStateOf("")
    }
    Row() {
        TextField(
            label = { Text("Input activities") },
            value = userInput,
            onValueChange ={inputText ->
                userInput = inputText
            },
            modifier = Modifier
                .padding(16.dp)
                .width(280.dp)
                //.fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
        )
    }
    println("FROM AddItemsTextField.kt; " +
            "USER INPUT: $userInput")
    return userInput
}

@Preview
@Composable
fun PreviewAddItemsTextField() {
    addItemsTextField()
}

