package com.lucifer.loginflows.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
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
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        value = textValue.value,
        onValueChange = {
            textValue.value = it
        },
        leadingIcon = {
            Image(
                imageVector = imageVector,
                contentDescription = ""
            )
        },
        singleLine = true,
        maxLines = 1
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
        if (passwordVisible.value) VisualTransformation.None
        else PasswordVisualTransformation()
    )
}

@Composable
fun CheckBoxComponent(onTextSelected: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        val checkBoxValue = remember {
            mutableStateOf(false)
        }

        Checkbox(checked = checkBoxValue.value, onCheckedChange = {
            checkBoxValue.value = !checkBoxValue.value
        })

        ClickableTextComponent(onTextSelected)

    }
}

@Composable
fun ClickableTextComponent(onTextSelected: (String) -> Unit) {

    val initialText = stringResource(id = R.string.by_continuing_you_accept)
    val privacyPolicyText = stringResource(id = R.string.privacy_policy)
    val andText = stringResource(id = R.string.and)
    val termsText = stringResource(id = R.string.terms_of_use)

    val annotatedString = buildAnnotatedString {
        this.append(initialText)
        this.withStyle(style = SpanStyle(color = Purple40)) {
            pushStringAnnotation(tag = privacyPolicyText, annotation = privacyPolicyText)
            this.append(privacyPolicyText)
        }

        this.append(andText)
        this.withStyle(style = SpanStyle(color = Purple40)) {
            pushStringAnnotation(tag = termsText, annotation = termsText)
            this.append(termsText)
        }
    }

    ClickableText(text = annotatedString, onClick = { offset ->
        annotatedString.getStringAnnotations(offset, offset)
            .firstOrNull()?.also { span ->
                Log.d("ClickableTextComponent", span.item)

                if (span.item == termsText || span.item == privacyPolicyText) {
                    onTextSelected(span.item)
                }
            }
    })
}

@Composable
fun ButtonComponent(value: String) {

    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(48.dp)
                .background(
                    brush = Brush.horizontalGradient(listOf(Color(0xFE7FC0FA), Color(0xFE0088FF))),
                    shape = RoundedCornerShape(50.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = value,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

    }

}

@Composable
fun DividerTextComponent() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = Color.Gray,
            thickness = 1.dp
        )
        Text(modifier = Modifier.padding(8.dp), text = "or", fontSize = 18.sp)
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = Color.Gray,
            thickness = 1.dp
        )
    }
}

@Composable
fun ClickableLoginTextComponent(tryingToLogin: Boolean = true, onTextSelected: (String) -> Unit) {

    val initialText =
        if (tryingToLogin)
            stringResource(id = R.string.already_have_account)
        else
            stringResource(id = R.string.dont_have_account)

    val loginText =
        if (tryingToLogin)
            stringResource(id = R.string.login)
        else
            stringResource(id = R.string.register)


    val annotatedString = buildAnnotatedString {
        this.append(initialText)
        this.withStyle(style = SpanStyle(color = Purple40)) {
            pushStringAnnotation(tag = loginText, annotation = loginText)
            this.append(loginText)
        }
    }

    ClickableText(text = annotatedString,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(18.dp),
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center
        ),
        onClick = { offset ->
            annotatedString.getStringAnnotations(offset, offset)
                .firstOrNull()?.also { span ->
                    Log.d("ClickableTextComponent", span.item)

                    if (span.item == loginText) {
                        onTextSelected(span.item)
                    }
                }
        })
}

@Composable
fun UnderlinedTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
        ),
        color = colorResource(id = R.color.colorGray),
        textAlign = TextAlign.Center,
        textDecoration = TextDecoration.Underline
    )
}

@Preview
@Composable
fun PrevMyText() {
//    MyTextField(labelValue = "First Name", imageVector = Icons.Outlined.Person)
//    MyPasswordField(labelValue = stringResource(id = R.string.password), imageVector = Icons.Outlined.Lock )
}