package com.lucifer.loginflows.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lucifer.loginflows.R
import com.lucifer.loginflows.components.ButtonComponent
import com.lucifer.loginflows.components.MyPasswordField
import com.lucifer.loginflows.components.MyTextField
import com.lucifer.loginflows.components.NormalTextComponent

@Composable
fun LoginScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        color = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalArrangement = Arrangement.Top
        ) {
            NormalTextComponent(
                value = stringResource(id = R.string.hello),
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(18.dp)
            )
            NormalTextComponent(
                value = stringResource(id = R.string.welcome_back),
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    fontStyle = FontStyle.Normal
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(40.dp)
            )

            Spacer(modifier = Modifier.height(40.dp))
            MyTextField(
                labelValue = stringResource(id = R.string.email),
                imageVector = Icons.Outlined.Email
            )

            Spacer(modifier = Modifier.height(20.dp))
            MyPasswordField(
                labelValue = stringResource(id = R.string.password),
                imageVector = Icons.Outlined.Lock
            )

            Spacer(modifier = Modifier.height(80.dp))
            ButtonComponent(value = stringResource(id = R.string.login))
        }

    }
}

@Preview
@Composable
fun PrevLoginScreen() {
    LoginScreen()
}