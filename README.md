<h1>Toaster</h1>

<p>This library can be used to show the basic / customed toast in android app</p>

<h2>How to use in your app</h2>

dependencies {
   implementation 'com.github.IamAndroidBala:Toaster:V1.0'
}

<h2>Sample usage</h2>

```
Toaster
            .with(this@MainActivity)
            .message("Hello Kotlin")
            .textColor(Color.WHITE)
            .backgroundColor(Color.BLUE)
            .duration(1)
            .isShowInDebugModeOnly(Is_Test_Build)
            .gravity(Gravity.BOTTOM)
            .icon(R.drawable.ic_baseline_info_24)
            .show()
            
            ```
            




