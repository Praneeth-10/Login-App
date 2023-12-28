package com.lucifer.loginflows.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lucifer.loginflows.R
import com.lucifer.loginflows.ui.theme.Purple40

@Composable
fun NormalTextComponent(
    value: String,
    modifier: Modifier = Modifier,
    style: TextStyle = TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal,
    ),
) {
    Text(
        text = value,
        modifier = modifier,
        style = style,
        color = colorResource(id = R.color.colorText),
        textAlign = TextAlign.Center
    )
}

@Composable
fun MyTextField(labelValue: String, imageVector: ImageVector) {

    val textValue = remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = labelValue) },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colorResource(id = R.color.colorPrimary),
            focusedLabelColor = colorResource(id = R.color.colorPrimary),
            cursorColor = colorResource(id = R.color.colorPrimary),
            unfocusedContainerColor = Color(0xFFF7F8F8)
        ),
        keyboardOptions = KeyboardOptions.Default,
        value = textValue.value,
        onValueChange = {
            textValue.value = it
        },
        leadingIcon = {
            Image(
                imageVector = imageVector,
                contentDescription = ""
            )
        }
    )
}


@Composable
fun MyPasswordField(labelValue: String, imageVector: ImageVector) {

    val passwordValue = remember {
        mutableStateOf("")
    }

    val passwordVisible = remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = labelValue) },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colorResource(id = R.color.colorPrimary),
            focusedLabelColor = colorResource(id = R.color.colorPrimary),
            cursorColor = colorResource(id = R.color.colorPrimary),
            unfocusedContainerColor = Color(0xFFF7F8F8)
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        value = passwordValue.value,
        onValueChange = {
            passwordValue.value = it
        },
        leadingIcon = {
            Image(
                imageVector = imageVector,
                contentDescription = ""
            )
        },
        trailingIcon = {
            IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                Icon(
                    imageVector = if (passwordVisible.value) {
                        Icons.Filled.Visibility
                    } else {
                        Icons.Outlined.VisibilityOff
                    },
                    contentDescription = if (passwordVisible.value) {
                        stringResource(R.string.show_password)
                    } else {
                        stringResource(R.string.hide_password)
                    }
                )
            }
        },
        visualTransformation =
            if (passwordVisible.value)  VisualTransformation.None
            else PasswordVisualTransformation()
    )
}

@Composable
fun CheckBoxComponent(value: String) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        val checkBoxValue = remember {
            mutableStateOf(false)
        }

        Checkbox(checked = checkBoxValue.value, onCheckedChange = {
            checkBoxValue.value = !checkBoxValue.value
        })

        Spacer(modifier = Modifier.width(10.dp))

    }
}

@Composable
fun ClickableTextComponent(value: String) {

    val initialText = stringResource(id = R.string.by_continuing_you_accept)
    val privacyPolicyText = stringResource(id = R.string.privacy_policy)
    val andText = stringResource(id = R.string.and)
    val termsText = stringResource(id = R.string.terms_of_use)

    val annotatedString = buildAnnotatedString {
        this.append(initialText)
        this.withStyle(style = SpanStyle(color = Purple40)){
            pushStringAnnotation(tag = privacyPolicyText, annotation = privacyPolicyText)
            this.append(privacyPolicyText)
        }

        this.append(andText)
        this.withStyle(style = SpanStyle(color = Purple40)){
            pushStringAnnotation(tag = termsText, annotation = termsText)
            this.append(termsText)
        }
    }

    ClickableText(text = annotatedString, onClick ={offset ->
        annotatedString.getStringAnnotations(offset,offset)
            .firstOrNull()?.also {span ->
                Log.d("ClickableTextComponent", "$span")
            }
    })
}


@Preview
@Composable
fun PrevMyText() {
//    MyTextField(labelValue = "First Name", imageVector = Icons.Outlined.Person)
//    MyPasswordField(labelValue = stringResource(id = R.string.password), imageVector = Icons.Outlined.Lock )
}