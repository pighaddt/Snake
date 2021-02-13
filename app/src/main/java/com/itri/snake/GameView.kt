package com.itri.snake

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import java.util.jar.Attributes

class GameView(context: Context, attrs: AttributeSet) : View(context, attrs){

    var snakeBody: List<Position>? = null
    var size = 0
    private var paint = Paint().apply {
        this.color = Color.BLACK
    }
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.run {
            snakeBody?.forEach {
                drawRect(
                    ((it.x)*size).toFloat(), ((it.y)*size).toFloat(),
                    ((it.x+1)*size) -10 .toFloat(), ((it.y+1)*size) - 10.toFloat(), paint)
            }
        }
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        size  = width / 20
    }
}