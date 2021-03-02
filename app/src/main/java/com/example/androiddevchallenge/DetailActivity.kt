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
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.data.dogs
import com.example.androiddevchallenge.data.findByName
import com.example.androiddevchallenge.ui.ListItem
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
            AppTheme {
                Detail()
            }
        }
    }

    // Start building your app here!
    @Composable
    fun Detail() {
        val dog = dogs.findByName(intent.getStringExtra(NAME) ?: "")
        Surface(color = MaterialTheme.colors.background) {
            if (dog != null)
                ListItem(dog, {})
            else
                Text(text = "No dogs with this name")
        }
    }

    @Preview("Light Theme", widthDp = 360, heightDp = 640)
    @Composable
    fun LightPreview() {
        AppTheme {
            Detail()
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
