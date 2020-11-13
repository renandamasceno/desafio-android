package com.renan.desafioandroid.repository

import com.renan.desafioandroid.R
import com.renan.desafioandroid.model.PratoModel
import com.renan.desafioandroid.model.RestaurantModel


class DataHome {

    companion object {
        val imgRestauranteZero = R.drawable.restaurant0
        val imgRestauranteUm = R.drawable.restaurant1
        val imgRestauranteDois = R.drawable.restaurant2
        val imgRestauranteTres = R.drawable.restaurant3


        val prato0 = PratoModel(
            imgRestauranteZero,
            "Salada com molho Gengibre",
            "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque " +
                    "laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."
        )

        val prato1 = PratoModel(
            imgRestauranteUm,
            "Camarões à moda da casa",
            "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque " +
                    "laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."
        )

        val prato2 = PratoModel(
            imgRestauranteDois,
            "Brunch australiano",
            "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque " +
                    "laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."
        )

        val prato3 = PratoModel(
            imgRestauranteTres,
            "Paella mexicana",
            "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque " +
                    "laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."
        )


        val restaurant = listOf(
            RestaurantModel(
                "Tony Roma's",
                "Av. Lavandisca, 717 - Indianópolis, São Paulo",
                "Fecha às 22:00",
                imgRestauranteZero,
                prato0,
            ),

            RestaurantModel(
                "Ayoama - Moema",
                "Alameda dos Arapanés, 532 - Moema",
                "Fecha às 00:00",
                imgRestauranteUm,
                prato1,
            ),

            RestaurantModel(
                "Outback - Moema",
                "Av. Moaci, 187, 187 - Moema - São Paulo",
                "Fecha às 00:00",
                imgRestauranteDois,
                prato2,
            ),

            RestaurantModel(
                "Sí Señor!",
                "Alameda Jauaperi, 626 - Moema",
                "Fecha às 01:00",
                imgRestauranteTres,
                prato3,
            ),
        )
    }

}