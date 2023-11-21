package com.steve.loginpage.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.steve.loginpage.R
import com.steve.loginpage.ui.theme.Primary
import com.steve.loginpage.ui.theme.TextColor

// This is fo type of text and their Props
@Composable
// These are simply being used in SignUp.kt
fun NormalTextComponent(value: String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        )
        , color = TextColor,
        textAlign = TextAlign.Center// We can use it from colors or ||
        //                                                          \/
        //                                                          
    )
}


@Composable
fun HeadingTextComponent(value: String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth(),
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        ),
        color = TextColor,
        textAlign = TextAlign.Center
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField(labelValue: String , painterResource: Painter){
    val textVal = remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        label = {Text(text = labelValue)},
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Primary,
            focusedLabelColor = colorResource(id = R.color.primaryColor),
            cursorColor = colorResource(id = R.color.primaryColor)
        ),
        keyboardOptions = KeyboardOptions.Default,
        value  = textVal.value,
        onValueChange = { textVal.value = it },
        //TO add icons
        leadingIcon = {
            Icon(painter = painterResource  , contentDescription ="" )
        }
    )
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyPassField(labelValue: String , painterResource: Painter){
    val password = remember {
        mutableStateOf("")
    }
    val passwordVisible = remember {
        mutableStateOf(false)
    }
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        label = {Text(text = labelValue)},
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Primary,
            focusedLabelColor = colorResource(id = R.color.primaryColor),
            cursorColor = colorResource(id = R.color.primaryColor)
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        value  = password.value,
        onValueChange = { password.value = it },
        //TO add icons
        leadingIcon = {
            Icon(painter = painterResource  , contentDescription ="" )
        },
        trailingIcon = {
            val iconImage =
                if(passwordVisible.value){
                Icons.Filled.Visibility

            }
            else{
                Icons.Filled.VisibilityOff
            }

            var description = if(passwordVisible.value){
                stringResource(id = R.string.hide_password )
            }
            else{
                stringResource(id = R.string.show_password )
            }

            IconButton(onClick = {passwordVisible.value = !passwordVisible.value}){
                Icon(imageVector = iconImage, contentDescription = description)
            } // eye button Logic


        },
        visualTransformation = if(passwordVisible.value ) VisualTransformation.None
        else PasswordVisualTransformation()
    )
}