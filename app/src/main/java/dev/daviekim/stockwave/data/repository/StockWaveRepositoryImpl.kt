package dev.daviekim.stockwave.data.repository

import dev.daviekim.stockwave.data.datasource.StockWaveDataSource
import dev.daviekim.stockwave.data.datasource.remote.model.toDomain
import dev.daviekim.stockwave.domain.common.Response
import dev.daviekim.stockwave.domain.model.StockWaveResponse
import dev.daviekim.stockwave.domain.repository.StockWaveRepository

class StockWaveRepositoryImpl(
    private val dataSource: StockWaveDataSource
): StockWaveRepository {
    override suspend fun fetchStockWaveData(): Response<StockWaveResponse> {
        return try {
            Response.success(dataSource.fetchStockWaveData().toDomain())
        } catch (e: Exception) {
            Response.failure(e)
        }
    }
}