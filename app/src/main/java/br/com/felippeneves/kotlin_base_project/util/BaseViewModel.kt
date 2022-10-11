package br.com.felippeneves.kotlin_base_project.util

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {

    protected fun validate(
        validation: MutableLiveData<ValidationResultListener>,
        value: String,
        nextFocus: Boolean = false
    ): Boolean {
        return try {

            if (value.isNotBlank()) {
                if (nextFocus)
                    validation.value = ValidationResultListener()
                true
            } else {
                validation.value = ValidationResultListener(ValidationResultListener.EMPTY)
                false
            }
        } catch (e: Exception) {
            validation.value = ValidationResultListener(ValidationResultListener.FAILURE, e.message)
            false
        }
    }
}