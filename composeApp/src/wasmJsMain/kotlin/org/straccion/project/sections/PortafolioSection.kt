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
import org.straccion.project.utils.detectVisibility

@Composable
fun PortafolioSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxHeight()
            .padding(vertical = 50.dp),
        verticalArrangement = Arrangement.Center
    ) {
        PortfolioContent()
    }
}

@Composable
fun PortfolioContent() {
    var isVisible by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.9f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            SectionTitle(
                modifier = Modifier.padding(start = 20.dp),
                section = Section.Portfolio
            )
            Spacer(modifier = Modifier.height(32.dp))
            Box(
                modifier = Modifier.fillMaxWidth()
                    .detectVisibility { newVisibility ->
                        isVisible = newVisibility
                    },
                contentAlignment = Alignment.Center
            ) {
                PortfolioCards(isVisible = isVisible)
            }
        }
    }
}

@Composable
fun PortfolioCards(isVisible: Boolean) {
    val listState = rememberLazyListState()
    val extendedList = List(100) { index -> Portfolio.entries[index % Portfolio.entries.size] }


    // Se ejecuta cada cierto tiempo (en este caso, cada 3 segundos)
    LaunchedEffect(isVisible) {
        if (isVisible) {
            while (true) {
                delay(5000) // Tiempo de espera (en milisegundos)
                val nextIndex = (listState.firstVisibleItemIndex + 1) % extendedList.size
                listState.animateScrollToItem(nextIndex)
            }
        }
    }

    LazyRow(
        state = listState,
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        items(extendedList) { portfolio ->
            PortfolioCard(
                portfolio = portfolio
            )
        }
    }
}

