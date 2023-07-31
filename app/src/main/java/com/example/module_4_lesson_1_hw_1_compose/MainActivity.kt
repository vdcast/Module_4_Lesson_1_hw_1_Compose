package com.example.module_4_lesson_1_hw_1_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toLowerCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.module_4_lesson_1_hw_1_compose.ui.theme.Module_4_Lesson_1_hw_1_ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Module_4_Lesson_1_hw_1_ComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp() {
    val focusManager = LocalFocusManager.current
    val textInfo = remember { mutableStateOf("") }
    val username = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val passwordConfirm = remember { mutableStateOf("") }
    val age = remember { mutableStateOf("") }
    val country = remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(8.dp),
            text = "Hello, bro! :)\nTo register in this App, please fill out the form below.",
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(top = 8.dp, bottom = 16.dp, start = 8.dp, end = 8.dp),
            text = textInfo.value,
            textAlign = TextAlign.Center
        )
        OutlinedTextField(
            value = username.value,
            onValueChange = { username.value = it },
            singleLine = true,
            label = { Text(text = stringResource(id = R.string.username)) },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus() }
            )
        )
        OutlinedTextField(
            value = email.value,
            onValueChange = { email.value = it },
            singleLine = true,
            label = { Text(text = stringResource(id = R.string.email)) },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus() }
            )
        )
        OutlinedTextField(
            value = password.value,
            onValueChange = { password.value = it },
            singleLine = true,
            label = { Text(text = stringResource(id = R.string.password)) },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus() }
            )
        )
        OutlinedTextField(
            value = passwordConfirm.value,
            onValueChange = { passwordConfirm.value = it },
            singleLine = true,
            label = { Text(text = stringResource(id = R.string.password_confirm)) },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus() }
            )
        )
        OutlinedTextField(
            value = age.value,
            onValueChange = { age.value = it },
            singleLine = true,
            label = { Text(text = stringResource(id = R.string.age)) },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Number
            ),
            keyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus() }
            ),

        )
        OutlinedTextField(
            value = country.value,
            onValueChange = { country.value = it },
            singleLine = true,
            label = { Text(text = stringResource(id = R.string.country)) },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus() }
            )
        )
        Button(
            modifier = Modifier
                .padding(8.dp),
            onClick = {
                textInfo.value = DataValidator().checkInput(
                    username = username.value,
                    email = email.value,
                    password = password.value,
                    passwordConfirm = passwordConfirm.value,
                    age = age.value,
                    country = country.value
                )
            }
        ) { Text(text = stringResource(id = R.string.register)) }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Module_4_Lesson_1_hw_1_ComposeTheme {
        MyApp()
    }
}