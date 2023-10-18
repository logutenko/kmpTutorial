package com.example.kmm.android

import GamesRepository
import android.os.Bundle
import android.widget.TextView
import androidx.activity.contextaware.withContextAvailable
import androidx.appcompat.app.AppCompatActivity
import di.Inject.instance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gamesRepository = instance<GamesRepository>()
        CoroutineScope(context = Dispatchers.IO).launch {
            val games = gamesRepository.fetchAllGames()
            withContext(Dispatchers.Main) {
                val tv = findViewById<TextView>(R.id.txtGreeting)
                tv.text = "Title: ${games.first().title}"
                println("Test")
            }
        }
    }
}
