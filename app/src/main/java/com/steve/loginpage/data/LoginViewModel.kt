package com.steve.loginpage.data
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel;

class LoginViewModel : ViewModel() {

    //when user enters name.. we'll update value inside registrationUIState
    var registrationUIState = mutableStateOf(RegistrationUIState())

    fun onEvent(event: UiEvent){
        when(event){
            is UiEvent.FirstNameChanged ->{
                registrationUIState.value = registrationUIState.value.copy(
                    firstName = event.firstName
                )

            }
            is UiEvent.LastNameChanged->{
                registrationUIState.value = registrationUIState.value.copy(
                    lastName = event.lastName
                )


            }
            is UiEvent.EmailChanged->{
                registrationUIState.value = registrationUIState.value.copy(
                    email = event.email
                )


            }
            is UiEvent.PasswordChanged->{
                registrationUIState.value = registrationUIState.value.copy(
                passowrd = event.password
            )


            }

        }


    }


    private val tag = LoginViewModel::class.simpleName

    // to see how we get value form textfields
    private fun printState(){
        Log.d(tag ,"inside_printState")
        Log.d(tag ,registrationUIState.value.toString())

    }

}
