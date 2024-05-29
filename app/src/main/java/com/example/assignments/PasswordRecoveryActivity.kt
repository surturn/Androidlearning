package com.example.assignments

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignments.ui.theme.AssignmentsTheme

class PasswordRecoveryActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Recover()

        }
    }
}



@Preview(showBackground = true)
@Composable
fun Recover() {
    var email by remember {
        mutableStateOf(TextFieldValue(""))
    }
    val recovery = LocalContext.current
    LazyColumn(modifier= Modifier
        .fillMaxSize()
        .background(Color.Black),
        horizontalAlignment=Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center


    ) {
        item {
            Column {
                Text(text = "Enter your email so as to receive a verification code sent to you by our tech team",
                    color=Color.White,
                    fontSize = 25.sp,
                    fontFamily = FontFamily.Serif,

                )
                OutlinedTextField(
                    value = email,
                    onValueChange ={email=it},
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color.Red,
                        focusedBorderColor = Color.Red,
                        unfocusedLabelColor = Color.White,
                        focusedLabelColor = Color.White,

                        ),
                    label = { Text(text = "Email")},
                    modifier = Modifier
                        .padding(8.dp)
                        .height(100.dp),
                    shape = RoundedCornerShape(6.dp),
                    leadingIcon={
                        (Icon(imageVector = Icons.Default.Person, contentDescription = ""))
                    },

                )
                Text(text = "Send Code",
                    modifier=Modifier.clickable {
                        recovery.startActivity(
                            Intent(
                                recovery,
                                PasswordRecoveryActivity::class.java))
                    })
            }
        }
    }

}