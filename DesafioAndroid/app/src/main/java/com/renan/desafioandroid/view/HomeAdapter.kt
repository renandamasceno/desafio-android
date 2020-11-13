package com.renan.desafioandroid.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.renan.desafioandroid.R
import com.renan.desafioandroid.model.RestaurantModel

class HomeAdapter(private val dataset: List<RestaurantModel>, private val listener: (RestaurantModel) -> Unit) : RecyclerView.Adapter<HomeAdapter.MeuViewHolder>() {

    class MeuViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val nomeRestaurante by lazy { view.findViewById(R.id.txtRestaurantName) as TextView }
        private val localRestaurante by lazy { view.findViewById(R.id.txtRestaurantLocale) as TextView }
        private val tempoRestaurante by lazy { view.findViewById(R.id.txtRestaurantCloseTime) as TextView }
        private val imgRestaurante by lazy { view.findViewById(R.id.imageHome) as ImageView }

        fun bind(restaurantModel: RestaurantModel){
            nomeRestaurante.text = restaurantModel.nome
            localRestaurante.text = restaurantModel.local
            tempoRestaurante.text = restaurantModel.hora
            imgRestaurante.setImageResource(restaurantModel.imagem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.home_items, parent, false)

        return MeuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MeuViewHolder, position: Int) {
        val item = dataset[position]
        holder.bind(dataset[position])
        holder.itemView.setOnClickListener { listener(item) }
    }

    override fun getItemCount() = dataset.size


}