package com.example.a001

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {
    private lateinit var editView: EditText
    private lateinit var textView: TextView
    private lateinit var button: Button
    private var counter: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.countTextView)
        editView = findViewById(R.id.editTextText)
        button = findViewById(R.id.button)
        button.setOnClickListener {
            count()
        }
        editView.addTextChangedListener { text ->
            textView.text = text
        }
    }

    private fun count () {
        textView.text = editView.text
    }
}
