package com.ltts.registration

import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import android.app.Activity
import android.content.Context
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager


class invalid

(private val cont: Context) {
    fun isInputEditTextFilled(textInput: TextInputEditText, InputLayout: TextInputLayout, message: String): Boolean {
        val value = textInput.text.toString().trim()
        if (value.isEmpty()) {
            InputLayout.error = message
            hideKeyboardFrom(textInput)
            return false
        } else {
            InputLayout.isErrorEnabled = false
        }
        return true
    }
    fun isInputEditTextEmail(textInputEditText: TextInputEditText, textInputLayout: TextInputLayout, msg: String): Boolean {
        val value = textInputEditText.text.toString().trim()
        if (value.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(value).matches()) {
            textInputLayout.error = msg
            hideKeyboardFrom(textInputEditText)
            return false
        } else {
            textInputLayout.isErrorEnabled = false
        }
        return true
    }
    fun isInputEditTextMatches(textInputEditText1: TextInputEditText, textInputEditText2: TextInputEditText, textInputLayout: TextInputLayout, message: String): Boolean {
        val value1 = textInputEditText1.text.toString().trim()
        val value2 = textInputEditText2.text.toString().trim()
        if (!value1.contentEquals(value2)) {
            textInputLayout.error = message
            hideKeyboardFrom(textInputEditText2)
            return false
        } else {
            textInputLayout.isErrorEnabled = false
        }
        return true
    }
    private fun hideKeyboardFrom(view: View) {
        val imm = cont.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
    }
}