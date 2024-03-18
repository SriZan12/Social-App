package com.example.socialapp.upwork

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.socialapp.R
import com.example.socialapp.components.UpWorkButton
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class OtpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val systemUiController = rememberSystemUiController()
            systemUiController.setStatusBarColor(Color.White)
            // A surface container using the 'background' color from the the
            Box(modifier = Modifier.fillMaxSize()) {
                OtpPage()
            }
        }
    }
}

@Composable
fun OtpPage() {
    val verificationCode = remember { mutableStateOf("") }

    val localFocusManager = LocalFocusManager.current
    Surface(
        modifier = Modifier
            .fillMaxSize().pointerInput(Unit) {
                detectTapGestures(onTap = {
                    localFocusManager.clearFocus(true)
                })
            }
            .padding(5.dp),
        shape = RoundedCornerShape(5.dp),
        color = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 50.dp)
        ) {

            val phoneNumber = "980681002874"
            val maskedPhoneNumber = "+${phoneNumber.take(3)}******${phoneNumber.takeLast(2)}"


            Image(
                painter = painterResource(id = R.drawable.returnbutton),
                contentDescription = "return button",
                modifier = Modifier.size(28.dp).clickable {
                }
            )

            Text(
                text = "OTP VERIFICATION",
                modifier = Modifier
                    .fillMaxWidth(),
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                )
            )

            Spacer(modifier = Modifier.height(10.dp))

            AnnotatedStringWithModifications(titleFontSize = 16.sp, subTitleFontSize = 16.sp)

            Spacer(modifier = Modifier.height(20.dp))

            BasicTextField(
                modifier = Modifier.fillMaxWidth(),
                value = verificationCode.value,
                onValueChange = {
                    if (it.length <= 6) {
                        verificationCode.value = it
                    }
                },
                enabled = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                decorationBox = {
                    Row(horizontalArrangement = Arrangement.SpaceAround) {
                        repeat(6) { index ->
//                                    Spacer(modifier = Modifier.width(2.dp))
                            CharView(
                                index = index,
                                text = verificationCode.value,
                                charColor = colorResource(id = R.color.md_grey_500),
                                charSize = 20.sp,
                                containerSize = 25.dp * 2,
                                type = 2,
                                charBackground = colorResource(id = R.color.my_background_color),
                                password = false,
                                passwordChar = "",
                            )
                            Spacer(modifier = Modifier.width(2.dp))
                        }
                    }
                },
            )

            Spacer(modifier = Modifier.height(30.dp))

            UpWorkButton(label = "Verify") {

            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 28.dp), horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    "Didn't receive any code?",
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .clickable {
//                        onForgotPassword()
                        }
                )
                Spacer(modifier = Modifier.padding(horizontal = 3.dp))
                val context = LocalContext.current
                Text(
                    text = "Resend Again",
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

            Text(
                text = "Request new code in 00:30s",
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.gray_light),
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                    }
            )
        }
    }
}

@Composable
private fun CharView(
    index: Int,
    text: String,
    charColor: Color,
    charSize: TextUnit,
    containerSize: Dp,
    type: Int = 1,
    charBackground: Color = Color.Transparent,
    password: Boolean = false,
    passwordChar: String = ""
) {
    val modifier = if (type == 2) {
        Modifier
            .size(containerSize)
            .border(
                width = 1.dp,
                color = charColor,
                shape = MaterialTheme.shapes.medium
            )
//            .padding(bottom = 4.dp)
            .background(charBackground)
    } else Modifier
        .width(containerSize)
        .background(charBackground)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        val char = when {
            index >= text.length -> ""
            password -> passwordChar
            else -> text[index].toString()
        }
        Text(
            text = char,
            color = Color.Black,
            modifier = modifier.wrapContentHeight(),
            style = MaterialTheme.typography.bodyMedium,
            fontSize = charSize,
            textAlign = TextAlign.Center,
        )
        if (type == 1) {
            Spacer(modifier = Modifier.height(2.dp))
            Box(
                modifier = Modifier
                    .background(charColor)
                    .height(1.dp)
                    .width(containerSize)
            )
        }
    }
}


@Composable
fun AnnotatedStringWithModifications(
    modifier: Modifier = Modifier,
    title: String = "Please enter the 6 digit code sent to your phone number",
    subTitle: String = " +974******92",
    lastTitle: String = " for verification please enter the code in below.",
    titleColor: Color = Color.Black,
    subTitleColor: Color = Color.Black,
    titleFontWeight: FontWeight = FontWeight.Normal,
    subTitleFontWeight: FontWeight = FontWeight.Bold,
    titleFontFamily: FontFamily = FontFamily.Default,
    subTitleFontFamily: FontFamily = FontFamily.Default,
    titleFontSize: TextUnit,
    subTitleFontSize: TextUnit
) {
    Text(
        modifier = modifier,
        textAlign = TextAlign.Start,
        text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = titleColor,
                    fontWeight = titleFontWeight,
                    fontFamily = titleFontFamily,
                    fontSize = titleFontSize
                ),
            ) {
                append(title)
            }
            withStyle(
                style = SpanStyle(
                    color = subTitleColor,
                    fontWeight = subTitleFontWeight,
                    fontFamily = subTitleFontFamily,
                    fontSize = subTitleFontSize
                ),
            ) {
                append(subTitle)
            }

            withStyle(
                style = SpanStyle(
                    color = titleColor,
                    fontWeight = titleFontWeight,
                    fontFamily = titleFontFamily,
                    fontSize = titleFontSize
                ),
            ) {
                append(lastTitle)
            }

        },
    )
}


@Preview(showBackground = true)
@Composable
fun PreViewOTP() {
    OtpPage()
}