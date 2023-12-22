package com.lucifer.loginflows

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.lucifer.loginflows.app.PostOfficeApp
import com.lucifer.loginflows.ui.theme.LoginFlowsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PostOfficeApp()
            LoginFlowsTheme {

            }
        }
    }
}
