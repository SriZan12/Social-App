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
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.outlined.KeyOff
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.socialapp.R
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
//                        onForgotPassword()
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


@Composable
fun UpWorkButton(
    label: String,
    onClick: () -> Unit,
) {

    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 14.dp)
            .height(48.dp),
        shape = CircleShape,
        onClick = {
            onClick()
        },
        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.upwork_button)),
        contentPadding = PaddingValues(),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = label,
                fontSize = 20.sp,
                color = Color.White
            )
        }
    }
}

@Composable
fun UpWorkOutlinedTextFieldCompo(
    placeholderText: String,
    value: String,
    imageVector: ImageVector,
    onValueChanged: (String) -> Unit,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    keyboardActions: KeyboardActions = KeyboardActions { },
    keyboardCapitalization: KeyboardCapitalization = KeyboardCapitalization.None,
    enable: Boolean = true,
    leadingIcon: Boolean = true,
) {

    OutlinedTextField(
        value = value,
        onValueChange = { onValueChanged(it) },
        //   label = { Text(text = label) },
        placeholder = { Text(text = placeholderText) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            capitalization = keyboardCapitalization,
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        leadingIcon = {
            if (leadingIcon) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = imageVector,
                        contentDescription = "icon",
                        tint = Color.Gray
                    )
                }
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp)
            .background(color = Color.White),

        keyboardActions = keyboardActions,
        enabled = enable,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colorResource(id = R.color.border),
            unfocusedBorderColor = colorResource(id = R.color.border),
            disabledBorderColor = colorResource(id = R.color.border),
        ),
    )

}

@Composable
fun UpWorkOutlinedTextFieldCompo(
    placeholderText: String,
    value: String,
    leadingIcon: ImageVector,
    trailingIcon: ImageVector,
    onValueChanged: (String) -> Unit,
    onLeadingIconClick: () -> Unit,
    onTrailingIconClick: () -> Unit,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    keyboardActions: KeyboardActions = KeyboardActions { },
    keyboardCapitalization: KeyboardCapitalization = KeyboardCapitalization.None,
    enable: Boolean = true,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = onLeadingIconClick
        ) {
            Icon(
                imageVector = leadingIcon,
                contentDescription = "Leading Icon",
                tint = Color.Gray
            )
        }
        OutlinedTextField(
            value = value,
            onValueChange = { onValueChanged(it) },
            //   label = { Text(text = label) },
            placeholder = { Text(text = placeholderText) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                capitalization = keyboardCapitalization,
                keyboardType = keyboardType,
                imeAction = imeAction
            ),
            modifier = Modifier
                .weight(1f)
                .height(52.dp)
                .background(color = Color.White),

            keyboardActions = keyboardActions,
            enabled = enable,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = colorResource(id = R.color.border),
                unfocusedBorderColor = colorResource(id = R.color.border),
                disabledBorderColor = colorResource(id = R.color.border),
            ),
        )
        IconButton(
            onClick = onTrailingIconClick
        ) {
            Icon(
                imageVector = trailingIcon,
                contentDescription = "Trailing Icon",
                tint = Color.Gray
            )
        }
    }
}


@Composable
fun UpWorkOutlinedTextFieldCompoNoLeadingIcon(
    placeholderText: String,
    value: String,
    onValueChanged: (String) -> Unit,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    keyboardActions: KeyboardActions = KeyboardActions { },
    keyboardCapitalization: KeyboardCapitalization = KeyboardCapitalization.None,
    enable: Boolean = true,
) {

    OutlinedTextField(
        value = value,
        onValueChange = { onValueChanged(it) },
        //   label = { Text(text = label) },
        placeholder = { Text(text = placeholderText, textAlign = TextAlign.Center) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            capitalization = keyboardCapitalization,
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp)
            .background(color = Color.White),

        keyboardActions = keyboardActions,
        enabled = enable,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colorResource(id = R.color.border),
            unfocusedBorderColor = colorResource(id = R.color.border),
            disabledBorderColor = colorResource(id = R.color.border),
        ),
    )

}

@Composable
fun UpWorkOutlinedTextFieldCompoIconsBoth(
    placeholderText: String,
    value: String,
    onValueChanged: (String) -> Unit,
    leadingIcon: Int,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    keyboardActions: KeyboardActions = KeyboardActions { },
    keyboardCapitalization: KeyboardCapitalization = KeyboardCapitalization.None,
    enable: Boolean = true,
) {

    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Image(
            painter = painterResource(id = R.drawable.globe),
            contentDescription = "globe",
            modifier = Modifier
                .size(28.dp)
        )

        OutlinedTextField(
            value = value,
            onValueChange = { onValueChanged(it) },
            //   label = { Text(text = label) },
            placeholder = { Text(text = placeholderText, textAlign = TextAlign.Center) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                capitalization = keyboardCapitalization,
                keyboardType = keyboardType,
                imeAction = imeAction
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
                .background(color = Color.White),

            keyboardActions = keyboardActions,
            enabled = enable,
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
                .size(28.dp)
        )

    }


}


@Composable
fun UpWorkPasswordCompo(
    label: String = stringResource(id = R.string.password),
    placeholderText: String = stringResource(id = R.string.password),
    password: String,
    onPasswordChanged: (String) -> Unit,
    imeAction: ImeAction = ImeAction.Next,
    keyboardActions: KeyboardActions = KeyboardActions { },
) {
    var passwordVisibility: Boolean by remember { mutableStateOf(false) }
    OutlinedTextField(
        value = password,
        onValueChange = { onPasswordChanged(it) },
        singleLine = true,
        placeholder = { Text(text = placeholderText) },
        visualTransformation =
        if (passwordVisibility) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = imeAction
        ),
        keyboardActions = keyboardActions,
        leadingIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Outlined.Lock,
                    contentDescription = "password icon"
                )
            }
        },
        trailingIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                val image = if (passwordVisibility) {
                    Icons.Filled.Key
                } else {
                    Icons.Outlined.KeyOff
                }
                IconButton(onClick = {
                    passwordVisibility = !passwordVisibility
                }) {
                    Icon(
                        imageVector = image,
                        contentDescription = "password icon"
                    )
                }
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp)
            .background(color = Color.White),

        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colorResource(id = R.color.border),
            unfocusedBorderColor = colorResource(id = R.color.border),
        )
    )

}

@Composable
fun ButtonSocialMedia(
    modifier: Modifier = Modifier,
    label: String,
    image: Int,
    backgroundColor: Color,
    textColor: Color = Color.Black,
    isBorder: Boolean = true,
    onClick: () -> Unit
) {

    Card(
        border = if (isBorder) BorderStroke(1.dp, Color.Black) else BorderStroke(
            1.dp,
            color = backgroundColor
        ),
        modifier = Modifier
            .clickable { onClick() }
            .height(64.dp)
            .padding(vertical = 8.dp)
            .background(color = Color.White),
        shape = RoundedCornerShape(8.dp)
    ) {

        Row(
            modifier = modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(color = Color.White),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {

                Image(
                    painter = painterResource(id = image),
                    contentDescription = "Google_logo",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(40.dp)
                        .padding(horizontal = 8.dp)
                )
                Text(
                    text = "Continue with Google",
                    color = textColor,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(end = 20.dp)
                )
            }


        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSignIn() {
    SignInPage()
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    SocialAppTheme {
//        Greeting("Android")
//    }
//}