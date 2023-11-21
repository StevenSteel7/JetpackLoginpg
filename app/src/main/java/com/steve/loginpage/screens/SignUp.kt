package com.steve.loginpage.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steve.loginpage.R
import com.steve.loginpage.components.CheckBoxComp
import com.steve.loginpage.components.HeadingTextComponent
import com.steve.loginpage.components.MyPassField
import com.steve.loginpage.components.MyTextField
import com.steve.loginpage.components.NormalTextComponent

@Composable
fun SignUpScreen(){

    Surface(
        color = Color.White,
        modifier  = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {             // using String from strings.xml

        //for one below other
        Column(modifier = Modifier.fillMaxSize()){

        NormalTextComponent(value = stringResource(id = R.string.hello))
        HeadingTextComponent(value = stringResource(id = R.string.create_account))

            Spacer(modifier = Modifier.height(20.dp))

            MyTextField(labelValue = stringResource(id = R.string.first_name ),
                    painterResource(id = R.drawable.user_24)
            )

            MyTextField(labelValue = stringResource(id = R.string.last_name),
                painterResource(id = R.drawable.user_24)// for icon
            )

            MyTextField(labelValue = stringResource(id = R.string.email),
                painterResource(id = R.drawable.email_24)
            )

            MyPassField(labelValue = stringResource(id = R.string.pass),
                painterResource(id = R.drawable.baseline_lock_24)
            )

            CheckBoxComp(value = stringResource(id = R.string.terms_and_conditions)
                ,onTextSelected = {

                })


        }

    }
}

@Preview
@Composable
fun DefaultPreviewOfSignUp(){
    SignUpScreen()
}