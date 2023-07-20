package com.example.composeplayground.evaluatingalgorithm

import com.example.composeplayground.addscreen.CompletedDay

fun initData(completedDays:MutableList<CompletedDay>){
    completedDays.addAll(
        listOf(
            CompletedDay(
                date = "2023-07-16",
                morning = listOf("worK", "breakfast"),
                midDay   = listOf("shopping", "napping"),
                evening = listOf("Shopping"),
                mood = "happy"
            ),
            CompletedDay(
                date = "2023-07-17",
                morning = listOf("working"),
                midDay   = listOf("shopping", "Nap"),
                evening = listOf("Gaming"),
                mood = "happy"
            ),
            CompletedDay(
                date = "2023-07-18",
                morning = listOf("shopping"),
                midDay   = listOf("WoRk"),
                evening = listOf("work"),
                mood = "neutral"
            ),
            CompletedDay(
                date = "2023-07-19",
                morning = listOf("work"),
                midDay   = listOf("work", "playing games"),
                evening = listOf("Swimming", "Dinner"),
                mood = "sad"
            ),
            CompletedDay(
                date = "2023-07-12",
                morning = listOf("working", "  Yoga"),
                midDay   = listOf("worked", "dance"),
                evening = listOf("reading"),
                mood = "neutral"
            ),
            CompletedDay(
                date = "2023-07-13",
                morning = listOf("work", "Yoga"),
                midDay   = listOf("WORK", "CookiNG"),
                evening = listOf("homework"),
                mood = "neutral"
            ),
            CompletedDay(
                date = "2023-07-12",
                morning = listOf("working", "  taxes"),
                midDay   = listOf("worked", "dance"),
                evening = listOf("reading"),
                mood = "neutral"
            ),
            CompletedDay(
                date = "2023-07-13",
                morning = listOf("work", "taxes"),
                midDay   = listOf("WORK", "CookiNG"),
                evening = listOf("homework"),
                mood = "sad"
            )
        )
    )
}