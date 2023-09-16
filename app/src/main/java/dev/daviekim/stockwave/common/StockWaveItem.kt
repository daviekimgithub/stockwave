package dev.daviekim.stockwave.common

data class StockWaveItem(
    var symbol: String = "AAPL",
    var name: String = "Apple Inc.",
    var date: String = "19 Jun 2022",
    var close: Double = 151.28,
    var open: Double = 148.07,
    var high: Double = 157.50,
    var low: Double = 147.82
)