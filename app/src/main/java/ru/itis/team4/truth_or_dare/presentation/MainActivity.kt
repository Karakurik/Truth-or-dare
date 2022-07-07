package ru.itis.team4.truth_or_dare.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import ru.itis.team4.truth_or_dare.R
import ru.itis.team4.truth_or_dare.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var controller: NavController
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        controller = (supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment).navController
    }
}
