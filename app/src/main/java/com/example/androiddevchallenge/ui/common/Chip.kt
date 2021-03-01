package com.example.androiddevchallenge.ui.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Chip(text: String) {
  Surface(
    modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
    shape = RoundedCornerShape(12.dp),
    border = BorderStroke(
      width = 1.dp,
      color = MaterialTheme.colors.primary
    )
  ) {
    Text(
      text = text,
      style = MaterialTheme.typography.caption,
      modifier = Modifier.padding(6.dp),
    )
  }
}
//    Icon(Icons.TwoTone.Functions, contentDescription = null)

@Preview
@Composable
fun ChipPreview() {
  Chip("Play")
}