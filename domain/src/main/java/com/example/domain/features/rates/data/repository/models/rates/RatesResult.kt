package com.example.domain.features.rates.data.repository.models.rates

data class RatesResult(
    val baseCurrency: String,
    val rates: Map<String, Float>
)