package com.example.socialapp.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.socialapp.R

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