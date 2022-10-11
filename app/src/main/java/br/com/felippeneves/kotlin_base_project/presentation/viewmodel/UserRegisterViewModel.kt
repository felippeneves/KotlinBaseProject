package br.com.felippeneves.kotlin_base_project.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.com.felippeneves.kotlin_base_project.data.model.entities.UserDbo
import br.com.felippeneves.kotlin_base_project.domain.use_case.user.UserUseCase
import br.com.felippeneves.kotlin_base_project.util.BaseViewModel
import br.com.felippeneves.kotlin_base_project.util.ValidationResultListener
import kotlinx.coroutines.*

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

    val id = MutableLiveData<Int?>(null)

    fun saveOrUpdate() {
        viewModelScope.launch {
            try {
                if (validate()) {

                    if (id.value != null) {
                        userUseCase.updateUser(
                            UserDbo(
                                id.value!!,
                                inputFirstName.value!!,
                                inputLastName.value!!,
                                inputAge.value!!.toInt()
                            )
                        )
                    } else {
                        userUseCase.addUser(
                            UserDbo(
                                first_name = inputFirstName.value!!,
                                last_name = inputLastName.value!!,
                                age = inputAge.value!!.toInt()
                            )
                        )
                    }

                    _validationAddUser.value = ValidationResultListener()
                }
            } catch (e: Exception) {
                _validationAddUser.value =
                    ValidationResultListener(ValidationResultListener.FAILURE, e.message)
            }
        }
    }

    private fun validate(): Boolean {
        return validateFirstName() && validateLastName() && validateAge()
    }

    fun validateFirstName(nextFocus: Boolean = false): Boolean {
        var validate = false

        runBlocking {
            val validateDispatcher = async {
                validate(_validationFirstName, inputFirstName.value!!, nextFocus)
            }
            validate = validateDispatcher.await()
        }

        return validate
    }

    fun validateLastName(nextFocus: Boolean = false): Boolean {
        var validate = false

        runBlocking {
            val validateDispatcher = async {
                validate(_validationLastName, inputLastName.value!!, nextFocus)
            }
            validate = validateDispatcher.await()
        }

        return validate
    }

    fun validateAge(nextFocus: Boolean = false): Boolean {

        var validate = false

        runBlocking {
            val validateDispatcher = async {
                validate(_validationAge, inputAge.value!!, nextFocus)
            }
            validate = validateDispatcher.await()
        }

        return validate
    }
}