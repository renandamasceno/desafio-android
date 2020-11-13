package com.renan.desafioandroid.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.Navigation
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.renan.desafioandroid.R


class RegisterFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(view)

        view.findViewById<Button>(R.id.btnRegisterCompleted).setOnClickListener {

            var contador: Int = 0

            val tilName = view.findViewById<TextInputLayout>(R.id.tilName)
            val edtTextName = view.findViewById<TextInputEditText>(R.id.txtName)

            val tilEmail = view.findViewById<TextInputLayout>(R.id.tilEmailResgister)
            val edtEmail = view.findViewById<TextInputEditText>(R.id.txtEmailRegister)

            val tilPassword = view.findViewById<TextInputLayout>(R.id.tilPasswordRegister)
            val edtPassword = view.findViewById<TextInputEditText>(R.id.txtPasswordRegister)

            val tilPasswordRepeat = view.findViewById<TextInputLayout>(R.id.tilPasswordRegisterRepeat)
            val edtPasswordRepeat = view.findViewById<TextInputEditText>(R.id.txtPasswordRegisterRepeat)

            if (edtTextName.text?.isEmpty()!!) {
                tilName.error = "O campo nome não pode estar vazio"
            } else {
                tilName.error = null
                contador++
            }

            if (edtEmail.text?.isEmpty()!!) {
                tilEmail.error = getString(R.string.emailError)
            } else {
                tilEmail.error = null
                contador++
            }

            if (!validaPassword(edtPassword)) {
                tilPassword.error = getString(R.string.passwordError)
            } else {
                tilPassword.error = null
                contador++
            }

            if (!validaPassword(edtPasswordRepeat) || edtPassword.text.toString() != edtPasswordRepeat.text.toString()) {
                tilPasswordRepeat.error = getString(R.string.passwordErrorRepeat)
            } else {
                tilPasswordRepeat.error = null
                contador++
            }

            if(contador>3){
                navController.navigate(R.id.homeFragment)
            }


        }

    }
    private fun validaPassword(text: TextInputEditText): Boolean {
        if (text.text?.isEmpty()!!) {
            return false
        } else return text.text?.length!! >= 8

    }
}