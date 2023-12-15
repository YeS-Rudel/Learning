package com.example.task003

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var editView: EditText
    private lateinit var button: Button
    private var text = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editView = findViewById(R.id.editTextText)
        button = findViewById(R.id.button)
        button.setOnClickListener {
            save(string = editView.text.toString())
        }
    }

    private fun save(string: String) {
        this.text = string
        val intent = Intent(this, SecondScreenActivity::class.java)
        intent.putExtra(SecondScreenActivity.TEXT, text)
        startActivity(intent)
    }
}