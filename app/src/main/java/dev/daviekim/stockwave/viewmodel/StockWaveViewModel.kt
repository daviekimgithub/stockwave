package dev.daviekim.stockwave.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.daviekim.stockwave.common.Constants.companySymbolToName
import dev.daviekim.stockwave.domain.model.Data
import dev.daviekim.stockwave.domain.usecase.FetchStockWaveUseCase
import dev.daviekim.stockwave.viewmodel.state.StockWaveState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StockWaveViewModel(
    val fetchStockWaveUseCase: FetchStockWaveUseCase
): ViewModel() {

    var stockWaveStates by mutableStateOf(StockWaveState())

    fun onAction(action: Action) {
        when (action) {
            is Action.onFetchStockWave -> {
                fetchStockWave()
            }
            is Action.onSearchItemsArrChanged -> {
                stockWaveStates = stockWaveStates.copy(searchItemsList = action.itemArr)
            }
            is Action.onSearchStringChanged -> {
                stockWaveStates = stockWaveStates.copy(
                    searchString = action.searchString,
                    filteredItemsList = filterItems(action.searchString),
                    searchItemsList = getSymbolList(filterItems(action.searchString))
                )
                Log.e("search string", action.searchString)
                Log.e("filtered items List", filterItems(action.searchString).toString())
                Log.e("filtered items List", filterItems(action.searchString).size.toString())
                Log.e("search items List", getSymbolList(filterItems(action.searchString)).toString())
            }

            is Action.onIsSearchingChanged -> {
                stockWaveStates = stockWaveStates.copy(
                    isSearching = action.isSearching
                )
            }
        }
    }

    private fun filterItems(searchString: String): List<Data> {
        return stockWaveStates.stockWaveItems.filter {
            it.symbol.lowercase().contains(searchString.lowercase())
        }
    }

    fun getSymbolList(dataList: List<Data>): List<String> {
        return (dataList.map { (it.symbol) }).toSet().toList()
    }

    private fun fetchStockWave() {
        stockWaveStates = stockWaveStates.copy(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            fetchStockWaveUseCase.execute().fold(
                onSuccess = {
                    val searchItemsList: MutableList<String> = mutableListOf()
                    stockWaveStates = stockWaveStates.copy(
                        isLoading = false,
                        stockWaveItems = it.data,
                        filteredItemsList = it.data
                    )
                    for(item in it.data){
                        searchItemsList.add(item.symbol)
                    }
                    stockWaveStates = stockWaveStates.copy(
                        searchItemsList = searchItemsList.toSet().toList()
                    )
                },
                onFailure = {
                    stockWaveStates = stockWaveStates.copy(
                        error = it.message.toString()
                    )
                }
            )

            Log.e("data ", stockWaveStates.stockWaveItems.toString())
        }
    }


    sealed interface Action {
        object onFetchStockWave: Action
        data class onSearchStringChanged(val searchString: String): Action
        data class onSearchItemsArrChanged(val itemArr: List<String>): Action
        data class onIsSearchingChanged(val isSearching: Boolean): Action
    }
}
