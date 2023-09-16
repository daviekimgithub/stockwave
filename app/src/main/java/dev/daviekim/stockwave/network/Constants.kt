package dev.daviekim.stockwave.network

import dev.daviekim.stockwave.utils.customShuffle

object Constants {
    val API_ACCESS_KEY = "83aedcd6f0f7c5fae7e66343eb4f0b3c"
    val COMPANIES_SYMBOLS = arrayOf(
        "AAPL",
        "GOOGL",
        "GOOG",
        "MSFT",
        "AMZN",
        "FB",
        "TSLA",
        "BRK.A",
        "BRK.B",
        "JPM",
        "V",
        "JNJ",
        "WMT",
        "PG",
        "MA",
        "NVDA",
        "UNH",
        "HD",
        "DIS",
        "BAC",
        "VZ",
        "KO",
        "MRK",
        "PFE",
        "INTC",
        "NFLX",
        "ADBE",
        "CSCO",
        "CMCSA",
        "PEP",
        "XOM",
        "MCD",
        "BA",
        "ORCL",
        "T",
        "NKE",
        "ABT",
        "CRM",
        "CVX",
        "IBM",
        "MMM",
        "TXN",
        "UTX",
        "ACN",
        "BMY",
        "CAT",
        "DHR",
        "GS",
        "MMM",
        "PYPL",
        "AXP",
        "COST"
    )
    fun getRandomCompanySymbols(count: Int = 10): List<String> {
        return COMPANIES_SYMBOLS.customShuffle().take(count)
    }
}

