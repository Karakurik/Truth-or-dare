package ru.itis.team4.truth_or_dare.presentation.main_screen

class PlayerRegistration(
    var truthsCount: Int = 0,
    var daresCount: Int = 0,
    var giveUpsCount: Int = 0,
    var points: Int = 0
) {
    private var namePlayer: String? = null

    fun getNamePlayer(): String? {
        return namePlayer
    }

    fun setNamePlayer(namePlayer: String) {
        this.namePlayer = namePlayer
    }
}

