package com.example.listviewidia

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast

const val FAVORITE_KEY = "FAVORITE_KEY"
class MainActivity : AppCompatActivity() {
    private val cityData = fillCityData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFavorites()
        val cities: ListView = findViewById(R.id.cities)
        val cityAdapter = CityAdapter(cityData)
        cities.adapter = cityAdapter

        cities.setOnItemClickListener { parent, view, position, id ->
            val city:City? = cityAdapter.getItem(position)
            city?.let {
                city.favorite = !city.favorite
                cityAdapter.notifyDataSetChanged()
            }

            saveFavorite()
        }
    }



    private fun saveFavorite() {
        val favorites = cityData.filter { it.favorite }.map { it.country }

        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            putStringSet(FAVORITE_KEY,favorites.toSet())
            commit()
        }
    }

    private fun loadFavorites() {
        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        val favorites = sharedPref.getStringSet(FAVORITE_KEY, null)

        favorites?.forEach { country ->
            val city = cityData.find { it.country == country }
            city?.favorite = true
        }
    }

    private fun fillCityData(): Array<City>{
        return arrayOf(City("Argentina","Buenos Aires"),
            City("Australia","Canberra"),
            City("Austria","Vienna"),
            City("Bangladesh", "Dhaka"),
            City("Belgium", "Brussels")
            )
    }
}