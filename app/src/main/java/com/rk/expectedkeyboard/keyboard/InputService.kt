package com.rk.expectedkeyboard.keyboard

import android.inputmethodservice.InputMethodService
import android.view.View
import android.widget.Button
import java.lang.ref.WeakReference
import com.rk.expectedkeyboard.R
import com.rk.expectedkeyboard.keyboard.ui.KeyboardUI

var inputService = WeakReference<InputService?>(null)

class InputService : InputMethodService() {

    override fun onCreate() {
        super.onCreate()
        inputService = WeakReference(this)
    }

    override fun onCreateInputView(): View? {
        return KeyboardUI(this)
    }
}