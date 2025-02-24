package com.rk.expectedkeyboard.keyboard

import android.webkit.JavascriptInterface
import androidx.annotation.Keep
import com.rk.expectedkeyboard.keyboard.ui.KeyboardUI

@Keep
class KeyboardInterface(val keyboardUI: KeyboardUI) {

    @Keep
    @JavascriptInterface
    fun setKeyboardHeight(height: Int) {
        keyboardUI.setKeyboardHeight(height)
    }

    @Keep
    @JavascriptInterface
    fun commitText(text: String, p: Int) {
        keyboardUI.inputService.currentInputConnection.commitText(text, p)
    }

    //  Deletes a character before the cursor
    @Keep
    @JavascriptInterface
    fun deleteLastCharacter() {
        keyboardUI.inputService.currentInputConnection.deleteSurroundingText(1, 0)
    }

    //  Deletes a specified number of characters before the cursor
    @Keep
    @JavascriptInterface
    fun deleteCharacters(count: Int) {
        keyboardUI.inputService.currentInputConnection.deleteSurroundingText(count, 0)
    }

    //  Moves the cursor by a given offset (+ forward, - backward)
    @Keep
    @JavascriptInterface
    fun moveCursor(offset: Int) {
        keyboardUI.inputService.currentInputConnection.setSelection(
            keyboardUI.inputService.currentInputConnection.getSelectedText(0)?.length
                ?: (0 + offset),
            keyboardUI.inputService.currentInputConnection.getSelectedText(0)?.length
                ?: (0 + offset)
        )
    }

    //  Gets the current text before the cursor
    @Keep
    @JavascriptInterface
    fun getTextBeforeCursor(maxChars: Int): String {
        return keyboardUI.inputService.currentInputConnection.getTextBeforeCursor(maxChars, 0)?.toString() ?: ""
    }

    //  Gets the current text after the cursor
    @Keep
    @JavascriptInterface
    fun getTextAfterCursor(maxChars: Int): String {
        return keyboardUI.inputService.currentInputConnection.getTextAfterCursor(maxChars, 0)?.toString() ?: ""
    }

    //  Clears all text
    @Keep
    @JavascriptInterface
    fun clearText() {
        keyboardUI.inputService.currentInputConnection.deleteSurroundingText(Int.MAX_VALUE, Int.MAX_VALUE)
    }

    //  Inserts raw key event (for simulating key presses)
    @Keep
    @JavascriptInterface
    fun sendKeyEvent(keyCode: Int) {
        val event = android.view.KeyEvent(android.view.KeyEvent.ACTION_DOWN, keyCode)
        keyboardUI.inputService.currentInputConnection.sendKeyEvent(event)
    }
}
