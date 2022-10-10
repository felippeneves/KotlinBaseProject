package br.com.felippeneves.kotlin_base_project.presentation.viewmodel

import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.com.felippeneves.kotlin_base_project.R
import br.com.felippeneves.kotlin_base_project.data.model.entities.UserDbo
import br.com.felippeneves.kotlin_base_project.domain.use_case.user.UserUseCase
import br.com.felippeneves.kotlin_base_project.util.BaseViewModel
import br.com.felippeneves.kotlin_base_project.util.ValidationResultListener
import kotlinx.coroutines.launch

class UserRegisterViewModel(
    private val userUseCase: UserUseCase,
) : BaseViewModel() {

    val inputFirstName = MutableLiveData("")
    private val _validationFirstName = MutableLiveData<ValidationResultListener>()
    var validationFirstName: LiveData<ValidationResultListener> = _validationFirstName

    val inputLastName = MutableLiveData("")
    private val _validationLastName = MutableLiveData<ValidationResultListener>()
    var validationLastName: LiveData<ValidationResultListener> = _validationLastName

    val inputAge = MutableLiveData("")
    private val _validationAge = MutableLiveData<ValidationResultListener>()
    var validationAge: LiveData<ValidationResultListener> = _validationAge

    private val _validationAddUser = MutableLiveData<ValidationResultListener>()
    var validationAddUser: LiveData<ValidationResultListener> = _validationAddUser

    val id: Int? = null

    fun saveOrUpdate() {
        viewModelScope.launch {
            try {
                if(validate()) {
                    userUseCase.addUser(UserDbo(inputFirstName.value!!, inputLastName.value!!, inputAge.value!!.toInt()))
                    _validationAddUser.value = ValidationResultListener()
                }
            } catch (e: Exception) {
                _validationAddUser.value = ValidationResultListener(ValidationResultListener.FAILURE, e.message)
            }
        }
    }

    private fun validate(): Boolean {
        return validateFirstName() && validateLastName() && validateAge()
    }

    private fun validateFirstName(nextFocus: Boolean = false): Boolean {
        return validate(_validationFirstName, inputFirstName.value!!, nextFocus)
    }

    private fun validateLastName(nextFocus: Boolean = false): Boolean {
        return validate(_validationLastName, inputLastName.value!!, nextFocus)
    }

    private fun validateAge(nextFocus: Boolean = false): Boolean {
        return validate(_validationAge, inputAge.value!!, nextFocus)
    }

    fun onDoneClicked(view: View, actionId: Int): Boolean {
        if (actionId == EditorInfo.IME_ACTION_DONE) {

            when (view.id) {
                R.id.etFirstName -> {
                    validateFirstName(true)
                }
                R.id.etLastName -> {
                    validateLastName(true)
                }
                R.id.etAge -> {
                    validateAge(true)
                }
            }

            return true
        }

        return false
    }
}