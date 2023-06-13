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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CheckForDaytime() {
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
                text = "Mid-Day",//TODO: ersetzen mit variable (morning, mid-day & evening)
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                ),
                modifier = Modifier.padding(start = 10.dp)
            )
            Checkbox(checked = false, onCheckedChange = {} )
        }
    }
}

@Composable
fun FullCheckForDaytimeRow() {
    Row() {
        Spacer(modifier = Modifier.weight(0.1F))
        CheckForDaytime()
        Spacer(modifier = Modifier.weight(0.1F))
        CheckForDaytime()
        Spacer(modifier = Modifier.weight(0.1F))
        CheckForDaytime()
        Spacer(modifier = Modifier.weight(0.1F))
    }
}

@Preview
@Composable
fun PreviewCheckForDaytime() {
    CheckForDaytime()
}