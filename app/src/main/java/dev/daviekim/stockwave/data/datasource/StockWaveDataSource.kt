package dev.daviekim.stockwave.data.datasource

import dev.daviekim.stockwave.data.datasource.remote.model.StockWaveResponseData

interface StockWaveDataSource {
    suspend fun fetchStockWaveData() : StockWaveResponseData
}