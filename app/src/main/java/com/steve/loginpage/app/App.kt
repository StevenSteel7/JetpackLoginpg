package com.steve.loginpage.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.steve.loginpage.navigation.Screen
import com.steve.loginpage.navigation.pageRouter
import com.steve.loginpage.screens.Login
import com.steve.loginpage.screens.SignUpScreen
import com.steve.loginpage.screens.TermsAndCodition


@Composable
fun theApp(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {   //actually changing the page...
        Crossfade(targetState = pageRouter.currentScreen, label = "") { currentState->
            when(currentState.value){
                is Screen.SignUpScreen ->{ SignUpScreen() }
                is Screen.TermsAndConditionScreen -> { TermsAndCodition() }
                is Screen.Login -> { Login() }
            }
            
        }
    }
}

