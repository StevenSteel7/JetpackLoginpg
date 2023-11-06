package com.steve.loginpage.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.steve.loginpage.R
import com.steve.loginpage.components.NormalTextComponent

@Composable
fun SignUpScreen(){

    Surface(
        color = Color.White,
        modifier  = Modifier.fillMaxSize()
    ) {             // using String from strings.xml
        NormalTextComponent(value = stringResource(id = R.string.hello))
    }
}

@Preview
@Composable
fun DefaultPreviewOfSignUp(){
    SignUpScreen()
}