package com.example.kotlin

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import kotlin.random.Random

class ChartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chart)

        drawLineChart()
    }

    private fun drawLineChart() {
        val lineChart = findViewById<LineChart>(R.id.lineChart)
        val lineEntries = getDataSet()
        val lineDataSet = LineDataSet(lineEntries, "")
        lineDataSet.color = Color.parseColor("#01ad52")
        lineDataSet.setDrawValues(false)
        lineDataSet.setDrawCircles(false)
        lineDataSet.lineWidth = 1f
        lineDataSet.setDrawFilled(true)
        lineDataSet.fillDrawable = ContextCompat.getDrawable(this, R.drawable.gradient)
        val lineData = LineData(lineDataSet)

        lineChart.description = Description().apply {
            text = ""
        }

        lineChart.setTouchEnabled(true)
        lineChart.isClickable = false
        lineChart.isDoubleTapToZoomEnabled = false

        lineChart.setDrawBorders(false)
        lineChart.setDrawGridBackground(false)

        lineChart.axisLeft.setDrawGridLines(false)
        lineChart.axisLeft.setDrawLabels(false)
        lineChart.axisLeft.setDrawAxisLine(false)

        lineChart.xAxis.setDrawGridLines(false)
        lineChart.xAxis.setDrawLabels(false)
        lineChart.xAxis.setDrawAxisLine(false)

        lineChart.axisRight.setDrawGridLines(false)
        lineChart.axisRight.setDrawLabels(false)
        lineChart.axisRight.setDrawAxisLine(false)

        lineChart.legend.isEnabled = false
        lineChart.data = lineData
    }

    private fun getDataSet(): List<Entry> {
        val lineEntries: MutableList<Entry> = ArrayList()
        for (i in 1..30) {
            val randomNumber = Random(10).nextInt(1000)
            lineEntries.add(Entry(i.toFloat(), (i + randomNumber).toFloat()))
        }

        return lineEntries
    }
}