package com.rk.expectedkeyboard.keyboard.ui

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.core.content.ContextCompat

class KeyboardUI : LinearLayout {
    constructor(context: Context):super(context)
    constructor(context: Context,attrs: AttributeSet?):super(context,attrs)
    constructor(context: Context,attrs: AttributeSet?,defStyleAttr: Int):super(context,attrs,defStyleAttr)

    init {
        orientation = VERTICAL
        gravity = Gravity.CENTER

        addView(Row(context).apply {
            addView(Key(context).apply {
                setLabel("Q")
            })
            addView(Key(context).apply {
                setLabel("W")
            })
            addView(Key(context).apply {
                setLabel("E")
            })
            addView(Key(context).apply {
                setLabel("R")
            })
            addView(Key(context).apply {
                setLabel("T")
            })
            addView(Key(context).apply {
                setLabel("Y")
            })
            addView(Key(context).apply {
                setLabel("U")
            })
            addView(Key(context).apply {
                setLabel("I")
            })
            addView(Key(context).apply {
                setLabel("O")
            })
            addView(Key(context).apply {
                setLabel("P")
            })
        })
        addView(Row(context).apply {
            addView(Key(context).apply {
                setLabel("A")
            })
            addView(Key(context).apply {
                setLabel("S")
            })
            addView(Key(context).apply {
                setLabel("A")
            })
            addView(Key(context).apply {
                setLabel("S")
            })
            addView(Key(context).apply {
                setLabel("G")
            })
            addView(Key(context).apply {
                setLabel("H")
            })
            addView(Key(context).apply {
                setLabel("J")
            })
            addView(Key(context).apply {
                setLabel("K")
            })
            addView(Key(context).apply {
                setLabel("L")
            })
        })
        addView(Row(context).apply {
            addView(ImageButton(context).apply {
                setImageDrawable(ContextCompat.getDrawable(context,android.R.drawable.arrow_up_float))
            })
            addView(Key(context).apply {
                setLabel("Z")
            })
            addView(Key(context).apply {
                setLabel("X")
            })
            addView(Key(context).apply {
                setLabel("C")
            })
            addView(Key(context).apply {
                setLabel("V")
            })
            addView(Key(context).apply {
                setLabel("B")
            })
            addView(Key(context).apply {
                setLabel("N")
            })
            addView(Key(context).apply {
                setLabel("M")
            })
            addView(ImageButton(context).apply {
                setImageDrawable(ContextCompat.getDrawable(context,android.R.drawable.ic_delete))
            })
        })
        addView(Row(context).apply {
            addView(Key(context).apply {
                setLabel("SPACE")
            })
        })
    }
}