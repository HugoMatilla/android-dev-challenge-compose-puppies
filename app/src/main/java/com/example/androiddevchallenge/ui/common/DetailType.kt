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
package com.example.androiddevchallenge.ui.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle.Italic
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun DetailTitle(title: String, modifier: Modifier = Modifier) {
    Text(
        text = title,
        style = MaterialTheme.typography.h3,
        modifier = modifier.fillMaxWidth()
    )
}

@Preview
@Composable
fun DetailTitlePrev() {
    ListItemTitle("Kelly")
}

@Composable
fun DetailNotice(title: String, modifier: Modifier = Modifier) {
    Text(
        text = title,
        style = MaterialTheme.typography.body2,
        modifier = modifier,
    )
}

@Preview
@Composable
fun DetailNoticePrev() {
    ListItemSubtitle("Mixed")
}

@Composable
fun DetailMessage(title: String, modifier: Modifier = Modifier) {
    Text(
        text = title,
        style = MaterialTheme.typography.body1,
        modifier = modifier,
        fontStyle = Italic
    )
}

@Composable
fun DetailSubtitle(title: String, modifier: Modifier = Modifier) {
    Text(
        text = title,
        style = MaterialTheme.typography.caption,
        modifier = modifier,
    )
}

@Preview
@Composable
fun DetailMessagePrev() {
    ListItemSubtitle("Mixed")
}
