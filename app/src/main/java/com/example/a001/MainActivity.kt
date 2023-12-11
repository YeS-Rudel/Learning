package com.example.a001

import android.content.Intent
import android.content.Intent.*
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import android.net.Uri

private  const val mask: String = "+9 (999) 99-99-999"
private const val NUMBER_MASK = '9'

class MainActivity : AppCompatActivity() {
    private lateinit var editView: EditText
    private lateinit var textView: TextView
    private lateinit var button: Button

    private var current = ""

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
            if (text.toString() != current) {
                if (text.toString().length  <= mask.length ) {
                    check(getValue(text.toString()))
                    textView.text = editView.text
                } else {
                    editView.setText(text.toString().substring(0, text.toString().length - 1))
                    editView.setSelection(editView.length())
                }
            }
        }
    }

    private fun count () {
        val intent = Intent(ACTION_DIAL, Uri.parse("tel:"+textView.text))
        startActivity(intent)
    }

    private fun getValue(text: String) : String {
        return  text.filter { char ->
            char.isDigit()
        }
    }

    private fun check(text: String) {
        var value = ""
        var length = text.length
        var index = 0
        var textCount = 0
        while (length > 0) {
            if (mask[index] == NUMBER_MASK) {
                value += text[textCount]
                textCount ++
                index ++
                length --
            } else {
                value += mask[index]
                index ++
            }
        }
        current = value
        editView.setText(value)
        editView.setSelection(editView.length())
    }
}
