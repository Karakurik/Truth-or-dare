package ru.itis.team4.truth_or_dare.presentation.main_screen

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import ru.itis.team4.truth_or_dare.R
import ru.itis.team4.truth_or_dare.databinding.FragmentMainBinding
import ru.itis.team4.truth_or_dare.presentation.game_process.GameProcessFragment
import java.time.Duration

class MainFragment: Fragment(R.layout.fragment_main) {

    private var _adapter: PlayerRegAdapter? = null
    private lateinit var playerList: ArrayList<PlayerRegistration>
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val list = ArrayList<PlayerRegistration>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainBinding.bind(view)

        playerList = populateList()
        _adapter = PlayerRegAdapter(binding.rvMain.context, playerList)
        val adapter: PlayerRegAdapter? = _adapter!!
        binding.rvMain.adapter = adapter
        binding.rvMain.layoutManager = LinearLayoutManager(binding.rvMain.context, LinearLayoutManager.VERTICAL, false)
        binding.btnAdd.setOnClickListener {
            adapter?.newAddedData("")
            adapter?.notifyDataSetChanged()
        }

        binding.btnOnw.setOnClickListener {
            if (playerList.none { player ->
                    player.getNamePlayer().isNullOrEmpty()
                }) {
                GameProcessFragment.players = playerList
                findNavController().navigate(
                    R.id.action_mainFragment_to_categorySelectionFragment
                )
            } else {
                Toast.makeText(context, "Введены не все имена игроков", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun populateList(): ArrayList<PlayerRegistration> {

        for (i in 0..1) {
            val editModel = PlayerRegistration()
            editModel.setNamePlayer("")
            list.add(editModel)
        }
        return list
    }
}