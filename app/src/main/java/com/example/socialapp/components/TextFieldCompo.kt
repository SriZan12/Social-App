package com.example.socialapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.outlined.KeyOff
import androidx.compose.material.icons.outlined.Lock
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.socialapp.R

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
