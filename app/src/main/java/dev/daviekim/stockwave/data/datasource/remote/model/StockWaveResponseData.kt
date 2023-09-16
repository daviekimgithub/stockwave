package dev.daviekim.stockwave.data.datasource.remote.model

import dev.daviekim.stockwave.domain.model.StockWaveResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StockWaveResponseData(
    @SerialName("data")
    val `data`: List<Data>
)

fun StockWaveResponseData.toDomain() = StockWaveResponse(
    data = data.map {
        dev.daviekim.stockwave.domain.model.Data(
            adj_close = it.adj_close,
            adj_high = it.adj_high,
            adj_low = it.adj_low,
            adj_open = it.adj_open,
            adj_volume = it.adj_volume,
            close = it.close,
            date = it.date,
            dividend = it.dividend,
            exchange = it.exchange,
            high = it.high,
            low = it.low,
            open = it.open,
            split_factor = it.split_factor,
            symbol = it.symbol,
            volume = it.volume
        )
    }
)
