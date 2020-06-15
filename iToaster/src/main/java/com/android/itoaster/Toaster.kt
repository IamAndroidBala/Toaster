package com.android.itoaster

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.Typeface
import android.util.Log
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.CheckResult
import org.jetbrains.annotations.NotNull
import java.time.Duration

object Toaster {

    private  var mIcon              = 0
    private var mDuration           = Toast.LENGTH_LONG
    private var mTextColor          = Color.WHITE
    private var mBackColor          = Color.LTGRAY
    private lateinit var mToast     : Toast
    private var mGravity            = Gravity.CENTER
    private var isTestBuild         = true
    private lateinit var mMessage   : String

    private lateinit var mActivity  : Activity

    @NotNull
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

    fun isShowInDebugModeOnly(isDebugBuild: Boolean) : Toaster {
        isTestBuild = isDebugBuild
        return this
    }

    fun gravity(gravity: Int) : Toaster {
        mGravity = gravity
        return this
    }

    fun icon(icon: Int): Toaster {
        mIcon = icon
        return this
    }

    fun show() {

        if (isTestBuild)
            mActivity.runOnUiThread {

                mToast = Toast.makeText(mActivity.applicationContext, mMessage, mDuration)
                mToast.setGravity(  mGravity,0,0)

                val view = mToast.view
                view.background.setColorFilter(mBackColor, PorterDuff.Mode.SRC_IN)

                val mTextView = view.findViewById<TextView>(android.R.id.message)
                mTextView.setTextColor(mTextColor)
                mTextView.gravity = Gravity.CENTER

                if(mIcon != 0) {
                    mTextView.setCompoundDrawablesWithIntrinsicBounds(mIcon, 0, 0, 0);
                    mTextView.compoundDrawablePadding = mActivity.resources.getDimensionPixelSize(R.dimen.padding_toast)
                }

                mActivity.runCatching {
                    mToast.show()
                }

            }

    }

}