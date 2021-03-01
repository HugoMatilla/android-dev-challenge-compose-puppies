package com.example.androiddevchallenge.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R.drawable
import com.example.androiddevchallenge.data.Dog
import com.example.androiddevchallenge.data.kelly
import com.example.androiddevchallenge.ui.common.Chip
import com.example.androiddevchallenge.ui.common.ListItemMessage
import com.example.androiddevchallenge.ui.common.ListItemSubtitle
import com.example.androiddevchallenge.ui.common.ListItemTitle

@Composable
fun ListItem(dog: Dog, onClick: () -> Unit = {}) {
  BoxWithConstraints(
    modifier = Modifier
      .height(160.dp)
      .fillMaxWidth()
      .padding(8.dp)
      .shadow(elevation = 4.dp, shape = RoundedCornerShape(8.dp))
      .clip(RoundedCornerShape(8.dp))
      .clickable(onClick = { onClick() })
      .background(MaterialTheme.colors.surface)
  ) {
    Row(verticalAlignment = Alignment.CenterVertically) {
      Avatar(dog)
      MainContent(dog)
    }
    Column(
      verticalArrangement = Arrangement.Bottom,
      modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
    ) {
      Chips(dog)
    }
  }
}

@Composable
fun Chips(dog: Dog) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .padding(start = 100.dp),
    horizontalArrangement = Arrangement.SpaceBetween
  ) {
    for (top in dog.tops) {
      Chip(top)
    }
  }
}

@Composable
fun MainContent(dog: Dog) {
  Column(
    verticalArrangement = Arrangement.SpaceBetween,
    modifier = Modifier
      .fillMaxHeight()
      .padding(top = 8.dp)
      .absoluteOffset(x = (-10).dp)
  ) {
    Column(
      verticalArrangement = Arrangement.Top,
      modifier = Modifier.fillMaxWidth()
    ) {
      Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
      ) {
        ListItemTitle(dog.name)
        ListItemSubtitle(dog.breed)
      }
      ListItemMessage(dog.message)
    }
  }

}

@Preview("Light Theme", widthDp = 360)
@Composable
fun PreviewListItem() {
  ListItem(kelly)
}

@Composable
fun Avatar(dog: Dog) {
  Image(
    painter = painterResource(dog.imageId),
    contentDescription = null,
    modifier = Modifier
      .size(180.dp)
      .fillMaxWidth()
      .absoluteOffset(x = (-20).dp)
      .clip(
        shape = RoundedCornerShape(
          topStartPercent = 0,
          topEndPercent = 50,
          bottomStartPercent = 0,
          bottomEndPercent = 50,
        )
      ),
    contentScale = ContentScale.Crop
  )
}