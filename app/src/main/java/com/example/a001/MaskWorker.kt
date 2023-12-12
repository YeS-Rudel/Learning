package com.example.a001

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

private const val mask: String = "+9 (999) 99-99-999"
private const val NUMBER_MASK = '9'

class MaskWorker(
    private val view: EditText,
    private var handler: (String) -> Unit,
) : TextWatcher {

    private var current = ""

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

    override fun afterTextChanged(s: Editable?) {
        val text = s.toString()
        if (text != current) {
            if (text.length <= mask.length) {
                check(getValue(text))
            } else {
                view.setText(text.substring(0, text.length - 1))
                view.setSelection(view.text.length)
            }
        }
    }

    private fun getValue(text: String): String {
        return text.filter { char ->
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
                textCount++
                index++
                length--
            } else {
                value += mask[index]
                index++
            }
        }
        current = value
        handler(current)
        view.setText(value)
        view.setSelection(value.length)
    }
}