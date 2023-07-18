package com.example.composeplayground.addscreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
fun RadioButton(
    moodOptions: MoodOptions,
    selected: String,
    setSelected: (selected: String) -> Unit
) {
    androidx.compose.material3.RadioButton(
        selected = selected == moodOptions.mood,
        onClick = {
                  setSelected(moodOptions.mood)
        },
        enabled = true
    )
}

@Preview
@Composable
fun PreviewRadioButton() {
    RadioButton(MoodOptions.NEUTRAL, "",{})
}


@Composable
fun QuizCard(
    moodOptions: MoodOptions
) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(80.dp)
        .padding(12.dp)
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
                text = moodOptions.emoji,
                modifier = Modifier
                    .scale(1.5f)
            )
            Text(
                text = moodOptions.mood,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
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
    QuizCard(MoodOptions.HAPPY)
}


@Composable
fun QuizSheet(
    MoodOptions: MoodOptions,
    selected: String,
    setSelected: (selected: String) -> Unit
) {

    Box {
        QuizCard(MoodOptions)
        Box(modifier = Modifier
            .align(Alignment.CenterEnd)
            .padding(end = 10.dp)
        ){
            RadioButton(MoodOptions,selected, setSelected)
        }
    }
}

@Preview
@Composable
fun PreviewQuizSheet() {
    QuizSheet(MoodOptions.HAPPY,"", {})
}


@Composable
fun FullQuiz(
    selected: String,
    setSelected: (selected: String) -> Unit
) {
    Box(/*modifier = Modifier.padding(bottom = 20.dp)*/){//TODO Vielleicht noch das padding ändern
        //BoxWithShadow(250,192,247,172,255)
        Column() {
            MoodOptions.values().forEach { mood ->
                QuizSheet(mood,selected, setSelected)
            }
        }
    }
}


@Preview
@Composable
fun PreviewFullQuiz() {
    FullQuiz(selected = "MoodOptions.HAPPY", setSelected = {})
}