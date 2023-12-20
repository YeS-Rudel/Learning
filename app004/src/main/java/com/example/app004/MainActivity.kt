package com.example.app004
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private var items = arrayOf(
        "Молоко", "Сметана", "Колбаска", "Сыр", "Мышка",
        "Ананас", "Икра черная", "Икра кабачковая", "Яйцо"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list = findViewById<ListView>(R.id.listView)
        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_multiple_choice, items
        )
        list.adapter = adapter
    }
}