package ru.itis.team4.truth_or_dare.presentation.game_process

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.itis.team4.truth_or_dare.R
import ru.itis.team4.truth_or_dare.databinding.FragmentGameProcessBinding

class GameProcessFragment : Fragment(R.layout.fragment_game_process){

    private var _binding: FragmentGameProcessBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentGameProcessBinding.bind(view)

        with (binding) {
            btnEnd.setOnClickListener {
                // TODO: "переход к результатам"
            }
            btnTruth.setOnClickListener {
                findNavController().navigate(
                    R.id.action_gameProcessFragment_to_taskFragment,
                    TaskFragment.createBundle(btnTruth.text.toString())
                )
            }
            btnDare.setOnClickListener{
                findNavController().navigate(
                    R.id.action_gameProcessFragment_to_taskFragment,
                    TaskFragment.createBundle(btnDare.text.toString())
                )
            }
            btnRandom.setOnClickListener {
                findNavController().navigate(
                    R.id.action_gameProcessFragment_to_taskFragment,
                    TaskFragment.createBundle(getRandomTaskName())
                )
            }
        }
    }

    private fun getRandomTaskName(): String {
        return if ((1..3).random() == 1) {
            binding.btnTruth.text.toString()
        } else {
            binding.btnDare.text.toString()
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}