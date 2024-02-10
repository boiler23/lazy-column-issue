package com.ilyabogdanovich.lazycolumnissue.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ilyabogdanovich.lazycolumnissue.MyApplicationTheme
import com.ilyabogdanovich.lazycolumnissue.MyView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                MyView()
            }
        }
    }
}
