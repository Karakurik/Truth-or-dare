package ru.itis.team4.truth_or_dare.game_process

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
            btEnd.setOnClickListener {
                TODO("переход к результатам")
            }
            btTruth.setOnClickListener {
                findNavController().navigate(
                    R.id.action_gameProcessFragment_to_taskFragment,
                    TaskFragment.createBundle(btTruth.text.toString())
                )
            }
            btDare.setOnClickListener{
                findNavController().navigate(
                    R.id.action_gameProcessFragment_to_taskFragment,
                    TaskFragment.createBundle(btDare.text.toString())
                )
            }
            btRandom.setOnClickListener {
                findNavController().navigate(
                    R.id.action_gameProcessFragment_to_taskFragment,
                    TaskFragment.createBundle(getRandomTaskName())
                )
            }
        }
    }

    private fun getRandomTaskName(): String {
        return if ((1..3).random() == 1) {
            binding.btTruth.text.toString()
        } else {
            binding.btDare.text.toString()
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}