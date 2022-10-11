package br.com.felippeneves.kotlin_base_project.util

import android.content.Context
import android.content.Intent
import android.os.Build
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout
import java.io.Serializable

open class BaseActivity : AppCompatActivity() {

    private val context: Context = this

    protected lateinit var listFocus: List<Any>

    protected fun selectNextFocus(campo: Any?) {
        try {
            if (listFocus.isNotEmpty() && campo != null) {

                if (campo != listFocus.last()) {
                    val nextIndex = listFocus.indexOf(campo) + 1
                    val nextView = listFocus[nextIndex] as View
                    nextView.requestFocus()
                }
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }

    protected fun setFailureEditText(
        editText: EditText,
        textInputLayout: TextInputLayout,
        message: String?
    ) {
        editText.requestFocus()

        if (message != null) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
            textInputLayout.error = message
            textInputLayout.isErrorEnabled = true
        }
    }

    protected fun disableErrorTextInput(textInputLayout: TextInputLayout) {
        if (textInputLayout.isErrorEnabled)
            textInputLayout.isErrorEnabled = false
    }

    protected fun <T : Serializable?> getSerializable(
        intent: Intent,
        key: String,
        className: Class<T>
    ): T? {
        return if (Build.VERSION.SDK_INT >= 33)
            intent.getSerializableExtra(key, className)!!
        else
            intent.getSerializableExtra(key) as T
    }
}