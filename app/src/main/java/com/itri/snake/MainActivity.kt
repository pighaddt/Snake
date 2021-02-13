package com.itri.snake

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var sankeViewModel: SankeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sankeViewModel = ViewModelProvider(this).get(SankeViewModel::class.java)
        sankeViewModel.body.observe(this, Observer {
            game_view.snakeBody = it
            game_view.invalidate()
        })

        sankeViewModel.apple.observe(this, Observer {

        })

        sankeViewModel.score.observe(this, Observer {

        })
        sankeViewModel.start()
    }
}