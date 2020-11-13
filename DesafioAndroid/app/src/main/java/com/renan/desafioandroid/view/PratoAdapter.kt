package com.renan.desafioandroid.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.renan.desafioandroid.R
import com.renan.desafioandroid.model.PratoModel

class PratoAdapter(private val dataset: List<PratoModel>, private val listener : (PratoModel)-> Unit): RecyclerView.Adapter<PratoAdapter.MeuViewHolder>() {

    class MeuViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private val imgRestaurante by lazy { view.findViewById(R.id.imageViewPrato) as ImageView }
        private val txtNomeRestaurante by lazy { view.findViewById(R.id.textViewPrato) as TextView }

        fun bind(restaurante: PratoModel){
            imgRestaurante.setImageResource(restaurante.imgPrato)
            txtNomeRestaurante.text = restaurante.nomePrato
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.prato_items, parent, false)

        return PratoAdapter.MeuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MeuViewHolder, position: Int) {
        val item = dataset[position]
        holder.bind(dataset[position])
        holder.itemView.setOnClickListener { listener(item) }
    }

    override fun getItemCount()= dataset.size



}