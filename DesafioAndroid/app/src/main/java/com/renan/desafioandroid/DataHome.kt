package com.renan.desafioandroid


class DataHome {

    companion object{
        val imgRestauranteZero = R.drawable.restaurant0
        val imgRestauranteUm = R.drawable.restaurant1
        val imgRestauranteDois = R.drawable.restaurant2
        val imgRestauranteTres = R.drawable.restaurant3

        val restaurant = listOf(
            Restaurant(
                "Tony Roma's",
                "Av. Lavandisca, 717 - Indianópolis, São Paulo",
                "Fecha às 22:00",
                imgRestauranteZero,
            ),

            Restaurant(
                "Ayoama - Moema",
                "Alameda dos Arapanés, 532 - Moema",
                "Fecha às 00:00",
                imgRestauranteUm,
            ),

            Restaurant(
                "Outback - Moema",
                "Av. Moaci, 187, 187 - Moema - São Paulo",
                "Fecha às 00:00",
                imgRestauranteDois,
            ),

            Restaurant(
                "Sí Señor!",
                "Alameda Jauaperi, 626 - Moema",
                "Fecha às 01:00",
                imgRestauranteTres,
            ),)
    }

}