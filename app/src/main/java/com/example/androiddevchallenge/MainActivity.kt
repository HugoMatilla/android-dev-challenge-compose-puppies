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
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign.Center
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
        AppTheme {
            Content()
        }
    }

    @Composable
    fun Content() {
        Surface(
            modifier = Modifier.padding(),
            color = MaterialTheme.colors.background
        ) {
            LazyColumn {
                item { ListHeader() }
                for (dog in dogs)
                    item {
                        ListItem(dog, onClick = { showToast(dog.name) })
                    }
                item { Footer() }
            }
        }
    }

    fun showToast(name: String) {
        DetailActivity.start(this, name)
    }

    @Composable
    fun ListHeader() {
        Column(
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth(),
//        .background(MaterialTheme.colors.primaryVariant),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HeaderTitle("AdoptMe")
            Image(
                painter = painterResource(R.drawable.header),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),
                contentScale = ContentScale.Fit
            )
            HeaderSubTitle("The Online Dogs Shelter")
        }
    }

    @Composable
    fun HeaderTitle(title: String, modifier: Modifier = Modifier) {
        Text(
            text = title,
            color = MaterialTheme.colors.primary,
            style = MaterialTheme.typography.h3,
            modifier = modifier,
            textAlign = Center
        )
    }

    @Composable
    fun HeaderSubTitle(title: String, modifier: Modifier = Modifier) {
        Text(
            text = title,
            color = MaterialTheme.colors.primary,
            style = MaterialTheme.typography.h4,
            modifier = modifier,
            textAlign = Center
        )
    }

    @Composable
    fun Footer(modifier: Modifier = Modifier) {
        Column(
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            FooterTitle("If you can't adopt a dog, please consider donating")
            Button(
                onClick = { onDonateClick() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                content = { Text("Donate 5$") }
            )
        }
    }

    private fun onDonateClick() {
        Toast.makeText(this, "❤️ Thank you! 🐶", Toast.LENGTH_SHORT).show()
    }

    @Composable
    fun FooterTitle(title: String, modifier: Modifier = Modifier) {
        Text(
            text = title,
            style = MaterialTheme.typography.h4,
            modifier = modifier,
            textAlign = Center
        )
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
