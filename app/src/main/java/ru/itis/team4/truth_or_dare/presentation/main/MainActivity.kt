package ru.itis.team4.truth_or_dare.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.itis.team4.truth_or_dare.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
    }
}
