package br.com.felippeneves.kotlin_base_project.presentation.view.screens

import android.content.Context
import android.os.Bundle
import br.com.felippeneves.kotlin_base_project.R
import br.com.felippeneves.kotlin_base_project.databinding.ActivityUserRegisterBinding
import br.com.felippeneves.kotlin_base_project.presentation.viewmodel.UserRegisterViewModel
import br.com.felippeneves.kotlin_base_project.util.BaseActivity
import br.com.felippeneves.kotlin_base_project.util.ValidationResultListener
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserRegisterActivity : BaseActivity() {

    private val context: Context = this

    private val viewModel: UserRegisterViewModel by viewModel()

    private lateinit var binding: ActivityUserRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserRegisterBinding.inflate(layoutInflater)
        binding.viewModel = viewModel
        val view = binding.root
        setContentView(view)
        //
        listFocus = listOf(binding.etFirstName, binding.etLastName, binding.etAge)
        //
        loadingScreen()
    }

    private fun loadingScreen() {

        viewModel.inputFirstName.observe(this@UserRegisterActivity) {
            disableErrorTextInput(binding.tilFirstName)
        }

        viewModel.validationFirstName.observe(this@UserRegisterActivity) {

            when (it.result) {
                ValidationResultListener.SUCESS -> {
                    selectNextFocus(binding.etFirstName)
                }
                ValidationResultListener.EMPTY -> {
                    setFailureEditText(binding.etFirstName, binding.tilFirstName, context.getString(R.string.MsgInformFirstName))
                }
                ValidationResultListener.FAILURE -> {
                    setFailureEditText(binding.etFirstName, binding.tilFirstName, it.erroMessage)
                }
                else -> {
                    setFailureEditText(binding.etFirstName, binding.tilFirstName, context.getString(R.string.MsgUnexpectedError))
                }
            }
        }

        viewModel.inputLastName.observe(this@UserRegisterActivity) {
            disableErrorTextInput(binding.tilLastName)
        }

        viewModel.validationLastName.observe(this@UserRegisterActivity) {

            when (it.result) {
                ValidationResultListener.SUCESS -> {
                    selectNextFocus(binding.etLastName)
                }
                ValidationResultListener.EMPTY -> {
                    setFailureEditText(binding.etLastName, binding.tilLastName, context.getString(R.string.MsgInformLastName))
                }
                ValidationResultListener.FAILURE -> {
                    setFailureEditText(binding.etLastName, binding.tilLastName, it.erroMessage)
                }
                else -> {
                    setFailureEditText(binding.etLastName, binding.tilLastName, context.getString(R.string.MsgUnexpectedError))
                }
            }
        }

        viewModel.inputAge.observe(this@UserRegisterActivity) {
            disableErrorTextInput(binding.tilAge)
        }

        viewModel.validationAge.observe(this@UserRegisterActivity) {

            when (it.result) {
                ValidationResultListener.SUCESS -> {
                    selectNextFocus(binding.etAge)
                }
                ValidationResultListener.EMPTY -> {
                    setFailureEditText(binding.etAge, binding.tilAge, context.getString(R.string.MsgInformAge))
                }
                ValidationResultListener.FAILURE -> {
                    setFailureEditText(binding.etAge, binding.tilAge, it.erroMessage)
                }
                else -> {
                    setFailureEditText(binding.etAge, binding.tilAge, context.getString(R.string.MsgUnexpectedError))
                }
            }
        }

        viewModel.validationAddUser.observe(this@UserRegisterActivity) {

            when (it.result) {
                ValidationResultListener.SUCESS -> {
                    setResult(RESULT_OK)
                    finish()
                }
                ValidationResultListener.FAILURE -> {
                    setFailureEditText(binding.etAge, binding.tilAge, it.erroMessage)
                }
            }
        }
    }
}