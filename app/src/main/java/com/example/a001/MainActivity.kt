package com.example.a001

import android.content.Intent
import android.content.Intent.*
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import android.net.Uri

class MainActivity : AppCompatActivity() {
    private lateinit var editView: EditText
    private lateinit var button: Button
    private lateinit var watcher: MaskWorker
    private var text = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editView = findViewById(R.id.editTextText)
        watcher = MaskWorker(editView) {
            text = it
        }
        button = findViewById(R.id.button)
        button.setOnClickListener {
            call()
        }
        editView.addTextChangedListener(watcher)
    }

    private fun call() {
        val intent = Intent(ACTION_DIAL, Uri.parse("tel:$text"))
        startActivity(intent)
    }
}
