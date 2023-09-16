package dev.daviekim.stockwave.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import dev.daviekim.stockwave.common.StockWaveCard
import dev.daviekim.stockwave.common.Constants.companySymbolToName
import dev.daviekim.stockwave.utils.getDayMonthYear
import dev.daviekim.stockwave.viewmodel.StockWaveViewModel
import dev.daviekim.stockwave.viewmodel.state.StockWaveState
import java.util.Locale

@OptIn(ExperimentalAnimationApi::class, ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun HomeScreen(
    viewModel: StockWaveViewModel,
    navController: NavHostController
) {
    val state = viewModel.stockWaveStates

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AutoCompleteBox(
            items = state.searchItemsList,
            query = state.searchString,
            onQueryChange = { newQuery ->
                viewModel.onAction(action = StockWaveViewModel.Action.onSearchStringChanged(newQuery))
            },
            onItemSelected = { selectedItem ->
                viewModel.onAction(action = StockWaveViewModel.Action.onSearchStringChanged(selectedItem))
            },
            onIsSearchingChange = {
                viewModel.onAction(action = StockWaveViewModel.Action.onIsSearchingChanged(it))
            },
            isSearching = state.isSearching,
            cursorPosition = state.searchFieldCursorPosition
        )
        LazyColumn {
            items(state.filteredItemsList) { item ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        companySymbolToName[item.symbol]?.let {
                            StockWaveCard(
                                symbol = item.symbol,
                                name = it,
                                date = item.date.getDayMonthYear(),
                                close = item.close,
                                open = item.open,
                                high = item.high,
                                low = item.low
                            )
                        }
                    }
                }
        }
    }
}

@Composable
fun AutoCompleteBox(
    items: List<String>,
    query: String,
    isSearching: Boolean,
    onQueryChange: (String) -> Unit,
    onItemSelected: (String) -> Unit,
    onIsSearchingChange: (Boolean) -> Unit,
    cursorPosition: Int
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        BasicTextField(
            value = query,
            onValueChange = { newQuery ->
                onQueryChange(newQuery)
                onIsSearchingChange(true)
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    onIsSearchingChange(false)
                }
            ),
            textStyle = LocalTextStyle.current.copy(
                color = Color.Black,
                fontSize = 16.sp
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(Color.LightGray, shape = RoundedCornerShape(8.dp))
                .padding(8.dp)
                .onFocusChanged {
                    if (it.isFocused){
                        onIsSearchingChange(true)
                    }
                }
        )

        AnimatedVisibility(visible = isSearching) {
            AutoCompleteList(
                items = items,
                onItemSelected = { selectedItem ->
                    onItemSelected(selectedItem)
                    onIsSearchingChange(false)
                }
            )
        }
    }
}

@Composable
fun AutoCompleteList(
    items: List<String>,
    onItemSelected: (String) -> Unit
) {
    LazyColumn {
        items(items) { item ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onItemSelected(item)
                    }
                    .padding(16.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    text = item,
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 16.sp
                    )
                )
            }
        }
    }
}