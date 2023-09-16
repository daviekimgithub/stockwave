package dev.daviekim.stockwave.utils

import kotlin.random.Random


fun Array<String>.customShuffle(): List<String> {
    val shuffledList = this.toMutableList()
    for (i in shuffledList.size - 1 downTo 1) {
        val j = Random.nextInt(i + 1)
        val temp = shuffledList[i]
        shuffledList[i] = shuffledList[j]
        shuffledList[j] = temp
    }
    return shuffledList
}