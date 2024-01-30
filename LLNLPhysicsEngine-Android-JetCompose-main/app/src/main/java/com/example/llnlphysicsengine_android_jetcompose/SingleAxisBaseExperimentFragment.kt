package com.example.llnlphysicsengine_android_jetcompose


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet


class SingleAxisBaseExperimentFragment {
    @Composable
    fun LineChartView(data: MutableList<Float>, time: MutableList<Float>) {

        AndroidView(
            modifier = Modifier.fillMaxWidth().aspectRatio(1.5f),
            factory = { context ->

                val chart = LineChart(context)
                chart.xAxis.position =
                    com.github.mikephil.charting.components.XAxis.XAxisPosition.BOTTOM //X axis on bottom
                chart.xAxis.setLabelCount(
                    7,
                    true
                )
                chart.axisRight.isEnabled =
                    false


                val entryList = mutableListOf<Entry>()
                for (i in 0..data.size - 1) {
                    entryList.add(Entry(time[i], data[i]))
                }


                val dataSet = LineDataSet(entryList, "Set 1")
                dataSet.setDrawCircles(false)
                dataSet.color = R.color.blue
                dataSet.lineWidth = 1f
                dataSet.mode = LineDataSet.Mode.LINEAR

                val dataSets = LineData()
                dataSets.addDataSet(dataSet)
                dataSets.setDrawValues(false)

                chart.data = dataSets

                chart

            },
            update = { chart ->
                updateChartData(chart, data, time)
            }
        )
    }


    fun updateChartData(chart: LineChart, data2: MutableList<Float>, time2: MutableList<Float>) {

        val entryList = mutableListOf<Entry>()
        for (i in 0..data2.size - 1) {
            entryList.add(Entry(time2[i], data2[i]))
        }
        val dataSet = LineDataSet(entryList, "Set 1")
        dataSet.setDrawCircles(false)
        dataSet.color = R.color.blue
        dataSet.lineWidth = 1f
        dataSet.mode = LineDataSet.Mode.LINEAR
        dataSet.setDrawValues(false)

        val lineData = LineData(dataSet)
        chart.data = lineData


        chart.notifyDataSetChanged()
        chart.invalidate()

    }
}

@Preview(showBackground = true)
@Composable
fun ChartPreview() {
    val numbers: MutableList<Float> = mutableListOf(1.5f, 2.0f, 3.2f)
    val time: MutableList<Float> = mutableListOf(1.5f, 2.0f, 3.2f)
    Column(modifier = Modifier.fillMaxWidth()){
        SingleAxisBaseExperimentFragment().LineChartView(numbers, time)
    }
}
