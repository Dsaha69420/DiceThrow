package edu.temple.dicethrow

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class DieViewModel : ViewModel() {

    var dieSides: Int = 6

    val currentRoll: MutableLiveData<Int> by lazy {
        MutableLiveData(0)
    }

    fun setDieSides(sides: Int) {
        dieSides = sides
    }

    fun throwDie() {
        currentRoll.value = Random.nextInt(1, dieSides + 1)
    }
}