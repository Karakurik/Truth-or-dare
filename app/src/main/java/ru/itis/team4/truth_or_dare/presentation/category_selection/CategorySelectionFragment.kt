package ru.itis.team4.truth_or_dare.presentation.category_selection

import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.itis.team4.truth_or_dare.R
import ru.itis.team4.truth_or_dare.databinding.FragmentCategorySelectionBinding
import ru.itis.team4.truth_or_dare.presentation.MainActivity.Companion.HARD_MODE_DARE
import ru.itis.team4.truth_or_dare.presentation.MainActivity.Companion.HARD_MODE_TRUTH
import ru.itis.team4.truth_or_dare.presentation.MainActivity.Companion.LITE_MODE_DARE
import ru.itis.team4.truth_or_dare.presentation.MainActivity.Companion.LITE_MODE_TRUTH
import ru.itis.team4.truth_or_dare.presentation.MainActivity.Companion.PREFERENCE
import ru.itis.team4.truth_or_dare.presentation.game_process.TaskFragment

class CategorySelectionFragment : Fragment(R.layout.fragment_category_selection) {

    private var _binding: FragmentCategorySelectionBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentCategorySelectionBinding.bind(view)

        with (binding) {
            cvLiteMode.setOnClickListener {
                navigateToGameProcess(LITE_MODE_TRUTH, LITE_MODE_DARE)
            }
            cvHardMode.setOnClickListener {
                navigateToGameProcess(HARD_MODE_TRUTH, HARD_MODE_DARE)
            }
            btnAddToLm.setOnClickListener {
                navigateToQuestionAdding("lite mode")
            }
            btnAddToHm.setOnClickListener {
                navigateToQuestionAdding("hard mode")
            }
        }
    }

    private fun navigateToQuestionAdding(mode: String) {
        findNavController().navigate(
            R.id.action_categorySelectionFragment_to_questionsAddingFragment,
            QuestionsAddingFragment.createBundle(mode)
        )
    }

    private fun navigateToGameProcess(truthsKey: String, daresKey: String) {
        val pref = activity?.getSharedPreferences(PREFERENCE, MODE_PRIVATE)!!
        TaskFragment.truthQuestions = pref.getStringSet(truthsKey, emptySet())!!
        TaskFragment.dareQuestions = pref.getStringSet(daresKey, emptySet())!!

        findNavController().navigate(
            R.id.action_categorySelectionFragment_to_gameProcessFragment
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}