package com.example.domain.features.rates.domain.cases

import com.example.domain.base.BaseAsyncUseCase
import com.example.domain.common.getResult
import com.example.domain.features.rates.data.repository.IRatesRepository
import com.example.domain.features.rates.data.repository.models.rates.RatesResult
import javax.inject.Inject

class GetRates @Inject constructor(
    private val ratesRepository: IRatesRepository
) : BaseAsyncUseCase<Unit, RatesResult>() {

    override suspend fun create(arg: Unit): RatesResult {
        return ratesRepository.getRatesAsync(ratesRepository.getBaseCurrencyTicker()).getResult()
    }
}