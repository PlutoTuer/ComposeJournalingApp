package com.example.composeplayground.evaluatingalgorithm

import com.example.composeplayground.addscreen.CompletedDay
import com.example.composeplayground.completedDays
import java.util.Objects
import kotlin.random.Random

var finalMood:String = ""
val finalActivitiesList: MutableSet<String> = mutableSetOf()

fun evaluationAlgorithm() {
    //var completedDay = CompletedDay()
    //val completedDays = mutableListOf<CompletedDay>()
    initData(completedDays)
    /*
    Criteria:
    High value moods: Happy, Sad

    Get days with positive or sad moods from the past 30days
    Compare number of high value moods:
        1.if the same high value moods follow on three consecutive days or more -> Use data
        2.if in the past 30 days there have been more than or equal to 9 of a high value mood -> Use data
        3.if both high value moods have the same amount occurrences -> Random data gets chosen

     Daytime's: morning, midday, evening
     Selected data objects:
        1.Go over the daytime items and compare for duplicate data
        2.Go over the daytime items and check for items that share the same four chars to check for alternating spelling in items
        3.Get the item with the most duplicates

     -->Print out corresponding mood with corresponding activity
     */
    val positiveObjects: MutableMap<Int, CompletedDay> = mutableMapOf()
    val negativeObjects: MutableMap<Int, CompletedDay> = mutableMapOf()

    completedDays.forEachIndexed{ index, obj ->
        when (obj.mood){
            "happy" -> positiveObjects[index] = obj
            "sad" -> negativeObjects[index] = obj
        }
    }

    fun evaluateMoods(objList: MutableMap<Int, CompletedDay>): MutableList<CompletedDay> {
        var prevObjKeyIndex: Int = 0
        var consecutiveMoods: Int = 0
        val tempConsecutiveMoodsList:MutableList<CompletedDay> = mutableListOf()
        val consecutiveMoodsList:MutableList<CompletedDay> = mutableListOf()
        objList.forEach { obj ->
            val objKeyIndex: Int = obj.key

            if (objKeyIndex == 0 || objKeyIndex == (prevObjKeyIndex + 1)) {
                consecutiveMoods += 1
                prevObjKeyIndex = objKeyIndex
                tempConsecutiveMoodsList.add(obj.value)
                if (consecutiveMoods in 3..5) {
                    consecutiveMoodsList.addAll(tempConsecutiveMoodsList)
                    tempConsecutiveMoodsList.clear()
                }
            } else {
                consecutiveMoods = 0
                tempConsecutiveMoodsList.clear()
            }
        }
        return consecutiveMoodsList
    }

    var evaluatedMoodsList:MutableList<CompletedDay>

    if(positiveObjects.size > negativeObjects.size){
        println("Evaluating positive Objects")
        finalMood = "happy"
        evaluatedMoodsList = evaluateMoods(positiveObjects)
        if (evaluatedMoodsList.isEmpty()) evaluatedMoodsList = positiveObjects.values.toMutableList()

    }
    else if(positiveObjects.size < negativeObjects.size){
        finalMood = "sad"
        println("Evaluating negative Objects")
        evaluatedMoodsList = evaluateMoods(negativeObjects)
        if (evaluatedMoodsList.isEmpty()) evaluatedMoodsList = negativeObjects.values.toMutableList()

    }
    else{
        println("Evaluating a random Map")
        val randMap: MutableMap<Int, CompletedDay> = (listOf(positiveObjects, negativeObjects)).random()
        evaluatedMoodsList = evaluateMoods(randMap)
        if (evaluatedMoodsList.isEmpty()) evaluatedMoodsList = randMap.values.toMutableList()
        finalMood = evaluatedMoodsList[1].mood.toString()
    }
    println(evaluatedMoodsList)

    var activitiesList: MutableList<String> = mutableListOf()
    evaluatedMoodsList.forEach { obj ->
        activitiesList = (obj.morning?.plus(activitiesList))?.toMutableList()!!
        activitiesList = (obj.midDay?.plus(activitiesList))?.toMutableList()!!
        activitiesList = (obj.evening?.plus(activitiesList))?.toMutableList()!!
    }
    //println(activitiesList.sorted())
    activitiesList.forEachIndexed { index, activity ->
        activitiesList[index] = activity.lowercase().trim()
    }
    println(activitiesList)
    fun findDuplicates(list:MutableList<String>): MutableList<String> {
        val uniqueElements = mutableSetOf<String>()
        val duplicateElements = mutableListOf<String>()

        for (activity in list) {
            if (!uniqueElements.add(activity)) {
                duplicateElements.add(activity)
            }
        }
        return duplicateElements
    }
    val duplicateActivitiesList: MutableList<String> = findDuplicates(activitiesList)
    println(duplicateActivitiesList)

    duplicateActivitiesList.forEach { activity ->
        finalActivitiesList.add(activity)
    }
    println(finalActivitiesList)
    println(finalMood)
    //TODO: Compare variations of tags. E.g work to working
    //println(positiveObjects)
    //println(negativeObjects)
}

