package org.straccion.project.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.straccion.project.models.Section
import org.straccion.project.models.Theme

@Composable
fun SectionTitle(
    modifier: Modifier = Modifier,
    section: Section,
    alignment: Alignment.Horizontal = Alignment.Start
) {
    val scope = rememberCoroutineScope()
    var titleMargin by remember { mutableStateOf(50.dp) }
    var subTitleMargin by remember { mutableStateOf(50.dp) }

    Column(
        modifier = modifier,
        horizontalAlignment = alignment
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = titleMargin),
            style = TextStyle(
                textAlign = if (alignment == Alignment.CenterHorizontally) TextAlign.Center
                else TextAlign.Start,
                fontWeight = FontWeight.Normal,
                fontSize = 25.sp,
                color = Theme.Primary.color
            ),
            text = section.title
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    end = if (alignment == Alignment.CenterHorizontally) subTitleMargin else 0.dp,
                    start = if (alignment == Alignment.CenterHorizontally) subTitleMargin else 0.dp,
                    top = 0.dp,
                    bottom = 10.dp
                ),
            style = TextStyle(
                textAlign = if (alignment == Alignment.CenterHorizontally) TextAlign.Center
                else TextAlign.Start,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = Theme.Secondary.color
            ),
            text = section.subtitle
        )
        Box(
            modifier = Modifier
                .height(2.dp)
                .width(140.dp)
                .background(Theme.Primary.color)
                .clip(RoundedCornerShape(50.dp))
        )
    }
}