package ru.itis.team4.truth_or_dare.presentation.main_screen

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import ru.itis.team4.truth_or_dare.R

class PlayerRegAdapter(ctx: Context, playerLists: ArrayList<PlayerRegistration>):
    RecyclerView.Adapter<PlayerRegAdapter.PlayerRegHolder>() {

    private val inflater: LayoutInflater
    private val playerList: ArrayList<PlayerRegistration>

    init {
        inflater = LayoutInflater.from(ctx)
        playerList = playerLists
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerRegHolder {
        val view = inflater.inflate(R.layout.item_player, parent, false)
        return PlayerRegHolder(view)
    }

    override fun onBindViewHolder(holder: PlayerRegHolder, position: Int) {
        holder.editText.setText(playerList[position].getNamePlayer())
        Log.d("print", "yes")
        holder.imageButton.setOnClickListener {
            if (playerList.size > 2) {
                playerList.removeAt(position)
                notifyItemRemoved(position)
                notifyItemRangeChanged(position, playerList.size)
            } else {
                (Toast.makeText(holder.editText.context, "Количество игроков минимум 2", Toast.LENGTH_SHORT)).show()
            }
        }
    }

    override fun getItemCount(): Int {
        return playerList.size
    }

    fun newAddedData(playerName: String) {
        val newValue = PlayerRegistration()
        newValue.setNamePlayer(playerName)
        playerList.add(newValue)
    }

    inner class PlayerRegHolder (itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        var editText: EditText
        var imageButton: ImageButton

        init {

            editText = itemView.findViewById(R.id.et_item) as EditText
            imageButton = itemView.findViewById(R.id.imageButton) as ImageButton

            editText.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                }

                override fun beforeTextChanged(charSequence: CharSequence?, start: Int, count: Int, after: Int) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    playerList[bindingAdapterPosition].setNamePlayer(editText.text.toString())
                }
            })
        }
    }
}