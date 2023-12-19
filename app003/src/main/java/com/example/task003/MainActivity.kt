package com.example.task003

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    companion object {
        const val MAIN_TEXT = "text"
    }

    private lateinit var editView: EditText

    var resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            when (it.resultCode) {
                SecondScreenActivity.RESULT_CODE -> {
                    val text = it.data?.extras?.getString(MainActivity.MAIN_TEXT, "").orEmpty()
                    editView.setText(text)
                }
            }

        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editView = findViewById<EditText>(R.id.editTextText)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            save(string = editView.text.toString())
        }
    }

    private fun save(string: String) {
        val intent = Intent(this, SecondScreenActivity::class.java)
        intent.putExtra(SecondScreenActivity.SECOND_TEXT, string)
        resultLauncher.launch(intent)
    }
}