package com.example.composeplayground

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.composeplayground.ui.theme.ComposePlaygroundTheme
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Locale

//Journal App
var completedDay = CompletedDay()
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("MutableCollectionMutableState")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePlaygroundTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {


                    Column {
                        var itemsListMorning:List<String> by remember {
                            mutableStateOf(listOf())
                        }
                        var itemsListMidDay:List<String> by remember {
                            mutableStateOf(listOf())
                        }
                        var itemsListEvening:List<String> by remember {
                            mutableStateOf(listOf())
                        }
                        var userInput by remember {
                            mutableStateOf("")
                        }
                        val onValueChange: (String) -> Unit = {input ->
                            userInput = input
                        }
                        val isButtonPressed: () -> Unit = start@{

                            val rowList = listOf<Row>(row1, row2, row3)
                            val hasChecked = rowList.any { rowIndex -> rowIndex.isChecked }

                            val filteredRows = rowList.filter { it.isChecked }
                            val daytimeRowList = mutableListOf<Int>()

                            for (obj in filteredRows){
                                daytimeRowList.add(obj.daytime)
                            }
                            println("###################")
                            println("List of row indices that are checked:")
                            println("$daytimeRowList")
                            println("###################")

                            if (hasChecked){
                                item.daytimeRowList = daytimeRowList
                                item.text = userInput
                                if (daytimeRowList.contains(0)){
                                    itemsListMorning = itemsListMorning + userInput
                                }
                                if (daytimeRowList.contains(1)){
                                    itemsListMidDay = itemsListMidDay + userInput
                                }
                                if (daytimeRowList.contains(2)){
                                    itemsListEvening = itemsListEvening + userInput
                                }


                            }
                            println("Objects to be added:")
                            println(item.toString())
                        }
                        val onRemove: (String, List<String>) -> Unit = onRemove@{ text, list ->
                            when (list) {

                                itemsListMorning -> {
                                    println("Removing $text from $itemsListMorning")
                                    itemsListMorning = itemsListMorning - text
                                    return@onRemove
                                }
                                itemsListMidDay -> {
                                    println("Removing $text from $itemsListMidDay")
                                    itemsListMidDay = itemsListMidDay - text
                                    return@onRemove
                                }

                                itemsListEvening -> {
                                    println("Removing $text from $itemsListEvening")
                                    itemsListEvening = itemsListEvening - text
                                    return@onRemove
                                }
                            }
                        }
                        //val dateTime = Calendar.getInstance().time
                        val currentDateTime: LocalDateTime = LocalDateTime.now()
                        val dayTime = LocalDateTime.parse(currentDateTime.toString(), DateTimeFormatter.ISO_LOCAL_DATE_TIME)

                        //val dayOfWeek = dayTime.format(DateTimeFormatter.ofPattern("EEEE", Locale.getDefault()))
                        //val dayOfMonth = dayTime.format(DateTimeFormatter.ofPattern("dd"))
                        //val month = dayTime.format(DateTimeFormatter.ofPattern("MMMM", Locale.getDefault()))
                        //val year = dayTime.year

                        Box{
                            FullTitleCard(dayTime)
                        }
                        FullAddItemsToDaytime(isButtonPressed, userInput, onValueChange)
                        Spacer(modifier = Modifier.weight(0.1F))


                        DaytimeTable(itemsListMorning, onRemove)
                        //Morning
                        Spacer(modifier = Modifier.weight(0.1F))
                        //Mid-Day
                        DaytimeTable(itemsListMidDay,onRemove)
                        Spacer(modifier = Modifier.weight(0.1F))
                        //Evening
                        DaytimeTable(itemsListEvening, onRemove)
                        Spacer(modifier = Modifier.weight(0.1F))

                        //TODO: alles unter hier
                        val (selected, setSelected) = remember { mutableStateOf("") }

                        FullQuiz(selected,setSelected)
                        println("Selected Option : $selected")

                        val onComplete: () -> Unit = {
                            if (
                                itemsListMorning.isNotEmpty() &&
                                itemsListMidDay.isNotEmpty() &&
                                itemsListEvening.isNotEmpty() &&
                                selected.isNotEmpty()
                            ){
                                println("OnComplete")
                                completedDay = CompletedDay(
                                    date = dayTime.toString(),
                                    morning = itemsListMorning,
                                    midDay = itemsListMidDay,
                                    evening = itemsListEvening,
                                    mood = selected
                                )
                                println(completedDay)
                            }

                        }
                        AddJournalEntryButton(onComplete)
                    }
                }
            }
        }
    }
}

fun checkIfEmpty(vararg items:Any?):Boolean{

    var isEmpty = true

    for (i in items){
        when(i){

            is String -> if (i.isEmpty()) break
            is Int? -> if (i == null) break
            is Double? -> if (i == null) break
            is Boolean? -> if (i == null) break
            is List<*> -> if (i.size == 0) break
            is Map<*, *> -> if (i.isEmpty()) break
            is Set<*> -> if (i.isEmpty()) break
            is Char -> if (i.isWhitespace()) break
            else -> isEmpty = false

        }
    }
    println(isEmpty)
    return isEmpty
}


