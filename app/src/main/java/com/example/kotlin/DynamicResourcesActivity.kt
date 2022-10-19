package com.example.kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin.databinding.ActivityDynamicResourcesBinding

class DynamicResourcesActivity : AppCompatActivity() {
    lateinit var binding: ActivityDynamicResourcesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDynamicResourcesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        binding.apply {
            val imageId = resources.getIdentifier("gradient", "drawable", packageName)
            ivResource.setImageResource(imageId)

            val stringId = resources.getIdentifier("oil_price", "string", packageName)
            tvResource.setText(stringId)
        }
    }
}