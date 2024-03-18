package com.example.socialapp.upwork

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
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
import com.example.socialapp.components.UpWorkOutlinedTextFieldCompoNoLeadingIcon
import com.example.socialapp.components.UpWorkPasswordCompo
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val systemUiController = rememberSystemUiController()
            systemUiController.setStatusBarColor(Color.White)
            // A surface container using the 'background' color from the the
            Box(modifier = Modifier.fillMaxSize()) {
                SignupPage()
            }
        }
    }
}

@Composable
fun SignupPage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(vertical = 50.dp, horizontal = 20.dp)
    ) {
        var fullName by remember { mutableStateOf("") }
        var userName by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var phoneNumber by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var confirmPassword by remember { mutableStateOf("") }
        var location by remember { mutableStateOf("") }
        var gender by remember { mutableStateOf("") }
        var dateOfBirth by remember { mutableStateOf("") }

        Text(
            text = "Create your Account",
            modifier = Modifier
                .fillMaxWidth(),
            style = TextStyle(
                color = Color.Black,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.SemiBold,
            )
        )

        Text(
            text = "Please fill your details",
            modifier = Modifier
                .fillMaxWidth(),
            style = TextStyle(
                color = colorResource(id = R.color.gray_light),
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 6.dp)
                    .weight(1f),
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(
                    1.dp,
                    colorResource(id = R.color.gray_light)
                )
            ) {
                UpWorkOutlinedTextFieldCompoNoLeadingIcon(
                    placeholderText = "Full name",
                    value = fullName,
                    onValueChanged = { fullName = it },
                )
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 6.dp)
                    .weight(1f),
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(
                    1.dp,
                    colorResource(id = R.color.gray_light)
                )
            ) {
                UpWorkOutlinedTextFieldCompoNoLeadingIcon(
                    placeholderText = "Username",
                    value = userName,
                    onValueChanged = { userName = it },
                )
            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(
                1.dp,
                colorResource(id = R.color.gray_light)
            )
        ) {
            UpWorkOutlinedTextFieldCompo(
                placeholderText = "Email",
                value = email,
                keyboardType = KeyboardType.Email,
                imageVector = Icons.Outlined.MailOutline,
                leadingIcon = true,
                onValueChanged = { email = it },
            )
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(
                1.dp,
                colorResource(id = R.color.gray_light)
            )
        ) {
            UpWorkOutlinedTextFieldCompo(
                placeholderText = "Phone number",
                value = phoneNumber,
                imageVector = Icons.Outlined.Phone,
                leadingIcon = true,
                keyboardType = KeyboardType.Phone,
                onValueChanged = { phoneNumber = it },
            )
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(
                1.dp,
                colorResource(id = R.color.gray_light)
            )
        ) {
            UpWorkPasswordCompo(
                label = "Password",
                password = password,
                onPasswordChanged = { password = it }
            )
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(
                1.dp,
                colorResource(id = R.color.gray_light)
            )
        ) {
            UpWorkPasswordCompo(
                label = "Confirm Password",
                placeholderText = "Confirm password",
                password = confirmPassword,
                onPasswordChanged = { confirmPassword = it }
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(end = 8.dp)
                    .background(color = Color.White),
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(
                    1.dp,
                    colorResource(id = R.color.gray_light)
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.White),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.globe),
                        contentDescription = "globe",
                        modifier = Modifier
                            .size(32.dp)
                            .padding(start = 8.dp)
                    )

                    TextField(
                        value = "",
                        onValueChange = { },
                        placeholder = { Text(text = "Location", textAlign = TextAlign.Center) },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Next
                        ),
                        modifier = Modifier
                            .height(52.dp)
                            .width(100.dp),

                        enabled = true,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = colorResource(id = R.color.border),
                            unfocusedBorderColor = colorResource(id = R.color.border),
                            disabledBorderColor = colorResource(id = R.color.border),
                        ),
                    )

                    Image(
                        imageVector = Icons.Filled.ArrowDropDown,
                        contentDescription = "globe",
                        modifier = Modifier
                            .padding(end = 4.dp)
                            .size(28.dp)
                    )
                }

            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(start = 8.dp)
                    .background(color = Color.White),
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(
                    1.dp,
                    colorResource(id = R.color.gray_light)
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.White),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.gender),
                        contentDescription = "globe",
                        modifier = Modifier
                            .size(28.dp)
                            .padding(start = 8.dp)
                    )

                    TextField(
                        value = "",
                        onValueChange = { },
                        placeholder = { Text(text = "Gender", textAlign = TextAlign.Center) },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Next
                        ),
                        modifier = Modifier
                            .height(52.dp)
                            .width(100.dp),

                        enabled = true,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = colorResource(id = R.color.border),
                            unfocusedBorderColor = colorResource(id = R.color.border),
                            disabledBorderColor = colorResource(id = R.color.border),
                        ),
                    )

                    Image(
                        imageVector = Icons.Filled.ArrowDropDown,
                        contentDescription = "globe",
                        modifier = Modifier
                            .padding(end = 4.dp)
                            .size(28.dp)
                    )
                }

            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White)
                .padding(top = 8.dp),
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(
                1.dp,
                colorResource(id = R.color.gray_light)
            )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    imageVector = Icons.Outlined.CalendarMonth,
                    contentDescription = "globe",
                    modifier = Modifier
                        .size(28.dp)
                        .padding(start = 8.dp)
                )

                TextField(
                    value = "",
                    onValueChange = { },
                    placeholder = {
                        Text(
                            text = "Date of Birth",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    modifier = Modifier
                        .weight(0.7f)
                        .height(52.dp),

                    enabled = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = colorResource(id = R.color.border),
                        unfocusedBorderColor = colorResource(id = R.color.border),
                        disabledBorderColor = colorResource(id = R.color.border),
                    ),
                )

                Image(
                    imageVector = Icons.Filled.ArrowDropDown,
                    contentDescription = "globe",
                    modifier = Modifier
                        .weight(0.1f)
                        .padding(end = 8.dp)
                        .size(28.dp)
                )
            }

        }

        Spacer(modifier = Modifier.height(30.dp))
        val context = LocalContext.current
        UpWorkButton(label = "Sign up") {
            context.startActivity(Intent(context, OtpActivity::class.java))
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
            Text(
                text = "Sign up",
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline,
                fontSize = 15.sp,
                color = colorResource(id = R.color.red),
                modifier = Modifier
                    .clickable {

                    }
            )
        }

    }


}


@Preview(showBackground = true)
@Composable
fun SignupPreview() {
    SignupPage()
}