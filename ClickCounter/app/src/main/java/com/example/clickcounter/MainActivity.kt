package com.example.clickcounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuItemCompat
import java.nio.file.Files.size
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val button:Button = findViewById(R.id.button)
//        val imageView:ImageView = findViewById(R.id.imageView)
//
//
//        button.setOnClickListener {
//            var x = Random.nextInt(0,8)
//            val color = intArrayOf(R.color.purple_200,R.color.white,R.color.black,R.color.teal_200,R.color.red,R.color.green,R.color.yellow,R.color.purple_700)
//            val randomColor = color[x]
//            x += 1
//            imageView.setImageResource(randomColor)
//        }
        val searchView : SearchView = findViewById(R.id.search_view_button)
        searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                TODO("Not yet implemented")
                return false
            }

        })
    }
}