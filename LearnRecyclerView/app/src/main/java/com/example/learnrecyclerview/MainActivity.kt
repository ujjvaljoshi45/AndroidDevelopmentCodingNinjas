package com.example.learnrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

val countries = arrayOf(Country("in","India","New Delhi",R.drawable.download)
    , Country("bu","Bhutan", "No idea", R.drawable.download)
    , Country("is","Israel","Jerusalem",R.drawable.download)
    , Country("fr", "France","Paris",R.drawable.download)
    , Country("be", "Belgium", "Brussels", R.drawable.download)
    , Country("jp","Japan", "Tokyo",R.drawable.download)
    , Country("sk","South Korea", "Seoul", R.drawable.download)
    , Country("sr","Sri Lanka", "Colombo",R.drawable.download)
)
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val countryList = findViewById<RecyclerView>(R.id.country_list).apply {
            layoutManager = LinearLayoutManager(this@MainActivity)

            adapter = CountryAdapter()
        }

        val showCountries:Button = findViewById(R.id.button)
        showCountries.setOnClickListener {
            (countryList.adapter as CountryAdapter).countryData = countries
        }
    }
}