package com.example.app004

import android.content.Context
import android.text.SpannableString
import android.text.Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
import android.text.style.StrikethroughSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemsAdapter(
    context: Context,
    items: Array<String>
): RecyclerView.Adapter<ItemsAdapter.ViewHolder>() {
    val listItems = items
    val parentContext = context

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val title = view.findViewById<TextView>(R.id.titleItem)
        val checkBox = view.findViewById<CheckBox>(R.id.checkBoxItem)

        fun binding(item: String) {
            title.text = item
            checkBox.setOnClickListener(){
                if (checkBox.isChecked) {
                    val newString = SpannableString(item)
                    newString.setSpan(StrikethroughSpan(), 0, item.length, SPAN_EXCLUSIVE_EXCLUSIVE)
                    title.text = newString
                } else {
                    title.text = item
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parentContext)
        return ViewHolder(inflater.inflate(R.layout.item_adapter, parent, false))
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listItems.get(position)
        holder.binding(item)
    }
}