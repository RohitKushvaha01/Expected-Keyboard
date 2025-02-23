package com.rk.expectedkeyboard.keyboard.ui

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.TextView
import com.rk.expectedkeyboard.keyboard.inputService

class Key : TextView {
    constructor(context: Context):super(context)
    constructor(context: Context,attrs: AttributeSet?):super(context,attrs)
    constructor(context: Context,attrs: AttributeSet?,defStyleAttr: Int):super(context,attrs,defStyleAttr)

    init {
        val XlayoutParams = ViewGroup.MarginLayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        XlayoutParams.setMargins(16, 8, 16, 8)
        layoutParams = XlayoutParams
    }

    fun setLabel(text: String){
        setText(text)
        setOnClickListener {
            inputService.get()?.currentInputConnection?.commitText(this.text, 1)
        }
    }
}