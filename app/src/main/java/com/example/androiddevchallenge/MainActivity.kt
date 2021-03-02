/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Brightness4
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.data.dogs
import com.example.androiddevchallenge.ui.ListItem
import com.example.androiddevchallenge.ui.theme.AppTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }

    // Start building your app here!
    @Composable
    fun App() {
        val darkMode = remember { mutableStateOf(true) }
//    AppTheme(darkTheme = darkMode.value) {
        AppTheme(darkTheme = false) {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text(text = "AdoptMe") },
                        actions = {
                            IconButton(onClick = { darkMode.value = !darkMode.value }) {
                                Icon(Icons.Filled.Brightness4, contentDescription = null)
                            }
                        }
                    )
                }
            ) { innerPadding -> Content(innerPadding) }
        }
    }

    @Composable
    fun Content(innerPadding: PaddingValues) {
        Surface(
            modifier = Modifier.padding(innerPadding),
            color = MaterialTheme.colors.background
        ) {
            LazyColumn {
//        item { Text(text = "First item", style = MaterialTheme.typography.h4) }
                for (dog in dogs)
                    item {
                        ListItem(dog, onClick = { showToast(dog.name) })
                    }
//        item { Text(text = "Last item") }
            }
        }
    }

    fun showToast(name: String) {
        DetailActivity.start(this, name)
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show()
    }

    //
    @Preview("Light Theme", widthDp = 360, heightDp = 640)
    @Composable
    fun LightPreview() {
        AppTheme {
            App()
        }
    }

//  @Preview("Dark Theme", widthDp = 360, heightDp = 640)
//  @Composable
//  fun DarkPreview() {
//    MyTheme(darkTheme = true) {
//      MyApp()
//    }
//  }
}
