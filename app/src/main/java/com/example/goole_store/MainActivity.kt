package com.example.goole_store

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.App
import category.Category
import category.CategoryAdapter

class MainActivity : AppCompatActivity() {
    fun randomNum():Int{
        return (0..13).random()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val appNames=arrayOf(
            "Messenger", "Instagram", "Facebook", "WhatsApp", "Netflix",
            "Spotify", "Twitter", "Snapchat", "TikTok", "YouTube",
            "Google Maps", "Gmail", "Pinterest", "Uber",
        )
        val categoryNames= arrayOf(
            "Social Media", "Entertainment", "Productivity", "Games", "Utilities",
            "Health & Fitness", "Education", "Travel", "Music", "Food & Drink",
            "Shopping", "News", "Sports", "Weather"
        )

        val items = arrayListOf<Category>()
        repeat(14) {
            val apps = arrayListOf<App>()
            repeat(7){
                apps.add(App(  resources.getIdentifier("avatar_${randomNum()+1}", "drawable", packageName),appNames[randomNum()],(1..5).random().toString()))
            }
            items.add(
                Category(
              categoryNames[it],
                    apps
            )
            )
        }

        val rcvCategory= findViewById<RecyclerView>(R.id.rcv_category)


        val categoryAdapter:CategoryAdapter=CategoryAdapter(items,this)

        val linearLayoutManager:LinearLayoutManager= LinearLayoutManager(this,RecyclerView.VERTICAL,false)

        rcvCategory.layoutManager= linearLayoutManager
        rcvCategory.adapter=categoryAdapter
    }
}