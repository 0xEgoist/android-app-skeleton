package com.example.data.repository.converters

import com.example.data.features.rates.repository.remote.models.RatesResponse
import com.example.domain.features.rates.data.repository.models.rates.RatesResult

const val DEFAULT_BASE_CURRENCY = "EUR"

fun RatesResponse?.toDomainObj(): RatesResult = RatesResult(
    baseCurrency = this?.baseCurrency ?: DEFAULT_BASE_CURRENCY,
    rates = this?.rates.orEmpty()
)