package com.example.learnrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CountryAdapter : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    var countryData = arrayOf<Country>()
        set(value){
            field = value
            notifyDataSetChanged()
        }
    class CountryViewHolder (view : View) : RecyclerView.ViewHolder(view) {
        val countryFlag: ImageView = view.findViewById(R.id.imageView)
        val countryName: TextView = view.findViewById(R.id.country_name)
        val capitalCity: TextView = view.findViewById(R.id.country_capital)
    }

    override fun getItemCount() = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {

        val itemLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.country_list,parent,false)

        return CountryViewHolder(itemLayout)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        with(holder) {
            countryFlag.setImageResource(countryData[position].flagId)
            countryName.text = countryData[position].name
            capitalCity.text = countryData[position].capitalCity
        }
    }

    override fun getItemId(position: Int): Long {
        return countryData[position].code.hashCode().toLong()
    }
}