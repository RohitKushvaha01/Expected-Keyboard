package com.rk.expectedkeyboard.keyboard

import android.inputmethodservice.InputMethodService
import android.view.View
import com.rk.expectedkeyboard.keyboard.ui.KeyboardUI
import java.lang.ref.WeakReference

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