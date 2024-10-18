package com.tops.kotlin.androidsharedpreferences

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.tops.kotlin.androidsharedpreferences.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        readRecord()
    }

    @SuppressLint("SetTextI18n")
    private fun readRecord() {
        val preference = getSharedPreferences("employee_data", MODE_PRIVATE)
        val name = preference.getString("name", "")
        val age = preference.getInt("age", 0)
        val salary = preference.getFloat("salary", 0.0f)

        binding.tvDetails.text = """
            Name : $name
            Age : $age
            Salary : $salary
        """.trimIndent()
    }
}