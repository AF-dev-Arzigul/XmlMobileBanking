package com.example.maobilebanking.ui.screens.auth.signup

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.get
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.maobilebanking.R
import com.example.maobilebanking.databinding.FragmentSignUpScreenBinding
import com.example.maobilebanking.ui.screens.auth.signup.impl.SignUpScreenViewModelImpl
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_sign_up_screen.*
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.time.Year
import java.util.Calendar


@AndroidEntryPoint
class SignUpScreen : Fragment(R.layout.fragment_sign_up_screen) {

    private val binding: FragmentSignUpScreenBinding by viewBinding()
    private val viewModel: SignUpScreenViewModel by viewModels<SignUpScreenViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var date:Long=0
        binding.btnRegister.setOnClickListener {
            val firstname = binding.inputFirstName.text.toString()
            val lastname = binding.inputLastName.text.toString()
            val dateOfBirth = date.toString()
            val phone = binding.inputPhone.text.toString()
            val password = binding.inputPassword.text.toString()
            val gender =
                if (binding.radioGroup.checkedRadioButtonId == R.id.male_radio_btn) "0" else "1"
            viewModel.register(firstname, lastname, dateOfBirth, phone, password, gender)
        }
        viewModel.message.onEach {
            Toast.makeText(context, it.toString(), Toast.LENGTH_SHORT).show()
        }.launchIn(lifecycleScope)

        viewModel.loading.onEach { isLoading ->
            binding.progress.isVisible = isLoading
        }.launchIn(lifecycleScope)

        calendar.setOnClickListener {
            binding.datePicker.visibility = View.VISIBLE
        }

        val birthDay = Calendar.getInstance()
        binding.datePicker.init(
            birthDay.get(Calendar.YEAR),
            birthDay.get(Calendar.MONTH),
            birthDay.get(Calendar.DAY_OF_MONTH)
        ) { view, year, month, day ->
            val month = month + 1
            date = birthDay.timeInMillis
            binding.inputDateOfBirth.setText("$day/$month/$year")
            binding.datePicker.visibility = View.GONE
        }

    }

}