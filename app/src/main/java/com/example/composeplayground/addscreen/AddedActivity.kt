package com.example.composeplayground.addscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AddedActivity(text:String,onClickIcon: (String)->Unit) {
    Box(
        modifier = Modifier
            .padding(4.dp)
            .wrapContentWidth()
            .wrapContentHeight()
            .clip(shape = RoundedCornerShape(28.dp))
            .background(Color.White)
            .shadow(
                elevation = 12.dp
            )
    ){
        Row (
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Text(
                text = text,
                modifier = Modifier.padding(start = 10.dp),
                fontSize = 22.sp
            )
            IconButton(
                onClick = {onClickIcon(text)},
                modifier = Modifier.size(24.dp)

            ) {
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = "Cross Icon"
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewAddedActivity() {
    AddedActivity("work",{})
}