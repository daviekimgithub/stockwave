package dev.daviekim.stockwave.viewmodel.state

import dev.daviekim.stockwave.domain.model.Data

data class StockWaveState(
    val isLoading: Boolean = false,
    val isOnline: Boolean = false,
    val error: String = "",
    val searchFieldCursorPosition: Int = 0,
    val stockWaveItems: List<Data> = listOf(),
    val filteredItemsList: List<Data> = listOf(),
    val searchItemsList: List<String> = mutableListOf(""),
    val searchString: String = "",
    val isSearching: Boolean = false,
    val startDate: String = "",
    val endDate: String = "",
)