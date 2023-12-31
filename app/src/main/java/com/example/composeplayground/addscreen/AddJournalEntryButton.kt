package com.example.composeplayground.addscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AddJournalEntryButton(onComplete: () -> Unit, text: String) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .border(width = 1.dp, color = Color.Black)
            .background(color = Color(102, 80, 163, 255)),
        colors = ButtonDefaults.buttonColors(Color(102, 80, 163, 255)),
        onClick = { onComplete() }
    ) {
        Text(text = text)
    }
}

@Preview
@Composable
fun PreviewAddJournalEntryButton() {
    AddJournalEntryButton({}, "")
}