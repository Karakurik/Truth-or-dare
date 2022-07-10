package ru.itis.team4.truth_or_dare.presentation.category_selection

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.itis.team4.truth_or_dare.R
import ru.itis.team4.truth_or_dare.databinding.FragmentCategorySelectionBinding

class CategorySelectionFragment : Fragment(R.layout.fragment_category_selection) {

    private var _binding: FragmentCategorySelectionBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentCategorySelectionBinding.bind(view)

        with (binding) {
            flLiteMode.setOnClickListener {
                // TODO: игра 
            }
            flHardMode.setOnClickListener {
                // TODO: игра 
            }
            btnAddToLm.setOnClickListener {
                findNavController().navigate(
                    R.id.action_categorySelectionFragment_to_questionsAddingFragment,
                    QuestionsAddingFragment.createBundle("lite mode")
                )
            }
            btnAddToHm.setOnClickListener {
                findNavController().navigate(
                    R.id.action_categorySelectionFragment_to_questionsAddingFragment,
                    QuestionsAddingFragment.createBundle("hard mode")
                )
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}