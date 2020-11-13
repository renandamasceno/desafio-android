package com.renan.desafioandroid.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import com.renan.desafioandroid.R

class PratoFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_prato, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = Navigation.findNavController(view)

        val nomeRestaurante = arguments?.getString("NOME_RESTAURANTE")
        val fotoRestaurante = requireArguments().getInt("FOTO_RESTAURANTE")
        val fotoPrato = requireArguments().getInt("FOTO")
        val nomePrato = arguments?.getString("NOME")
        val cardapioPrato = arguments?.getString("CARDAPIO")

        view.findViewById<ImageView>(R.id.imgFotoPrato).setImageResource(fotoPrato)
        view.findViewById<TextView>(R.id.txtNomePrato).text = nomePrato
        view.findViewById<TextView>(R.id.txtDetalhesPrato).text = cardapioPrato

        view.findViewById<ImageButton>(R.id.btnVoltarPrato).setOnClickListener {
            val bundle = bundleOf(
                "NOME" to nomeRestaurante,
                "FOTO" to fotoRestaurante,
                "FOTO_PRATO" to fotoPrato,
                "NOME_PRATO" to nomePrato,
                "CARDAPIO_PRATO" to cardapioPrato
            )
            navController.navigate(R.id.menuRestauranteFragment, bundle)
        }
    }

}
