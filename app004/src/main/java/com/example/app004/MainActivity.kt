package com.example.app004

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val items = arrayOf("Коля", "Сергей", "Андрей", "Женя")

        val list = findViewById<ListView>(R.id.listView)
        val adapter = MyArrayAdapter(
            this,
            items
        )
        list.adapter = adapter
    }
}