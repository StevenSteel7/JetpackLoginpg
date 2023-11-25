package com.steve.loginpage.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steve.loginpage.R
import com.steve.loginpage.components.ButtonComp
import com.steve.loginpage.components.HeadingTextComponent
import com.steve.loginpage.data.SignUpViewModel
import com.steve.loginpage.navigation.Screen
import com.steve.loginpage.navigation.SystemBackButtonHandler
import com.steve.loginpage.navigation.pageRouter

@Composable
fun Homescreen(loginViewModel: SignUpViewModel){
    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        SystemBackButtonHandler {
            pageRouter.navigateTo(Screen.SignUpScreen)
        }

        Column {

            HeadingTextComponent(value = stringResource(id = R.string.homescreen))

            ButtonComp(
                value = stringResource(id = R.string.Signout), onButtonClicked = {
                    loginViewModel.logout()}
                    , isEnabled = true
            )

        }
    }
}

@Preview
@Composable
fun DefaultPreviewOfhome(){
    Homescreen(loginViewModel = SignUpViewModel())
}