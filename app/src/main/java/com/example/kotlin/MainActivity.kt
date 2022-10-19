package com.example.kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin.databinding.ActivityMainBinding
import com.squareup.timessquare.CalendarPickerView
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)
        }

        initView()
    }

    private fun initView() {
        val nextYear: Calendar = Calendar.getInstance()
        nextYear.add(Calendar.YEAR, 1)

        val calendar = binding.calendarView
        val today = Date()
        calendar.init(today, nextYear.getTime())
            .inMode(CalendarPickerView.SelectionMode.RANGE)
    }
}