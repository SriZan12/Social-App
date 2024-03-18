package com.example.socialapp.upwork

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.socialapp.R
import com.example.socialapp.components.ButtonSocialMedia
import com.example.socialapp.components.UpWorkButton
import com.example.socialapp.components.UpWorkOutlinedTextFieldCompo
import com.example.socialapp.components.UpWorkPasswordCompo
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val systemUiController = rememberSystemUiController()
            systemUiController.setStatusBarColor(Color.White)
            // A surface container using the 'background' color from the the
            Box(modifier = Modifier.fillMaxSize()) {
                SignInPage()
            }
        }
    }
}


@Composable
fun SignInPage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 50.dp, horizontal = 20.dp)
    ) {

        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        Text(
            text = "Sign in to your Account",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp, top = 14.dp),
            style = TextStyle(
                color = Color.Black,
                fontSize = 40.sp,
                fontWeight = FontWeight.SemiBold,
            )
        )

        Text(
            text = "Hi welcome back, you've been missed",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 14.dp, vertical = 12.dp),
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = colorResource(id = R.color.gray)
            )
        )

        Spacer(modifier = Modifier.height(34.dp))

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 14.dp)

        ) {

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(
                    1.dp,
                    colorResource(id = R.color.gray_light)
                )
            ) {
                UpWorkOutlinedTextFieldCompo(
                    placeholderText = "Email",
                    keyboardType = KeyboardType.Email,
                    value = email,
                    imageVector = Icons.Outlined.MailOutline,
                    onValueChanged = { email = it }
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(
                    1.dp,
                    colorResource(id = R.color.gray_light)
                )
            ) {
                UpWorkPasswordCompo(password = password,
                    onPasswordChanged = { password = it }
                )
            }

            Spacer(modifier = Modifier.padding(vertical = 8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(1f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start

            ) {

                Text(
                    text = "Forget Password",
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.Underline,
                    color = colorResource(id = R.color.gray),
                    fontSize = 14.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 4.dp)
                        .clickable {
                        },
                    textAlign = TextAlign.End
                )
            }
        }

        Spacer(modifier = Modifier.height(4.dp))


        Spacer(modifier = Modifier.height(40.dp))

        UpWorkButton(label = "Sign in") {

        }


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp, top = 28.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp, horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .width(100.dp)
                        .weight(0.4f)
                        .height(0.8.dp)
                        .background(color = Color.Black)
                ) {

                }

                Text(
                    text = "or continue with",
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.black),
                    fontSize = 14.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 2.dp)
                        .weight(0.5f)
                        .clickable {
                        },
                    textAlign = TextAlign.Center
                )

                Box(
                    modifier = Modifier
                        .width(100.dp)
                        .weight(0.4f)
                        .height(0.8.dp)
                        .background(color = Color.Black)
                ) {

                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            ButtonSocialMedia(
                modifier = Modifier,
                label = "",
                image = R.drawable.google,
                backgroundColor = Color.White,
                onClick = {}

            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp), horizontalArrangement = Arrangement.Center
        ) {
            Text(
                stringResource(id = R.string.dont_have_account),
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                modifier = Modifier
                    .clickable {
                    }
            )
            Spacer(modifier = Modifier.padding(horizontal = 1.dp))
            val context = LocalContext.current
            Text(
                text = "Sign up",
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline,
                fontSize = 15.sp,
                color = colorResource(id = R.color.red),
                modifier = Modifier
                    .clickable {
                        context.startActivity(Intent(context, SignUpActivity::class.java))
                    }
            )
        }
        Spacer(modifier = Modifier.padding(vertical = 12.dp))
    }
}





@Preview(showBackground = true)
@Composable
fun PreviewSignIn() {
    SignInPage()
}
