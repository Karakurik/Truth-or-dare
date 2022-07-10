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
            btnLite.setOnClickListener {
                // TODO: переход на игровой экран с передачей сложности, списка вопросов
            }
            btnHard.setOnClickListener{
                // TODO: переход на игровой экран с передачей сложности, списка вопросов
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}