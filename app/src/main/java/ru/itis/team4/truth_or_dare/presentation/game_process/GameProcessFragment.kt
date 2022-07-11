package ru.itis.team4.truth_or_dare.presentation.game_process

import android.hardware.Sensor
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.itis.team4.truth_or_dare.R
import ru.itis.team4.truth_or_dare.databinding.FragmentGameProcessBinding
import ru.itis.team4.truth_or_dare.presentation.main_screen.PlayerRegistration

class GameProcessFragment : Fragment(R.layout.fragment_game_process) {

    private var _binding: FragmentGameProcessBinding? = null
    private val binding get() = _binding!!

    private var playerPos: Int = -1

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentGameProcessBinding.bind(view)

        if (playerPos == players.size - 1) {
            playerPos = 0
        } else {
            playerPos++
        }

        with (binding) {

            tvPlayerName.text = players[playerPos].getNamePlayer()

            btnEnd.setOnClickListener {
                playerPos--
                findNavController().navigate(
                    R.id.action_gameProcessFragment_to_fragmentResults
                )
            }

            btnTruth.setOnClickListener {
                navigateToTask(btnTruth.text.toString())
            }

            btnDare.setOnClickListener{
                navigateToTask(btnDare.text.toString())
            }

            btnRandom.setOnClickListener {
                findNavController().navigate(
                    R.id.action_gameProcessFragment_to_taskFragment,
                    TaskFragment.createBundle(getRandomTaskInfo())
                )
            }
        }
    }

    private fun navigateToTask(title: String) {
        findNavController().navigate(
            R.id.action_gameProcessFragment_to_taskFragment,
            TaskFragment.createBundle(
                arrayOf(
                    title,
                    "$playerPos"
                )
            )
        )
    }

    companion object {
        var players: ArrayList<PlayerRegistration> = arrayListOf()
    }

    private fun getRandomTaskInfo(): Array<String> {
        return if ((1 until 3).random() == 1) {
            arrayOf(
                binding.btnTruth.text.toString(),
                "$playerPos",
            )
        } else {
            arrayOf(
                binding.btnDare.text.toString(),
                "$playerPos"
            )
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}