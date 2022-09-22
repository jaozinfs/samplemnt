package br.com.sodep.minetrackrwrk.experimentals

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ProfileView(firstLetterOfName: String) {
    Column {
        Text(
            modifier = Modifier
                .padding(16.dp)
                .drawBehind {
                    drawCircle(
                        color = Color.Blue,
                        radius = this.size.maxDimension
                    )
                },
            text = "Hello",
        )
    }
}

@Preview
@Composable
fun ProfileViewPreview() {
    ProfileView("s")
}