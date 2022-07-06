package ru.itis.team4.truth_or_dare.game_process

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.itis.team4.truth_or_dare.R
import ru.itis.team4.truth_or_dare.databinding.FragmentTaskBinding

class TaskFragment : Fragment(R.layout.fragment_task) {

    private var _binding: FragmentTaskBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentTaskBinding.bind(view)

        with(binding) {
            arguments?.getString(KEY)?.let {
                tvTitle.text = it
            }

            ibCancel.setOnClickListener {
                findNavController().navigate(
                    R.id.action_taskFragment_to_gameProcessFragment
                )
                TODO("отказ выполнять задание - 0 очков или в минус. Как хочешь")
            }

            ibRefresh.setOnClickListener {
                TODO("новый вопрос")
            }

            ibDone.setOnClickListener {
                findNavController().navigate(
                    R.id.action_taskFragment_to_gameProcessFragment
                )
                TODO("задание выполнено - плюс сколько-то очков очков")
            }
        }
    }

    companion object {

        private const val KEY = "title"

        fun createBundle(text: String) = bundleOf(KEY to text)
    }
}