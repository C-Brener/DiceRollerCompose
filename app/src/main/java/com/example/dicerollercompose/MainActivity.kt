package com.example.dicerollercompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dicerollercompose.ui.theme.DiceRollerComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerComposeTheme {
                DiceWithButtonAndImage(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Red)
                        .wrapContentSize(
                            Alignment.Center
                        )
                )
            }
        }
    }
}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    var result: Int by remember { mutableStateOf(1) }
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = getImageDice(result) ), contentDescription = null)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { result = (1..6).random() }) {
            Text(text = stringResource(R.string.roll))
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun DiceWithButtonAndImagePreview() {
    DiceWithButtonAndImage(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    )
}

private fun getImageDice(result:Int): Int {
    return when (result) {
        1 -> {
            R.drawable.dice_1
        }
        2 -> {
            R.drawable.dice_2
        }
        3 -> {
            R.drawable.dice_3
        }
        4 -> {
            R.drawable.dice_4
        }
        5 -> {
            R.drawable.dice_5
        }
        else -> {
            R.drawable.dice_6
        }
    }

}