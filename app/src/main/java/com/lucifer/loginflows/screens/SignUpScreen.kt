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
import androidx.compose.material.icons.outlined.Person
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
import com.lucifer.loginflows.components.CheckBoxComponent
import com.lucifer.loginflows.components.ClickableLoginTextComponent
import com.lucifer.loginflows.components.DividerTextComponent
import com.lucifer.loginflows.components.MyPasswordField
import com.lucifer.loginflows.components.MyTextField
import com.lucifer.loginflows.components.NormalTextComponent
import com.lucifer.loginflows.navigation.PostOfficeAppRouter
import com.lucifer.loginflows.navigation.Screen

@Composable
fun SignUpScreen() {
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
                value = stringResource(id = R.string.create_account),
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
                labelValue = stringResource(id = R.string.first_name),
                imageVector = Icons.Outlined.Person
            )

            Spacer(modifier = Modifier.height(20.dp))
            MyTextField(labelValue = stringResource(id = R.string.last_name),
                imageVector = Icons.Outlined.Person)

            Spacer(modifier = Modifier.height(20.dp))
            MyTextField(
                labelValue = stringResource(id = R.string.email),
                imageVector = Icons.Outlined.Email
            )

            Spacer(modifier = Modifier.height(20.dp))
            MyPasswordField(
                labelValue = stringResource(id = R.string.password),
                imageVector = Icons.Outlined.Lock
            )

            Spacer(modifier = Modifier.height(14.dp))
            CheckBoxComponent(onTextSelected = {
                if (it == " Privacy Policy"){
                    PostOfficeAppRouter.navigateTo(Screen.PrivacyPolicy)
                }
                else{
                    PostOfficeAppRouter.navigateTo(Screen.TermsAndConditionsScreen)
                }
            })

            Spacer(modifier = Modifier.height(40.dp))
            ButtonComponent(value = stringResource(id = R.string.register))

            Spacer(modifier = Modifier.height(30.dp))
            DividerTextComponent()

            Spacer(modifier = Modifier.height(1.dp))
            ClickableLoginTextComponent(tryingToLogin = true,onTextSelected = {
                PostOfficeAppRouter.navigateTo(Screen.LoginScreen)
            })

        }


    }
}

@Preview
@Composable
fun PrevSignUpScreen() {
    SignUpScreen()
}