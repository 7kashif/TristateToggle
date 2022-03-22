package com.kashif.tristatetoggle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kashif.tristatetoggle.ui.theme.TristateToggleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TristateToggleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TriStateToggle()
                }
            }
        }
    }
}

@Composable
fun TriStateToggle() {
    val states = listOf(
        "State 1",
        "State 2",
        "State 3",
    )
    var selectedOption by remember {
        mutableStateOf(states[1])
    }
    val onSelectionChange = { text: String ->
        selectedOption = text
    }

    Surface(
        shape = RoundedCornerShape(24.dp),
        elevation = 4.dp,
        modifier = Modifier
            .wrapContentSize()
    ) {
        Row(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(24.dp))
                .background(Color.LightGray)
        ) {
            states.forEach { text->
                Text(
                    text = text,
                    color = Color.White,
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(24.dp))
                        .clickable {
                            onSelectionChange(text)
                        }
                        .background(
                            if (text == selectedOption) {
                                Color.Magenta
                            } else {
                                Color.LightGray
                            }
                        )
                        .padding(
                            vertical = 12.dp,
                            horizontal = 16.dp,
                        ),
                )
            }
        }
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "Light Mode"
)
@Composable
fun DefaultPreview() {
    TristateToggleTheme {
        TriStateToggle()
    }
}