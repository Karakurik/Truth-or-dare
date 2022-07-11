package ru.itis.team4.truth_or_dare.presentation.category_selection

import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.edit
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.itis.team4.truth_or_dare.R
import ru.itis.team4.truth_or_dare.databinding.FragmentQuestionsAddingBinding
import ru.itis.team4.truth_or_dare.presentation.MainActivity.Companion.HARD_MODE_DARE
import ru.itis.team4.truth_or_dare.presentation.MainActivity.Companion.HARD_MODE_TRUTH
import ru.itis.team4.truth_or_dare.presentation.MainActivity.Companion.LITE_MODE_DARE
import ru.itis.team4.truth_or_dare.presentation.MainActivity.Companion.LITE_MODE_TRUTH
import ru.itis.team4.truth_or_dare.presentation.MainActivity.Companion.PREFERENCE
import ru.itis.team4.truth_or_dare.presentation.category_selection.questions.HardDareRepository.hardDareList
import ru.itis.team4.truth_or_dare.presentation.category_selection.questions.HardTruthRepository.hardTruthList
import ru.itis.team4.truth_or_dare.presentation.category_selection.questions.LiteDareRepository.liteDareList
import ru.itis.team4.truth_or_dare.presentation.category_selection.questions.LiteTruthRepository.liteTruthList

class QuestionsAddingFragment : Fragment(R.layout.fragment_questions_adding) {

    private var _binding: FragmentQuestionsAddingBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentQuestionsAddingBinding.bind(view)
        val text = arguments?.getString(KEY)!!

        with (binding) {
            tvTitle.text = "${tvTitle.text} $text"

            btnToTruth.setOnClickListener {
                addQuestion(etQuestion.text.toString(), text, liteTruthList, hardTruthList)
                findNavController().navigateUp()
            }

            btnToDare.setOnClickListener {
                addQuestion(etQuestion.text.toString(), text, liteDareList, hardDareList)
                findNavController().navigateUp()
            }
        }
    }

    companion object {
        private const val KEY = "KEY"
        fun createBundle(text: String) = bundleOf(KEY to text)
    }

    private fun addQuestion(question: String, mode: String, liteSet: MutableSet<String>, hardSet: MutableSet<String>) {
        if (question.isEmpty()){
            Toast.makeText(context, "Добавьте вопрос", Toast.LENGTH_SHORT).show()
        } else {
            if (mode == "lite mode") {
                liteSet.add(question)
                updateSP(liteSet)
            } else {
                hardSet.add(question)
                updateSP(hardSet)
            }
        }
        Toast.makeText(context, "Вопрос успешно добавлен", Toast.LENGTH_SHORT).show()
    }

    private fun updateSP(list: MutableSet<String>) {
        val pref = activity?.getSharedPreferences(PREFERENCE, MODE_PRIVATE)
        pref?.edit {
            when (list) {
                liteTruthList -> putStringSet(LITE_MODE_TRUTH, list)
                liteDareList -> putStringSet(LITE_MODE_DARE, list)
                hardTruthList -> putStringSet(HARD_MODE_TRUTH, list)
                hardDareList -> putStringSet(HARD_MODE_DARE, list)
            }
            commit()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}