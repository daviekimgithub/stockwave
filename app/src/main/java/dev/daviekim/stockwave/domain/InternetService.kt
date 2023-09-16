package dev.daviekim.stockwave.domain

interface InternetService {
    fun isConnected(): Boolean
}