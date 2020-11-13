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
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.renan.desafioandroid.R
import com.renan.desafioandroid.model.PratoModel


class MenuRestauranteFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu_restaurante, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nomeRestaurante = arguments?.getString("NOME")
        val fotoRestaurante = requireArguments().getInt("FOTO")

        view.findViewById<ImageView>(R.id.imgFotoRestaurante).setImageResource(fotoRestaurante)
        view.findViewById<TextView>(R.id.txtNomeRestaurante).text = nomeRestaurante

        val navController = Navigation.findNavController(view)


        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerPratos)
        val viewManager = GridLayoutManager(view.context, 2)

        val fotoPrato = requireArguments().getInt("FOTO_PRATO")
        val nomePrato = arguments?.getString("NOME_PRATO")
        val cardapioPrato = arguments?.getString("CARDAPIO_PRATO")

        val pratos = arrayListOf<PratoModel>()

        for (i in 0..9) {
            pratos.add(
                PratoModel(fotoPrato, nomePrato!!, cardapioPrato!!)
            )
        }
        val viewAdapter = PratoAdapter(pratos) {
            val bundle = bundleOf(
                "NOME_RESTAURANTE" to nomeRestaurante,
                "FOTO_RESTAURANTE" to fotoRestaurante,
                "FOTO" to it.imgPrato,
                "NOME" to it.nomePrato,
                "CARDAPIO" to it.detalhesPrato
            )

            navController.navigate(R.id.pratoFragment2, bundle)

        }

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

        view.findViewById<ImageButton>(R.id.btnVoltar).setOnClickListener {
            navController.navigate(R.id.homeFragment)
        }


    }


}