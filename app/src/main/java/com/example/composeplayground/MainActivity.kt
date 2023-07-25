package com.example.composeplayground

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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
import com.example.composeplayground.addscreen.AddJournalEntryButton
import com.example.composeplayground.addscreen.BoxWithShadow
import com.example.composeplayground.addscreen.CompletedDay
import com.example.composeplayground.addscreen.DaytimeTable
import com.example.composeplayground.addscreen.FullAddItemsToDaytime
import com.example.composeplayground.addscreen.FullQuiz
import com.example.composeplayground.addscreen.FullTitleCard
import com.example.composeplayground.addscreen.MoodOptions
import com.example.composeplayground.addscreen.Row
import com.example.composeplayground.addscreen.item
import com.example.composeplayground.addscreen.row1
import com.example.composeplayground.addscreen.row2
import com.example.composeplayground.addscreen.row3
import com.example.composeplayground.evaluatingalgorithm.evaluationAlgorithm
import com.example.composeplayground.mainscreen.InfoBox
import com.example.composeplayground.mainscreen.MoodChart
import com.example.composeplayground.mainscreen.UserGreeting
import com.example.composeplayground.ui.theme.ComposePlaygroundTheme
import com.example.composeplayground.mainscreen.CalendarDatePicker
import com.patrykandpatrick.vico.core.entry.entryModelOf
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

