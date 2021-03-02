package com.example.androiddevchallenge.ui.common

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle.Italic
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ListItemTitle(title: String, modifier: Modifier = Modifier) {
  Text(
    text = title,
    style = MaterialTheme.typography.h4,
    modifier = modifier
  )
}

@Preview
@Composable
fun ListItemTitlePrev() {
  ListItemTitle("Kelly")
}

@Composable
fun ListItemSubtitle(title: String, modifier: Modifier = Modifier) {
  Text(
    text = title,
    style = MaterialTheme.typography.caption,
    modifier = modifier
  )
}

@Preview
@Composable
fun ListItemSubtitlePrev() {
  ListItemSubtitle("Mezcla de razas")
}

@Composable
fun ListItemMessage(title: String, modifier: Modifier = Modifier) {
  Text(
    text = title,
    style = MaterialTheme.typography.body2,
    modifier = modifier,
    fontStyle = Italic
  )
}

@Preview
@Composable
fun ListItemMessagePrev() {
  ListItemMessage("Mezcla de razas")
}