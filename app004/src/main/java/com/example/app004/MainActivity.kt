package com.example.app004

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity() {

    private lateinit var list: androidx.recyclerview.widget.RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list = findViewById(R.id.rv_list)
        val adapter = ItemsAdapter()
        adapter.items = arrayOf("Коля", "Сергей", "Андрей", "Женя")
        list.hasFixedSize()
        list.layoutManager = LinearLayoutManager(this)
        list.adapter = adapter
    }
}