package com.steve.loginpage.data

sealed class UiEvent{
    data class FirstNameChanged(val firstName: String): UiEvent()
    //if user enters first name this event is triggered
    data class LastNameChanged(val lastName: String): UiEvent()
    data class EmailChanged(val email: String): UiEvent()
    data class PasswordChanged(val password: String): UiEvent()




}
