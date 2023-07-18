package com.example.composeplayground.mainscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.composeplayground.addscreen.Row

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchDateInput() {
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
        Row(
            //test
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = "17",
                onValueChange = {},
                label = { Text("DD") },
                maxLines = 2,
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent
                ),
                modifier = Modifier
                    .width(85.dp)
                    .height(50.dp)

            )
        }
    }
}