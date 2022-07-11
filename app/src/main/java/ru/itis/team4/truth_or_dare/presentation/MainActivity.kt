package ru.itis.team4.truth_or_dare.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import ru.itis.team4.truth_or_dare.R
import ru.itis.team4.truth_or_dare.databinding.ActivityMainBinding
import ru.itis.team4.truth_or_dare.presentation.category_selection.questions.HardDareRepository
import ru.itis.team4.truth_or_dare.presentation.category_selection.questions.HardTruthRepository
import ru.itis.team4.truth_or_dare.presentation.category_selection.questions.LiteDareRepository
import ru.itis.team4.truth_or_dare.presentation.category_selection.questions.LiteTruthRepository

class MainActivity : AppCompatActivity() {

    companion object {
        const val PREFERENCE = "PREFERENCE"
        const val FIRST_LAUNCH = "FIRST_LAUNCH"
        const val LITE_MODE_TRUTH = "LITE_MODE_TRUTH"
        const val LITE_MODE_DARE = "LITE_MODE_DARE"
        const val HARD_MODE_TRUTH = "HARD_MODE_TRUTH"
        const val HARD_MODE_DARE = "HARD_MODE_DARE"
    }

    private lateinit var controller: NavController
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        controller = (supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment).navController

        saveQuestionsToSP()
    }

    private fun saveQuestionsToSP() {
        val pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE)
        if (pref.getBoolean(FIRST_LAUNCH, true)) {
            pref.edit {
                putBoolean(FIRST_LAUNCH, false)
                putStringSet(LITE_MODE_TRUTH, LiteTruthRepository.liteTruthList)
                putStringSet(LITE_MODE_DARE, LiteDareRepository.liteDareList)
                putStringSet(HARD_MODE_TRUTH, HardTruthRepository.hardTruthList)
                putStringSet(HARD_MODE_DARE, HardDareRepository.hardDareList)
                commit()
            }
        }
    }
}
