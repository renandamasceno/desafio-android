package com.renan.desafioandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HomeAdapter(private val dataset: List<Restaurant>) : RecyclerView.Adapter<HomeAdapter.MeuViewHolder>() {

    class MeuViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val nomeRestaurante by lazy { view.findViewById(R.id.txtRestaurantName) as TextView }
        private val localRestaurante by lazy { view.findViewById(R.id.txtRestaurantLocale) as TextView }
        private val tempoRestaurante by lazy { view.findViewById(R.id.txtRestaurantCloseTime) as TextView }
        private val imgRestaurante by lazy { view.findViewById(R.id.imageHome) as ImageView }

        fun bind(restaurant: Restaurant){
            nomeRestaurante.text = restaurant.nome
            localRestaurante.text = restaurant.local
            tempoRestaurante.text = restaurant.hora
            imgRestaurante.setImageResource(restaurant.imagem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.home_items, parent, false)

        return MeuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MeuViewHolder, position: Int) {
        holder.bind(dataset[position])
    }

    override fun getItemCount() = dataset.size


}