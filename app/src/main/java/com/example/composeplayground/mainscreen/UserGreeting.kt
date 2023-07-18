package com.example.composeplayground.mainscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UserGreeting(username:String) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 24.dp, top = 12.dp)
    ) {
        val annotatedString = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color(102, 80, 163, 255)
                )
            ){
                append("Welcome back ")
            }
            withStyle(
                style = SpanStyle(
                    color = Color.Black
                )
            ){
                append(username)
            }
            withStyle(
                style = SpanStyle(
                    color = Color(102, 80, 163, 255)
                )
            ){
                append("!")
            }
        }
        Text(
            text = annotatedString,
            fontSize = 32.sp,
            fontWeight = FontWeight.ExtraBold,
        )
    }
}