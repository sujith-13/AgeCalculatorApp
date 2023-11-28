package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale

class Age : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_age)
        val age=intent.getStringExtra("DOB")
        val edittext=findViewById<TextView>(R.id.tv2)
        val sdf=SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val dob=sdf.parse(age)

        val date=Date()
        val ageinmillis=date.time-dob.time
        val ageinyears=ageinmillis/(1000L*60*60*24*365.25)
        edittext.text="Your Present Age in Years: ${ageinyears.toInt()} years"





    }
}