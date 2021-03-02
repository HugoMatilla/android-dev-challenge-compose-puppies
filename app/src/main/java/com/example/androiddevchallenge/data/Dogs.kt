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
package com.example.androiddevchallenge.data

import androidx.annotation.DrawableRes
import com.example.androiddevchallenge.R

data class Dog constructor(
    val name: String,
    val breed: String,
    val message: String,
    val tops: List<String>,
    @DrawableRes val imageId: Int
)

val kelly =
    Dog(
        "Kelly",
        "Mixed",
        "I love sticks, and I will share all my collection with you.",
        listOf("playful", "affectionate", "athletic", "confident"),
        R.drawable.kelly
    )

val jimmy = Dog(
    "Jimmy",
    "Corgy",
    "I'm very sleepy in the morning, so I won't wake you up for the morning walk.",
    listOf("chill", "devoted", "mellow", "outgoing"),
    R.drawable.corgy
)
val cati = Dog(
    "Cati",
    "Labrador",
    "I start kissing once I'm awake, so be ready for the drool in the bed",
    listOf("quiet", "energetic", "friendly", "affectionate"),
    R.drawable.cati
)
val rocky = Dog(
    "Rocky",
    "German Shepherd",
    "I will protect your house but most importantly I will protect your heart",
    listOf("loyal", "clean", "clever", "protective"),
    R.drawable.rocky
)

val mini = Dog(
    "Mini",
    "Dachshund",
    "I might be small in size but my love is at least as big as a Saint Bernard",
    listOf("lovely", "kindhearted", "sensitive", "attentive"),
    R.drawable.mini
)

val dogs = listOf<Dog>(kelly, jimmy, rocky, mini, cati)

fun List<Dog>.findByName(name: String) = dogs.firstOrNull { name == it.name }
