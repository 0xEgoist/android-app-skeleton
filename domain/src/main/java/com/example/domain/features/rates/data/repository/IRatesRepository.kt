package com.example.domain.features.rates.data.repository

import com.example.domain.common.Result
import com.example.domain.features.rates.data.repository.models.rates.RatesResult

interface IRatesRepository {
    suspend fun getRatesAsync(currency: String): Result<RatesResult>
    fun setBaseCurrencyTicker(ticker: String)
    fun setCurrentBaseRate(rate: Float)
    fun getBaseCurrencyTicker(): String
    fun getCurrentBaseRate(): Float
}