package br.com.felippeneves.kotlin_base_project.presentation.view.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.felippeneves.kotlin_base_project.databinding.ActivityUserRegisterBinding
import br.com.felippeneves.kotlin_base_project.presentation.viewmodel.UserRegisterViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserRegisterActivity : AppCompatActivity() {

    private val viewModel: UserRegisterViewModel by viewModel()

    private lateinit var binding: ActivityUserRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}