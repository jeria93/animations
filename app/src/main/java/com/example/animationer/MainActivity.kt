package com.example.animationer

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.animation.BounceInterpolator
import android.view.animation.OvershootInterpolator
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.animationer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.buttonAnimate.setOnClickListener {
//            animate1()
//            animateBounce()
//            animateOvershoot()
//            animateDrop()
//            animateBackgroundColor()
//            animateScroll()
            animateJump()
        }

    }

    private fun animate1() {
        val orientation = ObjectAnimator.ofFloat(binding.tvText, "rotation", 0f, 360f)
        orientation.duration = 500
        orientation.start()
    }

    private fun animateTranslation() {
        val move = ObjectAnimator.ofFloat(binding.tvText, "translationX", 0f, 200f)
        move.duration = 500
        move.start()
    }

    private fun animateAlpha() {
        val move = ObjectAnimator.ofFloat(binding.tvText, "alpha", 1f, 0f)
        move.duration = 500
        move.start()
    }

    private fun animateBackgroundColor() {
        val colorAnimator = ObjectAnimator.ofArgb(binding.tvText, "backgroundColor", 0xFF8BC34A.toInt(), 0xFFFF5722.toInt())
        colorAnimator.duration = 1000
        colorAnimator.start()
    }

    private fun animateBounce() {
        val bounce = ObjectAnimator.ofFloat(binding.tvText, "translationY", 0f, -200f, 0f)
        bounce.duration = 800
        bounce.interpolator = BounceInterpolator()
        bounce.start()
    }

    private fun animateOvershoot() {
        val move = ObjectAnimator.ofFloat(binding.tvText, "translationY", 0f, -300f)
        move.duration = 600
        move.interpolator = OvershootInterpolator()
        move.start()
    }

    private fun animateFlip() {
        val flip = ObjectAnimator.ofFloat(binding.tvText, "rotationY", 0f, 180f)
        flip.duration = 500
        flip.start()
    }

    private fun animateShake() {
        val shake = ObjectAnimator.ofFloat(binding.tvText, "translationX", 0f, 25f, -25f, 25f, 0f)
        shake.duration = 500
        shake.start()
    }

    private fun animateDrop() {
        binding.tvText.translationY = -1000f
        val drop = ObjectAnimator.ofFloat(binding.tvText, "translationY", -1000f, 0f)
        drop.duration = 800
        drop.start()
    }

    private fun animateElastic() {
        val stretch = ObjectAnimator.ofFloat(binding.tvText, "scaleY", 1f, 1.3f, 1f)
        stretch.duration = 500
        stretch.interpolator = OvershootInterpolator()
        stretch.start()
    }

    private fun animateFadeIn() {
        val fadeIn = ObjectAnimator.ofFloat(binding.tvText, "alpha", 0f, 1f)
        fadeIn.duration = 500
        fadeIn.start()
    }

    private fun animateScroll() {
        val scroll = ObjectAnimator.ofFloat(binding.tvText, "translationX", 0f, 500f)
        scroll.duration = 1000
        scroll.repeatCount = ObjectAnimator.INFINITE
        scroll.repeatMode = ObjectAnimator.REVERSE
        scroll.start()
    }

    private fun animateJump() {
        val jump = ObjectAnimator.ofFloat(binding.tvText, "translationY", 0f, -50f, 0f)
        jump.duration = 400
        jump.repeatCount = ObjectAnimator.INFINITE
        jump.start()
    }






}