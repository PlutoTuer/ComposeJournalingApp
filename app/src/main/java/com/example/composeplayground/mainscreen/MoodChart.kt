package com.example.composeplayground.mainscreen


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.patrykandpatrick.vico.compose.axis.horizontal.bottomAxis
import com.patrykandpatrick.vico.compose.axis.vertical.startAxis
import com.patrykandpatrick.vico.compose.chart.Chart
import com.patrykandpatrick.vico.compose.chart.line.lineChart
import androidx.compose.ui.graphics.Color
import com.patrykandpatrick.vico.core.entry.ChartEntryModel
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.patrykandpatrick.vico.compose.axis.axisGuidelineComponent
import com.patrykandpatrick.vico.compose.axis.axisLabelComponent
import com.patrykandpatrick.vico.compose.axis.axisLineComponent
import com.patrykandpatrick.vico.compose.axis.axisTickComponent
import com.patrykandpatrick.vico.compose.style.currentChartStyle
import com.patrykandpatrick.vico.core.axis.AxisPosition
import com.patrykandpatrick.vico.core.axis.formatter.AxisValueFormatter
import com.patrykandpatrick.vico.core.chart.values.AxisValuesOverrider
import com.patrykandpatrick.vico.core.chart.values.ChartValues
import java.time.LocalDate

@Composable
fun MoodChart(
    chartEntryModel: ChartEntryModel,
) {
    class CustomYAxisValueFormatter :
        AxisValueFormatter<AxisPosition.Vertical.Start> {
        override fun formatValue(
            value: Float,
            chartValues: ChartValues
        ): CharSequence {
            return when (value) {
                0f -> "\uD83D\uDE41"
                5f -> "\uD83D\uDE10"
                10f -> "\uD83D\uDE42"
                else -> value.toString()
            }
        }
        val test = AxisPosition.Vertical.End
    }


    class CustomXAxisValueFormatter :
        AxisValueFormatter<AxisPosition.Horizontal.Bottom> {
        @RequiresApi(Build.VERSION_CODES.O)
        override fun formatValue(
            value: Float,
            chartValues: ChartValues
        ): CharSequence {

            val currentDate = LocalDate.now()
            val currentDay = currentDate.dayOfMonth

            val firstDay = currentDay - 6 // Adjust the range to include the current day
            val index = firstDay + value.toInt()

            return when (index) {
                currentDay -> currentDay.toString()
                in firstDay until currentDay -> (index).toString()
                else -> currentDate.toString()
            }

            // return value.toString()
        }
    }
    Column() {
        Chart(
            chart = lineChart(
                axisValuesOverrider = AxisValuesOverrider.fixed(
                    minY = 0f,
                    maxY = 10f
                )
            ),
            model = chartEntryModel,
            modifier = Modifier
                .padding(end = 40.dp)
                .align(Alignment.CenterHorizontally),

            startAxis = startAxis(

                //Y-axis label text
                label = axisLabelComponent(
                    color = Color(102, 80, 163, 255),
                    textSize = 18.sp,
                    verticalPadding = 10.dp,
                    horizontalPadding = 10.dp,
                    verticalMargin = 10.dp,
                    horizontalMargin = 10.dp,
                ),
                //literal y-axis line
                axis = axisLineComponent(
                    color = Color(102, 80, 163, 255),
                    thickness = 2.dp,
                    shape = currentChartStyle.axis.axisTickShape,
                    strokeWidth = 2.dp,
                    strokeColor = Color(102, 80, 163, 255)
                ),
                //Y-Axis Stripe
                tick = axisTickComponent(
                    color = Color.Red,
                    thickness = 0.dp,
                    strokeWidth = 0.dp,
                    strokeColor = Color.Red,
                    dynamicShader = null
                ),
                //Basically left margin between y-axis label and literal y-axis
                tickLength = 0.dp,
                //Max number of y-axis labels excluding 0
                maxLabelCount = 2,
                //Y-Axis Gridlines
                guideline = axisGuidelineComponent(
                    color = Color(102, 80, 163, 141)
                ),
                valueFormatter = CustomYAxisValueFormatter(),
                //Rotation of text label on y-axis
                labelRotationDegrees = 0f,
                //title Component instance is needed for title to appear?..
                //titleComponent = textComponent,
                //title = "Mood"
            ),

            bottomAxis = bottomAxis(

                //X-axis label text
                label = axisLabelComponent(
                    color = Color(102, 80, 163, 255),
                    textSize = 18.sp,
                    verticalPadding = 1.dp,
                    horizontalPadding = 1.dp,
                    verticalMargin = 1.dp,
                    horizontalMargin = 1.dp,
                ),
                //literal x-axis line
                axis = axisLineComponent(
                    color = Color(102, 80, 163, 255),
                    thickness = 2.dp,
                    shape = currentChartStyle.axis.axisTickShape,
                    strokeWidth = 2.dp,
                    strokeColor = Color(102, 80, 163, 255)
                ),
                //X-Axis Stripe
                tick = axisTickComponent(
                    color = Color.Red,
                    thickness = 0.dp,
                    strokeWidth = 0.dp,
                    strokeColor = Color.Red,
                    dynamicShader = null
                ),
                //Basically left margin between X-axis label and literal y-axis
                tickLength = 0.dp,
                //X-Axis Gridlines
                guideline = axisGuidelineComponent(
                    color = Color(102, 80, 163, 141)
                ),
                valueFormatter = CustomXAxisValueFormatter(),
                //Rotation of text label on y-axis
                labelRotationDegrees = 0f,
                //title Component instance is needed for title to appear?..
                //titleComponent = textComponent,
                //title = "Mood"
            ),

            )
    }
}