package com.example.assignments

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignments.ui.theme.AssignmentsTheme

class ContentActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Content()
        }
    }
}



@Preview(showBackground = true)
@Composable
fun Content() {
    val screen= LocalContext.current
    var search by remember {
        mutableStateOf(TextFieldValue(""))
    }
    LazyColumn(modifier=Modifier.fillMaxSize()) {
        item {
            Row {

                ElevatedCard(
                    colors = CardDefaults.cardColors(
                       Color.Red
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 6.dp
                    ),
                    modifier = Modifier
                        .fillMaxWidth()

                )
                {
                    Column(modifier=Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Text(text = "Location")
                        Text(text = "New York, USA",)
                    }
                    OutlinedTextField(value =search,
                        onValueChange ={search=it} ,
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedBorderColor = Color.White,
                            focusedBorderColor = Color.White,
                            unfocusedLabelColor = Color.Black,
                            focusedLabelColor = Color.Black,
                            focusedTextColor = Color.Cyan
                        ),

                        label = { Text(text = "Search") },

                        modifier = Modifier.padding(4.dp),
                        shape = RoundedCornerShape(6.dp),
                        leadingIcon = {
                            (Icon(imageVector = Icons.Default.Search, contentDescription = ""))
                        }
                    )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Column(modifier = Modifier.fillMaxWidth()) {
                Row {
                    Text(text = "#Special for you",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color= Color.Black
                    )
                    Spacer(modifier = Modifier.width(150.dp))
                    Text(text = "see all",
                        color = Color.Red)

                }
                Spacer(modifier = Modifier.height(10.dp))
                Image(painter = painterResource(id = R.drawable.logo), contentDescription = null,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row {
                    Text(text = "Categories",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color= Color.Black
                    )
                    Spacer(modifier = Modifier.width(200.dp))
                    Text(text = "see all",
                        color = Color.Red)
                }

                LazyRow {
                    item {
                        Row {
                            Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
                                Image(painter = painterResource(id =R.drawable.shirt ) , contentDescription = null)
                                Text(text = "Clothes",
                                    color = Color.Black,
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Light)
                            }
                            Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
                                Image(painter = painterResource(id =R.drawable.elec ) , contentDescription = null,
                                    modifier = Modifier
                                        .size(width=300.dp, height = 123.dp )
                                        .clip(RoundedCornerShape(40.dp)))
                                Text(text = "Electronics",
                                    color = Color.Black,
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Light)
                            }
                            Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
                                Image(painter = painterResource(id =R.drawable.shoes ) , contentDescription = null,
                                    modifier = Modifier
                                        .size(width=300.dp, height = 120.dp )
                                        .clip(RoundedCornerShape(40.dp))
                                )
                                Text(text = "Shoes",
                                    color = Color.Black,
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Light)
                            }
                            Column {
                                Image(painter = painterResource(id =R.drawable.watch ) , contentDescription = null,
                                    modifier = Modifier
                                        .size(width=300.dp, height = 120.dp )
                                        .clip(RoundedCornerShape(40.dp)))
                                Text(text = "Watch",
                                    color = Color.Black,
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Light)
                            }

                        }
                    }

                }
                Spacer(modifier = Modifier.height(10.dp))
                Row {
                    Text(text = "Flash Sale",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color= Color.Black
                    )
                    Spacer(modifier = Modifier.width(150.dp))
                    Text(text = "Closing in...",
                        color = Color.Black,
                        fontWeight = FontWeight.Light)
                }
                Row {
                    Button(onClick  = { screen.startActivity(Intent(screen, ScreenActivity::class.java)) },
                        colors = ButtonDefaults.buttonColors(Color.White),
                        shape = RoundedCornerShape(40.dp) )
                    {
                        Text(
                            text = "All",
                            fontSize = 15.sp,
                            color = Color.Black
                        )
                    }
                    Button(onClick ={ screen.startActivity(Intent(screen, ScreenActivity::class.java)) },
                        colors = ButtonDefaults.buttonColors(Color.Red),
                        shape = RoundedCornerShape(40.dp) )
                    {
                        Text(
                            text = "Newest",
                            fontSize = 15.sp,
                            color = Color.Black
                        )

                    }
                    Button(onClick =  { screen.startActivity(Intent(screen, ScreenActivity::class.java)) },
                        colors = ButtonDefaults.buttonColors(Color.White),
                        shape = RoundedCornerShape(40.dp) )
                    {
                        Text(
                            text = "Popular",
                            fontSize = 15.sp,
                            color = Color.Black
                        )
                    }
                    Button(onClick =  { screen.startActivity(Intent(screen, ScreenActivity::class.java)) },
                        colors = ButtonDefaults.buttonColors(Color.White),
                        shape = RoundedCornerShape(40.dp))
                    {
                        Text(
                            text = "Clothes",
                            fontSize = 15.sp,
                            color = Color.Black
                        )
                    }

                }

            }

        }

    }
}
