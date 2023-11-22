package com.steve.loginpage.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.steve.loginpage.R
import com.steve.loginpage.components.AlreadyAMemberComp

import com.steve.loginpage.components.ButtonComp
import com.steve.loginpage.components.DividerTextComp
import com.steve.loginpage.components.HeadingTextComponent
import com.steve.loginpage.components.MyPassField
import com.steve.loginpage.components.MyTextField
import com.steve.loginpage.components.NormalTextComponent
import com.steve.loginpage.navigation.Screen
import com.steve.loginpage.navigation.SystemBackButtonHandler
import com.steve.loginpage.navigation.pageRouter


@Composable
fun Login() {



    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(top = 80.dp)
            .padding(38.dp)



    )

    {

        Column{

            NormalTextComponent(value = stringResource(id = R.string.login))
            Spacer(modifier = Modifier.height(5.dp))
            HeadingTextComponent(value = stringResource(id = R.string.welcome))
            Spacer(modifier = Modifier.height(20.dp))

            MyTextField(labelValue = stringResource(id = R.string.email),
                painterResource(id = R.drawable.email_24)
            )

            MyPassField(labelValue = stringResource(id = R.string.pass),
                painterResource(id = R.drawable.baseline_lock_24)
            )
            Spacer(modifier = Modifier.height(150.dp))

            ButtonComp(value = stringResource(id = R.string.login))
            Spacer(modifier = Modifier.height(40.dp))
            DividerTextComp()
            Spacer(modifier = Modifier.height(10.dp))

            AlreadyAMemberComp(text1 = "Not a Member? " ,text2 = "Signup",onTextSelected = {
                pageRouter.navigateTo(Screen.SignUpScreen)
            }
            )

        }

       /* SystemBackButtonHandler {
            pageRouter.navigateTo(Screen.SignUpScreen)
        }*/

    }



}

@Preview
@Composable
fun DefaultPreviewOfLogin(){
    Login()
}