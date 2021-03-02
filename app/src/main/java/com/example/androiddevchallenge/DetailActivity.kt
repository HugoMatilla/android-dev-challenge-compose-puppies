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

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.Dog
import com.example.androiddevchallenge.data.dogs
import com.example.androiddevchallenge.data.findByName
import com.example.androiddevchallenge.ui.common.Chips
import com.example.androiddevchallenge.ui.common.DetailMessage
import com.example.androiddevchallenge.ui.common.DetailNotice
import com.example.androiddevchallenge.ui.common.DetailSubtitle
import com.example.androiddevchallenge.ui.common.DetailTitle
import com.example.androiddevchallenge.ui.theme.AppTheme

class DetailActivity : AppCompatActivity() {
    companion object {
        const val NAME = "Name"
        fun start(caller: Activity, name: String) {
            val intent = Intent(caller, this::class.java.declaringClass)
            intent.putExtra(NAME, name)
            caller.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme() {
                Detail()
            }
        }
    }

    // Start building your app here!
    @Composable
    fun Detail() {
        val dog = dogs.findByName(intent.getStringExtra(NAME) ?: "")
        if (dog != null)
            Scaffold(content = { DetailContent(dog) })
        else
            Column(verticalArrangement = Arrangement.Center) {
                Text(text = "No dogs with this name")
            }
    }

    @Composable
    fun DetailContent(dog: Dog) {
        Box(Modifier.fillMaxHeight()) {
            Column(
                verticalArrangement = Arrangement.Top,
                modifier = Modifier.fillMaxHeight()
            ) {
                HeaderImage(dog)
                Column(
                    modifier = Modifier
                        .padding(12.dp)
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    DetailTitle(title = dog.name)
                    DetailSubtitle(title = dog.breed)
                    DetailMessage(title = dog.message)
                    Chips(dog.tops)
                    DetailNotice(title = "A house is not a home until there’s a dog in it. \nAdopt a shelter dog.")
                    Button(
                        onClick = { onButtonClick() },
                        modifier = Modifier.fillMaxWidth(),
                        content = { Text("Adopt ${dog.name}") }
                    )
                }
            }
        }
    }

    private fun onButtonClick() {
        Toast.makeText(this, "❤️ Thank you! 🐶", Toast.LENGTH_SHORT).show()
    }

    @Composable
    fun HeaderImage(dog: Dog) {
        Image(
            painter = painterResource(dog.imageId),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .clip(
                    shape = RoundedCornerShape(
                        topStartPercent = 0,
                        topEndPercent = 0,
                        bottomStartPercent = 20,
                        bottomEndPercent = 20,
                    )
                ),
            contentScale = ContentScale.Crop
        )
    }

    @Preview("Light Theme", widthDp = 360, heightDp = 640)
    @Composable
    fun LightPreview() {
        AppTheme {
            Detail()
        }
    }
}
