package com.rk.expectedkeyboard.keyboard.ui

import android.annotation.SuppressLint
import android.content.res.Resources
import android.view.ViewGroup
import android.webkit.WebView
import com.rk.expectedkeyboard.keyboard.InputService
import com.rk.expectedkeyboard.keyboard.KeyboardInterface
import android.content.res.Configuration

@SuppressLint("ViewConstructor", "SetJavaScriptEnabled")
class KeyboardUI(val inputService: InputService) : WebView(inputService) {

    val displayMetrics = Resources.getSystem().displayMetrics
    val screenHeight = displayMetrics.heightPixels
    val orientation = context.resources.configuration.orientation


    private var _height = if(orientation == Configuration.ORIENTATION_LANDSCAPE){
        (screenHeight/2).toInt()
    }else{
        (screenHeight/3).toInt()
    }


    fun setKeyboardHeight(height: Int){
        _height = height
        layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            _height
        )
    }

    init {
        settings.apply {
            javaScriptEnabled = true
            javaScriptCanOpenWindowsAutomatically = false
            domStorageEnabled = true
            databaseEnabled = true
            allowContentAccess = true
            setSupportMultipleWindows(false)
            setSupportZoom(false)
            builtInZoomControls = false
        }


        addJavascriptInterface(KeyboardInterface(this), "Keyboard")

        layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            _height
        )

        loadUrl("file:///android_asset/ui/index.html")
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width = MeasureSpec.makeMeasureSpec(resources.displayMetrics.widthPixels, MeasureSpec.EXACTLY)
        val height = MeasureSpec.makeMeasureSpec(_height, MeasureSpec.EXACTLY)
        setMeasuredDimension(width, height)
    }



}