package dev.daviekim.stockwave.domain.usecase

import dev.daviekim.stockwave.domain.InternetService
import dev.daviekim.stockwave.domain.common.Response
import dev.daviekim.stockwave.domain.common.exception.InternetException
import dev.daviekim.stockwave.domain.common.usecase.UseCaseNoInput
import dev.daviekim.stockwave.domain.model.StockWaveResponse
import dev.daviekim.stockwave.domain.repository.StockWaveRepository

class FetchStockWaveUseCase(
    private val internetService: InternetService,
    private val stockWaveRepository: StockWaveRepository
): UseCaseNoInput<StockWaveResponse> {
    override suspend fun execute(): Response<StockWaveResponse> {
        if (!internetService.isConnected()){
            return Response.failure(InternetException)
        }
        return stockWaveRepository.fetchStockWaveData()
    }
}