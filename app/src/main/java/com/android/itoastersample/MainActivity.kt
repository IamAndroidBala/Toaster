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
            .backgroundColor(Color.DKGRAY)
            .duration(1)
            .isShowInDebugModeOnly(Is_Test_Build)
            .gravity(Gravity.CENTER)
            .icon(R.drawable.ic_baseline_info_24)
            .show()

        Toaster.with(this@MainActivity).message("hey").show()

    }

}