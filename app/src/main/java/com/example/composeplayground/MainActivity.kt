package com.example.composeplayground

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.expandVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.PopupProperties
import com.example.composeplayground.ui.theme.ComposePlaygroundTheme

//Journal App
var completedDay = CompletedDay()
class MainActivity : ComponentActivity() {
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
                        val isButtonPressed: () -> Unit = {

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
                        val onRemove: (String, List<String>) -> Unit = {text, list ->
                            when (list) {
                                itemsListMorning -> {
                                    itemsListMorning = itemsListMorning - text
                                }
                                itemsListMidDay -> {
                                    itemsListMidDay = itemsListMidDay - text
                                }
                                itemsListEvening -> {
                                    itemsListEvening = itemsListEvening - text
                                }
                            }
                        }
                        Box{
                            FullTitleCard()
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
                                    date = "01-06-23",
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


