package com.tops.kotlin.androidsharedpreferences

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.tops.kotlin.androidsharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            val name = binding.edtName.text.toString().trim()
            val age = binding.edtAge.text.toString().trim().toInt()
            val salary = binding.edtSalary.text.toString().trim().toDouble()

            saveRecord(name, age, salary)
        }

        binding.btnView.setOnClickListener {
            startActivity(Intent(this, DetailActivity::class.java))
        }
    }

    private fun saveRecord(name: String, age: Int, salary: Double) {
        val preference = getSharedPreferences("employee_data", MODE_PRIVATE)
        val editor = preference.edit()
        editor.putString("name", name)
        editor.putInt("age", age)
        editor.putFloat("salary", salary.toFloat())

        editor.commit()

        Toast.makeText(this, "Record Saved Successfully", Toast.LENGTH_SHORT).show()
    }
}