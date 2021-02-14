package com.itri.snake

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.concurrent.fixedRateTimer
import kotlin.random.Random

class SankeViewModel : ViewModel(){
    private lateinit var applePosition: Position
    var body = MutableLiveData<List<Position>>()
    var apple = MutableLiveData<Position>()
    var score = MutableLiveData<Int>()
    var gameState = MutableLiveData<GameState>()
    private var snakeBody = mutableListOf<Position>()
    private var direction = Direction.LEFT
    private var point : Int = 0


    fun start(){
        score.postValue(point)
        snakeBody.apply{
            add(Position(10, 10))
            add(Position(11, 10))
            add(Position(12, 10))
            add(Position(13, 10))
        }
        body.value = snakeBody
        generateApple()
        fixedRateTimer("timer", true, 500, 400){
            var snakeHead = snakeBody!!.first().copy().apply {
                when(direction){
                    Direction.LEFT -> x--
                    Direction.RIGHT -> x++
                    Direction.DOWM -> y++
                    Direction.TOP -> y--
                }
                if ( snakeBody.contains(this) || x < 0 || x >= 20 || y <  0 || y >=  20 ){
                    cancel()
                    gameState.postValue(GameState.GAME_OVER)
                }
            }
            snakeBody.add(0, snakeHead)
            if (snakeHead != applePosition){
                snakeBody.removeLast()
            }else{
                point+=100
                score.postValue(point)
                generateApple()
            }
            body.postValue(snakeBody)
        }
    }

    fun reset(){
        snakeBody.clear()
        start()
    }

    fun generateApple(){
        do {
            applePosition = Position(Random.nextInt(20), Random.nextInt(20))
        }while (snakeBody.contains(applePosition))
        apple.postValue(applePosition)
    }

    fun move(dir : Direction){
        direction = dir
    }


}
data class Position(var x : Int, var y : Int)

enum class Direction{
    RIGHT, LEFT, DOWM, TOP
}
enum class GameState{
    GAME_OVER, GAME_GOING
}