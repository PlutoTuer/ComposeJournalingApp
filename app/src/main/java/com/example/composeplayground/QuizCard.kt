package com.example.composeplayground

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RadioButton() {
    var isButtonClicked by remember { mutableStateOf(false) }
    androidx.compose.material3.RadioButton(
        selected = isButtonClicked,
        onClick = { isButtonClicked = !isButtonClicked })
}

@Preview
@Composable
fun PreviewRadioButton() {
    RadioButton()
}


@Composable
fun QuizCard() {
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(80.dp)
        .padding(16.dp)
        .shadow(
            elevation = 10.dp

        ),
        shape = RoundedCornerShape(8.dp)
    ){
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 10.dp),
            contentAlignment = Alignment.CenterStart
        ){
            Text(
                text = "\uD83D\uDE42",
                modifier = Modifier
                    .scale(1.5f)
            )
            Text(
                text = "Neutral",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp
                ),
                modifier = Modifier.padding(start = 30.dp))
        }
    }
}
//Neutral face: 😐
//Happy face: 🙂
//Sad face: 🙁
@Preview
@Composable
fun PreviewQuizCard() {
    QuizCard()
}


@Composable
fun QuizSheet() {
    Box {
        QuizCard()
        Box(modifier = Modifier
            .align(Alignment.CenterEnd)
            .padding(end = 10.dp)
        ){
            RadioButton()
        }
    }
}

@Preview
@Composable
fun PreviewQuizSheet() {
    QuizSheet()
}

@Preview
@Composable
fun FullQuiz() {
    Box(/*modifier = Modifier.padding(bottom = 20.dp)*/){//TODO Vielleicht noch das padding ändern
        BoxWithShadow(250,192,247,172,255)
        Column() {
            QuizSheet()
            QuizSheet()
            QuizSheet()
        }
    }
}