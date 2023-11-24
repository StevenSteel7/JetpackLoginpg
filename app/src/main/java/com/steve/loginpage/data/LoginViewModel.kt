package com.steve.loginpage.data
import android.provider.ContactsContract.CommonDataKinds.Email
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel;
import com.steve.loginpage.data.rules.Validator

class LoginViewModel : ViewModel() {

    //when user enters name.. we'll update value inside registrationUIState
    var registrationUIState = mutableStateOf(RegistrationUIState())
    var allValidationResult = mutableStateOf(false)
    // Same as
    // var allValidationResult = false

    fun onEvent(event: UiEvent){
        when(event){
            is UiEvent.FirstNameChanged ->{
                registrationUIState.value = registrationUIState.value.copy(
                    firstName = event.firstName
                )
                // To validate whenever textfield is changed
                validateDataWithRules()

            }
            is UiEvent.LastNameChanged->{
                registrationUIState.value = registrationUIState.value.copy(
                    lastName = event.lastName
                )
                validateDataWithRules()


            }
            is UiEvent.EmailChanged->{
                registrationUIState.value = registrationUIState.value.copy(
                    email = event.email
                )
                validateDataWithRules()

            }
            is UiEvent.PasswordChanged->{
                registrationUIState.value = registrationUIState.value.copy(
                passowrd = event.password
            )
                validateDataWithRules()
            }
            is UiEvent.RegisterButtonClicked ->{
                signUp()
            }

        }

    }


    private fun signUp(){
        Log.d(tag ,"inside_signUp")
        printState()

        validateDataWithRules() //To call Validator
    }

    private fun validateDataWithRules() {

        val fNameResult = Validator.validateFirstName(//pass firstnme
            fName = registrationUIState.value.firstName
        )
        val lNameResult = Validator.validateLast(
            lName = registrationUIState.value.lastName
        )
        val emailResult = Validator.validateEmail(
            email = registrationUIState.value.email
        )

        val passResult = Validator.validatePassword(
            pass = registrationUIState.value.passowrd
        )

        //update the state form the validation result that we got
        registrationUIState.value = registrationUIState.value.copy(
        firstNameError = fNameResult.status,
        lastNameError = lNameResult.status,
            emailError = emailResult.status,
            passError = passResult.status
        )

        if(fNameResult.status && lNameResult.status && emailResult.status && passResult.status)
        {allValidationResult.value = true}


    }


    private val tag = LoginViewModel::class.simpleName

    // to see how we get value form textfields
    private fun printState(){
        Log.d(tag ,"inside_printState")
        Log.d(tag ,registrationUIState.value.toString())

    }

}
