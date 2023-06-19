package com.example.composeplayground

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
@Composable
fun AddActivityButton(onClick: () -> Unit){
    Button(
        onClick = onClick,
        modifier = Modifier.padding(4.dp)
    )
    {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = "Add Icon"
        )
    }
}
@Preview
@Composable
fun PreviewAddActitvityButton() {
    AddActivityButton({})
}
