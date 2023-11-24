package com.steve.loginpage.data



// iF USER TAKES ACTION , UI event is triggred and capture it in LoginViewModel and update the UI state
sealed class UiEvent{
    data class FirstNameChanged(val firstName: String): UiEvent()
    //if user enters first name this event is triggered
    data class LastNameChanged(val lastName: String): UiEvent()
    data class EmailChanged(val email: String): UiEvent()
    data class PasswordChanged(val password: String): UiEvent()

    object RegisterButtonClicked : UiEvent()




}
