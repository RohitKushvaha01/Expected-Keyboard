package com.rk.expectedkeyboard.keyboard

import android.inputmethodservice.InputMethodService
import android.view.View
import com.rk.expectedkeyboard.ui.KeyboardUI
import java.lang.ref.WeakReference

class InputService : InputMethodService() {

    companion object{
        private var inputService = WeakReference<InputService?>(null)
        fun getInstance(): InputService?{
            return inputService.get()
        }
    }

    override fun onCreate() {
        super.onCreate()
        inputService = WeakReference(this)
    }

    override fun onCreateInputView(): View? {
        return KeyboardUI(this)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}