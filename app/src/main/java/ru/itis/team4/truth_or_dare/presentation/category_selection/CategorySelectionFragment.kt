package ru.itis.team4.truth_or_dare.presentation.category_selection

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.itis.team4.truth_or_dare.R
import ru.itis.team4.truth_or_dare.databinding.FragmentCategorySelectionBinding
import ru.itis.team4.truth_or_dare.presentation.category_selection.questions.HardDareRepository.hardDareList
import ru.itis.team4.truth_or_dare.presentation.category_selection.questions.HardTruthRepository.hardTruthList
import ru.itis.team4.truth_or_dare.presentation.category_selection.questions.LiteDareRepository.liteDareList
import ru.itis.team4.truth_or_dare.presentation.category_selection.questions.LiteTruthRepository.liteTruthList
import ru.itis.team4.truth_or_dare.presentation.game_process.TaskFragment

class CategorySelectionFragment : Fragment(R.layout.fragment_category_selection) {

    private var _binding: FragmentCategorySelectionBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentCategorySelectionBinding.bind(view)

        with (binding) {
            flLiteMode.setOnClickListener {
                navigateToGameProcess(liteTruthList, liteDareList)
            }
            flHardMode.setOnClickListener {
                navigateToGameProcess(hardTruthList, hardDareList)
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

    private fun navigateToGameProcess(truths: MutableSet<String>, dares: MutableSet<String>) {
        findNavController().navigate(
            R.id.action_categorySelectionFragment_to_gameProcessFragment
        )
        TaskFragment.truthQuestions = truths
        TaskFragment.dareQuestions = dares
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}