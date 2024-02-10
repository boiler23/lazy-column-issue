package com.ilyabogdanovich.lazycolumnissue

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MyView() = MyApplicationTheme {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        var currentPage by remember { mutableIntStateOf(0) }
        val pagerState = rememberPagerState(initialPage = currentPage, pageCount = { 2 })
        
        LaunchedEffect(currentPage) {
            pagerState.animateScrollToPage(currentPage)
        }
        
        HorizontalPager(
            pagerState,
            beyondBoundsPageCount = 1,
            userScrollEnabled = false,
        ) { page ->
            when (page) {
                0 -> FirstPage { currentPage = 1 }
                1 -> SecondPage()
            }
        }
    }
}

@Composable
private fun FirstPage(onOpenSecondPage: () -> Unit) = Box(Modifier.fillMaxSize()) {
    Button(onClick = onOpenSecondPage) {
        Text("Open list")
    }
}

@Composable
private fun SecondPage() {
    LazyColumn {
        for (i in 1..100) {
            item(key = i, contentType = i) {
                Text("Item $i", Modifier.fillMaxWidth().padding(8.dp))
            }
        }
    }
}
