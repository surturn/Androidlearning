@file:OptIn(ExperimentalAnimationGraphicsApi::class)

package com.example.assignments

import android.content.Intent
import android.os.Bundle
import android.text.SpannableString
import android.text.style.ClickableSpan
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.graphics.ExperimentalAnimationGraphicsApi
import androidx.compose.animation.graphics.res.animatedVectorResource
import androidx.compose.animation.graphics.res.rememberAnimatedVectorPainter
import androidx.compose.animation.graphics.vector.AnimatedImageVector
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.assignments.ui.theme.AssignmentsTheme
import androidx.compose.material3.Icon as Icon1

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Login()
        }
    }
}
@Preview(showBackground = true)
@Composable
fun Login ()

{

    val screen = LocalContext.current
    val recovery = LocalContext.current
    val login = LocalContext.current
    var name by remember {
        mutableStateOf(TextFieldValue("")) }
    var email by remember {
        mutableStateOf(TextFieldValue(""))}
    Column(modifier= Modifier
        .fillMaxSize()
        .background(Color.Black),
        horizontalAlignment=Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    )
    {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Timer",
            modifier = Modifier
                .clip(RoundedCornerShape(200.dp)),


            )
        Text(
            text = "Welcome to Market.Place\n" +
                    "Come back with your ID",
            fontSize = 15.sp,
            color = Color.White,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Bold
        )


        TextField(
            value = name, //the variable stored is the value name given
            onValueChange = { name = it },
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color.Red,
                focusedBorderColor = Color.Red,
                unfocusedLabelColor = Color.White,
                focusedLabelColor = Color.White,
                focusedTextColor = Color.Cyan
            ),

            label = { Text(text = "Username") },

            modifier = Modifier.padding(8.dp),
            shape = RoundedCornerShape(6.dp),
            leadingIcon = {
                (Icon(imageVector = Icons.Default.Person, contentDescription = ""))
            }

        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color.Red,
                focusedBorderColor = Color.Red,
                unfocusedLabelColor = Color.White,
                focusedLabelColor = Color.White,

                ),
            label = { Text(text = "Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.padding(8.dp),
            shape = RoundedCornerShape(6.dp),
            leadingIcon = {
                (Icon(imageVector = Icons.Default.Lock, contentDescription = ""))
            }
        )
        Button(
            onClick = { screen.startActivity(Intent(screen, ScreenActivity::class.java)) },
            colors = ButtonDefaults.buttonColors(Color.Red),
            shape = RoundedCornerShape(40.dp)
        ) {
            Text(
                text = "Login",
                fontSize = 15.sp,
                color = Color.White
            )


        }

        Text(
            text = "Forgot your password?",
            modifier = Modifier.clickable {
                recovery.startActivity(
                    Intent(
                        recovery,
                        PasswordRecoveryActivity::class.java
                    )
                )
            },

            fontSize = 15.sp,
            color = Color.Red,
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight.Bold,


            )
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "OR",
            fontSize = 35.sp,
            color = Color.Red,
            fontWeight = FontWeight.Bold,


            )
        Spacer(modifier = Modifier.height(10.dp))

        Row {
            Text(text = "Don't Have an account?")
            Text(text = "Sign Up",
                modifier = Modifier
                    .clickable { login.startActivity(Intent(login, ContentActivity::class.java)) }

            )


        }

    }
}







