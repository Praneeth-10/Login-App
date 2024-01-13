package com.lucifer.loginflows.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.lucifer.loginflows.navigation.PostOfficeAppRouter
import com.lucifer.loginflows.navigation.Screen
import com.lucifer.loginflows.screens.LoginScreen
import com.lucifer.loginflows.screens.PrivacyPolicyScreen
import com.lucifer.loginflows.screens.SignUpScreen
import com.lucifer.loginflows.screens.TermsAndConditionsScreen

@Composable
fun PostOfficeApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Crossfade(targetState = PostOfficeAppRouter.currentScreen, label = "Main Cross Fade") { currentState ->
            when(currentState.value){
                is Screen.SignUpScreen ->{
                    SignUpScreen()
                }
                is Screen.TermsAndConditionsScreen -> {
                    TermsAndConditionsScreen()
                }
                is Screen.PrivacyPolicy -> {
                    PrivacyPolicyScreen()
                }

                is Screen.LoginScreen -> {
                    LoginScreen()
                }
            }
        }
    }
}