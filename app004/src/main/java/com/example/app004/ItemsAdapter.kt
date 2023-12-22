package com.example.app004

import android.text.SpannableString
import android.text.Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
import android.text.style.StrikethroughSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.properties.Delegates

class ItemsAdapter: RecyclerView.Adapter<ItemsAdapter.ViewHolder>() {

    var items: Array<String> by Delegates.observable(emptyArray()) { _, oldItems, newItems -> notifyDataSetChanged() }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.item_adapter, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.binding(item)
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val title = view.findViewById<TextView>(R.id.titleItem)
        private val checkBox = view.findViewById<CheckBox>(R.id.checkBoxItem)

        fun binding(item: String) {
            title.text = item
            checkBox.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    val newString = SpannableString(item)
                    newString.setSpan(StrikethroughSpan(), 0, item.length, SPAN_EXCLUSIVE_EXCLUSIVE)
                    title.text = newString
                } else {
                    title.text = item
                }
            }
        }
    }
}