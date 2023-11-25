package com.steve.loginpage.data

data class LoginUIState (

    var email      :String = "",
    var passowrd   :String = "",
    var emailError: Boolean = false,
    var passError: Boolean = false
)