package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.DatePicker;
import android.app.DatePickerDialog;
import android.content.Intent
import android.view.View
import android.widget.Button
import java.util.Calendar


class MainActivity : AppCompatActivity() {
    companion object{
        const val KEY="com.example.todolist.MainActivity"
    }
    private lateinit var edtext:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         edtext = findViewById<EditText>(R.id.edtext)
        val button=findViewById<Button>(R.id.button)


        button.setOnClickListener{
            intent= Intent(this,Age::class.java)
            val dob=edtext.text.toString()
            intent.putExtra("DOB",dob)
            startActivity(intent)

        }



    }
    fun showDatePickerDialog(view: View) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                val selectedDate = "$year-${monthOfYear + 1}-$dayOfMonth"
                edtext.setText(selectedDate)
            },
            year, month, day
        )

        datePickerDialog.show()
    }
}