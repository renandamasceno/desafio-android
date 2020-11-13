package com.renan.desafioandroid.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.renan.desafioandroid.R
import com.renan.desafioandroid.repository.DataHome


class HomeFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerHome)
        val viewManager = LinearLayoutManager(view.context)
        val viewAdapter = HomeAdapter(DataHome.restaurant) {
            val navController = Navigation.findNavController(view)
            val bundle = bundleOf(
                "NOME" to it.nome,
                "FOTO" to it.imagem,
                "FOTO_PRATO" to it.prato.imgPrato,
                "NOME_PRATO" to it.prato.nomePrato,
                "CARDAPIO_PRATO" to it.prato.detalhesPrato
            )
            navController.navigate(R.id.menuRestauranteFragment, bundle)

        }

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

}