package dev.daviekim.stockwave.data.datasource.remote

import android.util.Log
import dev.daviekim.stockwave.data.datasource.StockWaveDataSource
import dev.daviekim.stockwave.data.datasource.remote.error.StockWaveErrorResposeData
import dev.daviekim.stockwave.data.datasource.remote.model.StockWaveResponseData
import dev.daviekim.stockwave.network.Constants
import dev.daviekim.stockwave.network.StockWaveHttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.isSuccess

class StockWaveDataSourceImpl(
    private val httpClient: StockWaveHttpClient
): StockWaveDataSource {
    override suspend fun fetchStockWaveData(): StockWaveResponseData {
        Log.e("symbols", Constants.getRandomCompanySymbols(count=10).toString())
        val response = httpClient.getHttpClient(
            apiAcessKey = Constants.API_ACCESS_KEY,
            symbols = Constants.getRandomCompanySymbols(count=10).joinToString(",")
        ).get("/v1/eod")
        if (response.status.isSuccess()){
            return response.body()
        }
        val error = response.body<StockWaveErrorResposeData>()
        throw Exception(error.error.message)
    }
}