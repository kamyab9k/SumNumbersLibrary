package com.example.sumapplication.ui.theme

import android.widget.EditText
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sum_numbers.main.SumNumbers

@Composable
fun InputScreen(
) {
    var firstNumber by remember {
        mutableStateOf("")
    }

    var secondNumber by remember {
        mutableStateOf("")
    }
    var res by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        OutlinedTextField(
            value = firstNumber,
            onValueChange = { firstNumber = it },
            label = {
                Text("Enter first number")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        OutlinedTextField(
            value = secondNumber,
            onValueChange = { secondNumber = it },
            label = {
                Text("Enter second number")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        Button(
            onClick =
            {
                var x = firstNumber.toInt()
                var y = secondNumber.toInt()

                res = SumNumbers().sumTwoNum(x, y).toString()

//                res = (x + y).toString()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(text = "Calculate")
        }
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            " $res",
            fontSize = 32.sp, textAlign = TextAlign.Center, fontWeight = FontWeight.Bold
        )

    }

}
