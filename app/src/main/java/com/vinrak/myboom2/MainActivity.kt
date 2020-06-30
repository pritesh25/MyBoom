package com.vinrak.myboom2

import android.graphics.Color
import android.os.Bundle
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import com.vinrak.myboom2.boom.KonfettiView
import com.vinrak.myboom2.boom.models.Shape
import com.vinrak.myboom2.boom.models.Size
import java.util.*
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {

    //val colors = intArrayOf(R.color.yellow, R.color.red, R.color.green, R.color.violet)
    val colors = intArrayOf(R.color.yellow, R.color.red)
    val minSpeed: Float = 4f
    val maxSpeed: Float = 7f
    val timeToLive: Long = 2000
    val shapes: Array<Shape> = arrayOf(Shape.Square, Shape.Circle)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewKonfetti = findViewById<KonfettiView>(R.id.viewKonfetti)
        viewKonfetti.setOnClickListener {



            viewKonfetti.build()
                    .addColors(Color.YELLOW, Color.GREEN, Color.MAGENTA, Color.RED, Color.BLUE, Color.CYAN)
                    .setDirection(0.0, 359.0)
                    .setSpeed(minSpeed, maxSpeed)
                    .setFadeOutEnabled(true)
                    .setTimeToLive(timeToLive)
                    .addShapes(Shape.Square, Shape.Circle)
                    .addSizes(Size(12), Size(16, 6f))
                    .setPosition(viewKonfetti.x + viewKonfetti.width / 2, viewKonfetti.y + viewKonfetti.height / 3)
                    .burst(100)
        }

       viewKonfetti.dispatchTouchEvent(MotionEvent.obtain(0, 0, MotionEvent.ACTION_DOWN, 100F, 100F, 0.5f, 5F, 0, 1F, 1F, 0, 0))
        viewKonfetti.dispatchTouchEvent(MotionEvent.obtain(0, 0, MotionEvent.ACTION_UP, 100F, 100F, 0.5f, 5F, 0, 1F, 1F, 0, 0))

        Timer("SettingUp", false).schedule(timeToLive) {
            viewKonfetti.isEnabled = false
        }

    }
}