//Journal App
var completedDay = CompletedDay()
val completedDays = mutableListOf<CompletedDay>()
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("MutableCollectionMutableState")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePlaygroundTheme {
                var shouldNavigateScreen by remember { mutableStateOf(false) }

                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    val onClick: () -> Unit = {
                        shouldNavigateScreen = !shouldNavigateScreen
                    }
                    if (shouldNavigateScreen){
                        AddScreen(onClick)
                    }
                    else{
                        evaluationAlgorithm()
                        MainScreen(onClick)
                    }


                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AddScreen(onClick: () -> Unit) {
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

        val (selected, setSelected) = remember { mutableStateOf("") }

        FullQuiz(selected,setSelected)
        println("Selected Option : $selected")

        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val onComplete: () -> Unit = {
            if (
                itemsListMorning.isNotEmpty() &&
                itemsListMidDay.isNotEmpty() &&
                itemsListEvening.isNotEmpty() &&
                selected.isNotEmpty()
            ){
                println("OnComplete")
                completedDay = CompletedDay(
                    date = dayTime.format(formatter),
                    morning = itemsListMorning,
                    midDay = itemsListMidDay,
                    evening = itemsListEvening,
                    mood = selected
                )
                completedDays.add(completedDay)
                println(completedDay)
                println(completedDays)
                onClick()
            }

        }
        AddJournalEntryButton(onComplete, "Complete")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainScreen(onClick: () -> Unit) {
    /*completedDays.addAll(
        listOf(
            CompletedDay(
                date = "2023-06-28",
                morning = listOf("Arbeit"),
                midDay   = listOf("Arbeit"),
                evening = listOf("Arbeit"),
                mood = "happy"
            ),
            CompletedDay(
                date = "2023-06-27",
                morning = listOf("Arbeit"),
                midDay   = listOf("Arbeit"),
                evening = listOf("Arbeit"),
                mood = "happy"
            ),
            CompletedDay(
                date = "2023-06-28",
                morning = listOf("Arbeit"),
                midDay   = listOf("Arbeit"),
                evening = listOf("Arbeit"),
                mood = "neutral"
            ),
            CompletedDay(
                date = "2023-06-27",
                morning = listOf("Arbeit"),
                midDay   = listOf("Arbeit"),
                evening = listOf("Arbeit"),
                mood = "neutral"
            ),
            CompletedDay(
                date = "2023-06-27",
                morning = listOf("Arbeit"),
                midDay   = listOf("Arbeit"),
                evening = listOf("Arbeit"),
                mood = "neutral"
            ),
            CompletedDay(
                date = "2023-06-27",
                morning = listOf("Arbeit"),
                midDay   = listOf("Arbeit"),
                evening = listOf("Arbeit"),
                mood = "sad"
            ),
            CompletedDay(
                date = "2023-06-28",
                morning = listOf("Arbeit"),
                midDay   = listOf("Arbeit"),
                evening = listOf("Arbeit"),
                mood = "happy"
            )
        )
    )*/
    Column {
        UserGreeting(username = "Jonas")
        Spacer(modifier = Modifier.weight(0.1f))

        InfoBox()

        val currentDateTime: LocalDateTime = LocalDateTime.now()
        Log.d("DATE", "$currentDateTime")

        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val date = currentDateTime.format(formatter)
        Log.d("DAYTIME", date)

        if (completedDays.size > 7){
            completedDays.removeFirst()
        }

        Log.d("LIST" ,completedDays.distinct().toString())
        val todaysMood = completedDays.find {it.date?.format(formatter) == date.toString()}?.mood ?: "neutral"
        Log.d("MOOD", todaysMood)
        fun getMoodValue(mood:String?): Float {
            when (mood){
                "sad" -> return 0f
                "happy" -> return 10f
            }
            //"neutral"->
            return 5f
        }
        val todaysValue = getMoodValue(todaysMood)

        val chartEntryModel = entryModelOf(
            getMoodValue(completedDays[6].mood),
            getMoodValue(completedDays[5].mood),
            getMoodValue(completedDays[4].mood),
            getMoodValue(completedDays[3].mood),
            getMoodValue(completedDays[2].mood),
            getMoodValue(completedDays[1].mood)
            ,todaysValue)

        //For y-axis description
        //val builder = TextComponent.Builder()
        //builder.textSizeSp = 20f
        //val textComponent: TextComponent = builder.build()

        MoodChart(chartEntryModel = chartEntryModel)
        Spacer(modifier = Modifier.weight(0.1f))
        var selectedDate by remember { mutableStateOf("") }
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally) {
    
            CalendarDatePicker {
                selectedDate = it
            }
            //TODO
            val inputPattern = SimpleDateFormat("d/M/yyyy")
            val outputPattern = SimpleDateFormat("yyyy-MM-dd")
            var foundMorningActivity: List<String>?= listOf()
            var foundMidDayActivity: List<String>?= listOf()
            var foundEveningActivity: List<String>?= listOf()
            var foundMood: String? = ""
            var newSelectedDate: String = ""
            var searchMood by remember { mutableStateOf("⚫") }
            var searchDate by remember { mutableStateOf("") }
            var searchMorning by remember { mutableStateOf("...") }
            var searchMidday by remember { mutableStateOf("...") }
            var searchEvening by remember { mutableStateOf("...") }
            var notiEmoji by remember { mutableStateOf("\uD83D\uDCEB") }

            if (selectedDate.isNotEmpty()) {
                    val oldDate = inputPattern.parse(selectedDate)
                    newSelectedDate = outputPattern.format(oldDate)
                    val foundObjectsList = completedDays.filter { it.date == newSelectedDate }
                    foundMood = foundObjectsList[0].mood
                    foundMorningActivity = foundObjectsList[0].morning
                    foundMidDayActivity = foundObjectsList[0].midDay
                    foundEveningActivity = foundObjectsList[0].evening
                    Log.d("FOUNDOBJECTS", foundObjectsList.toString())
                    Log.d("FOUNDMOOD", foundMood.toString())
                if (foundMood != null) {
                    searchMood = foundMood
                    searchDate = newSelectedDate
                    searchMorning = foundMorningActivity?.get(0).toString() + ", "
                    searchMidday = foundMidDayActivity?.get(0).toString() + ", "
                    searchEvening = foundEveningActivity?.get(0).toString() + ", "
                    notiEmoji = "\uD83D\uDCEC"
                }
                    //Text(text = "$newSelectedDate: $foundMood, ${foundMorningActivity?.get(0)}, ${foundMidDayActivity?.get(0)}, ${foundEveningActivity?.get(0)}")
                }
            //Text(text = selectedDate)
            //Placeholder emoji: ⚫
            //Placeholder Text: 〰️ 🟰 ➖
            //Closed Mailbox: 📫
            //Open Mailbox: 📬
            when(searchMood){
                "happy" -> searchMood = MoodOptions.HAPPY.emoji
                "neutral" -> searchMood = MoodOptions.NEUTRAL.emoji
                "sad" -> searchMood = MoodOptions.SAD.emoji
            }

            Card(modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
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
                        text = searchMood,
                        modifier = Modifier
                            .scale(1.5f)
                            .padding(start = 0.dp, bottom = 70.dp) )
                    Text(
                        text = searchDate,
                        modifier = Modifier
                            .scale(1.5f)
                            .padding(start = 55.dp, bottom = 70.dp) )
                    Text(
                        text = notiEmoji,
                        modifier = Modifier
                            .scale(1.5f)
                            .padding(start = 270.dp, bottom = 70.dp) )



                    Text(
                        text = "$searchMorning$searchMidday$searchEvening",
                        modifier = Modifier
                            .scale(1.5f)
                            .padding(start = 45.dp, top = 15.dp)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.weight(0.1f))

        //Row(modifier = Modifier
        //    .padding(start = 12.dp, end = 12.dp)) {
        //    SearchDateInput("DD")
        //    Spacer(modifier = Modifier.weight(0.1f))
        //    SearchDateInput("MM")
        //    Spacer(modifier = Modifier.weight(0.1f))
        //    SearchDateInput("YYYY")
        //}
        AddJournalEntryButton(onClick, "Create Journal Entry")
    }
}
//fun checkIfEmpty(vararg items:Any?):Boolean{
//
//    var isEmpty = true
//
//    for (i in items){
//        when(i){
//
//            is String -> if (i.isEmpty()) break
//            is Int? -> if (i == null) break
//            is Double? -> if (i == null) break
//            is Boolean? -> if (i == null) break
//            is List<*> -> if (i.size == 0) break
//            is Map<*, *> -> if (i.isEmpty()) break
//            is Set<*> -> if (i.isEmpty()) break
//            is Char -> if (i.isWhitespace()) break
//            else -> isEmpty = false
//
//        }
//    }
//    println(isEmpty)
//    return isEmpty
//}
@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun PreviewAll() {
    ComposePlaygroundTheme {
        var shouldNavigateScreen by remember { mutableStateOf(false) }

        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            val onClick: () -> Unit = {
                shouldNavigateScreen = !shouldNavigateScreen
            }
            if (shouldNavigateScreen){
                AddScreen(onClick)
            }
            else{
                evaluationAlgorithm()
                MainScreen(onClick)
            }


        }
    }
}


