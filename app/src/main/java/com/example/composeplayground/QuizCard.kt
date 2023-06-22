package com.example.composeplayground

import android.widget.RadioGroup
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
fun RadioButton(
    selected:Boolean = false,
    enabled:Boolean = true,
    onClick: () -> Unit
) {
    androidx.compose.material3.RadioButton(
        selected = selected,
        onClick = onClick,
        enabled = enabled
    )
}

@Preview
@Composable
fun PreviewRadioButton() {
    RadioButton(selected = true){}
}


@Composable
fun QuizCard(
    emoji:String,
    mood:String
) {
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
                text = emoji,
                modifier = Modifier
                    .scale(1.5f)
            )
            Text(
                text = mood,
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
    QuizCard("\uD83D\uDE10", "neutral")
}


@Composable
fun QuizSheet(
    emoji:String,
    mood:String,
    onClick: () -> Unit,
    selected: Boolean,
    enabled: Boolean
) {

    Box {
        QuizCard(emoji,mood)
        Box(modifier = Modifier
            .align(Alignment.CenterEnd)
            .padding(end = 10.dp)
        ){
            RadioButton{}
        }
    }
}

@Preview
@Composable
fun PreviewQuizSheet() {
    QuizSheet("\uD83D\uDE10", "neutral", {}, false, true)
}


@Composable
fun FullQuiz(
    onClick: () -> Unit,
    selected: Boolean,
    enabled: Boolean
) {
    Box(/*modifier = Modifier.padding(bottom = 20.dp)*/){//TODO Vielleicht noch das padding ändern
        BoxWithShadow(250,192,247,172,255)
        Column() {
            QuizSheet("\uD83D\uDE41", "sad", onClick, selected,enabled)
            QuizSheet("\uD83D\uDE10", "neutral",onClick, selected,enabled)
            QuizSheet("\uD83D\uDE42", "happy",onClick, selected, enabled)
        }
    }
}