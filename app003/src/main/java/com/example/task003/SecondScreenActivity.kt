package com.example.task003

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toolbar

class SecondScreenActivity : AppCompatActivity() {

    companion object {
        const val TEXT = "text"
    }

    var text = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_screen)
        text = intent.extras?.getString(TEXT, "").orEmpty()
        this.findViewById<TextView>(R.id.secondTextView).text = text
        setSupportActionBar(this.findViewById(R.id.toolbar))
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }



    }
}