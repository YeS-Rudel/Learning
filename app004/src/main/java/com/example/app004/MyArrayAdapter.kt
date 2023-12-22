package com.example.app004

import android.content.Context
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StrikethroughSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.TextView
import com.example.app004.R.*

class MyArrayAdapter(
    context: Context,
    private val values: Array<String>
) :
    ArrayAdapter<String?>(context, layout.item_adapter, values) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = LayoutInflater.from(parent.context)
        val rowView: View = inflater.inflate(layout.item_adapter, parent, false)
        val title = rowView.findViewById<View>(id.titleItem) as TextView
        val checkBox = rowView.findViewById<View>(id.checkBoxItem) as CheckBox
        title.text = values[position]
        val item = values[position]
        checkBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                val newString = SpannableString(item)
                newString.setSpan(
                    StrikethroughSpan(), 0, item.length,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                )
                title.text = newString
            } else {
                title.text = item
            }
        }
        return rowView
    }
}