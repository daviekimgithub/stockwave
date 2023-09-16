package dev.daviekim.stockwave.domain.repository

import dev.daviekim.stockwave.domain.common.Response
import dev.daviekim.stockwave.domain.model.StockWaveResponse

interface StockWaveRepository {
    suspend fun fetchStockWaveData(): Response<StockWaveResponse>
}