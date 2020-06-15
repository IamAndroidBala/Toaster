package com.android.itoaster

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.Typeface
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.CheckResult
import org.jetbrains.annotations.NotNull
import java.time.Duration

object Toaster {

    lateinit var mActivity : Activity
    lateinit var mMessage : String
    var mDuration : Int = 1
    var mTextColor : Int = Color.WHITE
    var mBackColor : Int = Color.LTGRAY
    lateinit var mToast: Toast

    fun with(activity: Activity): Toaster {
        mActivity = activity
        return this
    }

    fun textColor(color: Int): Toaster {
        mTextColor = color
        return this
    }

    fun backgroundColor(color: Int): Toaster {
        mBackColor = color
        return this
    }

    fun message(msg: String): Toaster {
        mMessage = msg
        return this
    }

    fun duration(duration: Int): Toaster {
        mDuration = duration
        return this
    }

    fun show() {

        mActivity.runOnUiThread {

            mToast = Toast.makeText(mActivity.applicationContext, mMessage, mDuration)

            val view = mToast.view
            view.background.setColorFilter(mBackColor, PorterDuff.Mode.SRC_IN)

            val text = view.findViewById<TextView>(android.R.id.message)
            text.setTextColor(mTextColor)

            mActivity.runCatching {
                mToast.show()
            }

        }

    }

}