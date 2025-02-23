package com.rk.expectedkeyboard.keyboard.ui

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.widget.LinearLayout

class Row : LinearLayout {
    constructor(context: Context):super(context)
    constructor(context: Context,attrs: AttributeSet?):super(context,attrs)
    constructor(context: Context,attrs: AttributeSet?,defStyleAttr: Int):super(context,attrs,defStyleAttr)

    init {
        orientation = HORIZONTAL
        gravity = Gravity.CENTER
    }
}