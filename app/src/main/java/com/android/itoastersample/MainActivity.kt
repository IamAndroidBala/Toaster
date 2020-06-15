package com.android.itoastersample

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import androidx.core.content.ContextCompat
import com.android.itoaster.Toaster

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toaster
            .with(this@MainActivity)
            .message("Hello Kotlin")
            .textColor(Color.WHITE)
            .backgroundColor(Color.GRAY)
            .duration(1)
            .show()

    }

}