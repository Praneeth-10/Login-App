package com.lucifer.loginflows.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lucifer.loginflows.R
import com.lucifer.loginflows.components.NormalTextComponent
import com.lucifer.loginflows.navigation.PostOfficeAppRouter
import com.lucifer.loginflows.navigation.Screen
import com.lucifer.loginflows.navigation.SystemBackButtonHandler

@Composable
fun TermsAndConditionsScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize(1f)
            .background(Color.White)
            .padding(16.dp)
    ) {
        NormalTextComponent(
            value = stringResource(id = R.string.terms_and_conditions),
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 34.sp,
                background = Color.Gray
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp)
        )
    }

    SystemBackButtonHandler {
        PostOfficeAppRouter.navigateTo(Screen.SignUpScreen)
    }
}

@Preview
@Composable
fun PrevTermsAndCon() {
    TermsAndConditionsScreen()
}