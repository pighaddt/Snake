package com.itri.snake

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SankeViewModel : ViewModel(){
    var body = MutableLiveData<List<Position>>()
    var apple = MutableLiveData<Position>()
    var score = MutableLiveData<Int>()
    private var snakeBody = mutableListOf<Position>()

    fun start(){
        snakeBody.apply{
            add(Position(10, 10))
            add(Position(11, 10))
            add(Position(12, 10))
            add(Position(13, 10))
        }
        body.value = snakeBody
    }

    fun reset(){

    }

    fun move(dir : Direction){

    }


}
data class Position(var x : Int, var y : Int)

enum class Direction{
    RIGHT, LEFT, DOWM, TOP
}