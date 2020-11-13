package com.renan.desafioandroid

import android.os.Bundle

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class LoginFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(view)

        view.findViewById<Button>(R.id.btnLogin).setOnClickListener {

            val tilEmail = view.findViewById<TextInputLayout>(R.id.tilEmail)
            val edtTextEmail = view.findViewById<TextInputEditText>(R.id.editTextEmail)

            val tilPassword = view.findViewById<TextInputLayout>(R.id.tilPassword)
            val edtTextPassword = view.findViewById<TextInputEditText>(R.id.editTextPassword)

            var contador: Int = 0


            if (edtTextEmail.text?.isEmpty()!!) {
                tilEmail.error = getString(R.string.emailError)
            } else {
                tilEmail.error = null
                contador++
            }

            if (!validaPassword(edtTextPassword)) {
                tilPassword.error = getString(R.string.passwordError)
            } else {
                tilPassword.error = null
                contador++
            }

            if(contador>1){
                navController.navigate(R.id.homeFragment)
            }

        }

        view.findViewById<Button>(R.id.btnRegister).setOnClickListener {
            navController.navigate(R.id.registerFragment)
        }
    }

    private fun validaPassword(text: TextInputEditText): Boolean {
        if (text.text?.isEmpty()!!) {
            return false
        } else return text.text?.length!! >= 8

    }
}