package dev.daviekim.stockwave.utils

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun String.getDayMonthYear(): String {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ")
    val localDateTime = LocalDateTime.parse(this, formatter)

    // Format the LocalDateTime to include only day, month, and year
    val formattedDate = localDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))

    return formattedDate
}