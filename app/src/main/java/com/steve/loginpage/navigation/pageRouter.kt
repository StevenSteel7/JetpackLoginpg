package com.steve.loginpage.navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf




sealed class Screen {
    object SignUpScreen: Screen()
    object TermsAndConditionScreen : Screen()
    object Login : Screen()

    object Homescreen : Screen()


}


object pageRouter {
    val currentScreen : MutableState<Screen> = mutableStateOf(Screen.SignUpScreen) //Default screen

    fun navigateTo(destination : Screen){ // The destination we pass will become the current screen
        //To Navigate to any page
        currentScreen.value = destination
    }

}