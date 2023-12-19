package com.example.task003

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondScreenActivity : AppCompatActivity() {

    companion object {
        const val SECOND_TEXT = "text"
        const val RESULT_CODE = 1001
    }

    private var text = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_screen)
        text = intent.extras?.getString(SECOND_TEXT, "").orEmpty()
        val editView = this.findViewById<TextView>(R.id.secondTextView)
        editView.text = text
        setSupportActionBar(this.findViewById(R.id.toolbar))
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
        val button = findViewById<Button>(R.id.secondButton)
        button.setOnClickListener {
            val intent = Intent()
            intent.putExtra(MainActivity.MAIN_TEXT, editView.text.toString())
            setResult(RESULT_CODE, intent)
            finish()
        }
    }
}