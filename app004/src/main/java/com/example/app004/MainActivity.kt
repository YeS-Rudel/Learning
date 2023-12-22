package com.example.app004

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager


class MainActivity : AppCompatActivity() {

    private lateinit var list: androidx.recyclerview.widget.RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list = findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.tableView)
        val items = arrayOf("Коля", "Сергей", "Андрей", "Женя")
        val adapter = ItemsAdapter(this, items)
        list.hasFixedSize()
        list.layoutManager = LinearLayoutManager(this)
        list.adapter = adapter
    }
}