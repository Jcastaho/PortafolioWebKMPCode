package org.straccion.project.sections

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import org.straccion.project.components.PortfolioCard
import org.straccion.project.components.SectionTitle
import org.straccion.project.models.Portfolio
import org.straccion.project.models.Section
import org.straccion.project.utils.TamanoAuto

@Composable
fun PortafolioSection() {
    val screenHeight = TamanoAuto()
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(top = 100.dp, start = 25.dp, end = 25.dp),
        verticalArrangement = Arrangement.Center
    ) {
        PortfolioContent()
    }
}

@Composable
fun PortfolioContent() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(bottom = 0.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            SectionTitle(
                section = Section.Portfolio
            )
            Spacer(modifier = Modifier.height(32.dp))
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                PortfolioCards()
            }
        }
    }
}

@Composable
fun PortfolioCards() {
    val listState = rememberLazyListState()
    val extendedList = List(100) { index -> Portfolio.entries[index % Portfolio.entries.size] }

    LazyRow(
        state = listState,
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(extendedList) { portfolio ->
            PortfolioCard(
                portfolio = portfolio
            )
        }
    }
}

