package com.example.composeplayground

data class CompletedDay(
    val date: String? = null,
    val morning: List<String>? = null,
    val midDay: List<String>? = null,
    val evening: List<String>? = null,
    val mood: String? = null
)
