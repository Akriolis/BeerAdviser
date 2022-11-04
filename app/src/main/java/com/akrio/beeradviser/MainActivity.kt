package com.akrio.beeradviser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var findBeer: Button
    private lateinit var brands: TextView
    private lateinit var beerColor: Spinner
    private lateinit var color: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findBeer = findViewById(R.id.find_beer)
        brands = findViewById(R.id.brands)
        beerColor = findViewById(R.id.beer_color)

        findBeer.setOnClickListener {
            color = "${beerColor.selectedItem}"
            var beersToRecommend = getBeers(color).reduce { str, item ->
                '\n' + str + '\n' + item
            }
            brands.text = getString(R.string.beer_color, beersToRecommend)

        }
    }

    private fun getBeers(color: String): List<String>{
        return when (color){
            "Light" -> listOf("Jail Pale Ale", "Lager Lite")
            "Amber" -> listOf("Jack Amber", "Red Moose")
            "Brown" -> listOf("Brown Bear Beer", "Bock Brownie")
            else -> listOf("Gout Stout", "Dark Daniel")
        }
    }
}