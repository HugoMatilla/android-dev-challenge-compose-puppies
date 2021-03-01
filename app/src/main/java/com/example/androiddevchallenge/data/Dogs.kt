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
    "I love sticks, and i will share my collection with you.",
    listOf("playful", "affectionate", "athletic", "loyal"),
    R.drawable.kelly
  )

val jimmy = Dog(
  "Jimmy",
  "Corgy",
  "I'm very sleepy in the morning, I wont get you up for the morning walk.",
  listOf("chill", "devoted", "mellow", "patient"),
  R.drawable.corgy
)
val cati = Dog(
  "Cati",
  "Mixed",
  "I will kiss once I wake up, so be ready for the drool",
  listOf("quiet", "energetic", "friendly", "intelligent"),
  R.drawable.cati
)
val rocky = Dog(
  "Rocky",
  "German Sheppard",
  "I protect your house but mostly your heart",
  listOf("loyal", "clean", "clever", "obedient"),
  R.drawable.rocky
)

val mini = Dog(
  "Mini",
  "Dachshund",
  "I might be small in size but my love is at least as big as an elephant",
  listOf("lovely", "kindhearted", "sensitive", "unique"),
  R.drawable.mini
)

val dogs = listOf<Dog>(kelly, jimmy, cati, rocky, mini)

fun List<Dog>.findByName(name: String) = dogs.firstOrNull { name == it.name }

/*
active
affectionate
agile
athletic
brave
bright
chill
chubby
clean
clever
devoted
obedient
loyal
mellow
merry
patient
quiet
energetic
protective
friendly
intelligent
*/