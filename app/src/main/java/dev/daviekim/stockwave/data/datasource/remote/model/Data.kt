package dev.daviekim.stockwave.data.datasource.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Data(
    @SerialName("adj_close")
    val adj_close: Double,
    @SerialName("adj_high")
    val adj_high: Double,
    @SerialName("adj_low")
    val adj_low: Double,
    @SerialName("adj_open")
    val adj_open: Double,
    @SerialName("adj_volume")
    val adj_volume: Double,
    @SerialName("close")
    val close: Double,
    @SerialName("date")
    val date: String,
    @SerialName("dividend")
    val dividend: Double,
    @SerialName("exchange")
    val exchange: String,
    @SerialName("high")
    val high: Double,
    @SerialName("low")
    val low: Double,
    @SerialName("open")
    val `open`: Double,
    @SerialName("split_factor")
    val split_factor: Double,
    @SerialName("symbol")
    val symbol: String,
    @SerialName("volume")
    val volume: Double
)