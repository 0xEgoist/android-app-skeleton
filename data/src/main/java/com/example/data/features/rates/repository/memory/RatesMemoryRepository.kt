package com.example.data.features.rates.repository.memory

import javax.inject.Inject

class RatesMemoryRepository @Inject constructor() {
    var baseCurrencyTicker = "EUR"
    var currentBaseRate = 100f
}