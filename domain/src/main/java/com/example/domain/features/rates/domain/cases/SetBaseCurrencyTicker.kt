package com.example.domain.features.rates.domain.cases

import com.example.domain.base.BaseUseCase
import com.example.domain.features.rates.data.repository.IRatesRepository
import javax.inject.Inject

class SetBaseCurrencyTicker @Inject constructor(
    private val ratesRepository: IRatesRepository
): BaseUseCase<String, Unit>() {

    override fun create(arg: String) {
        ratesRepository.setBaseCurrencyTicker(arg)
    }
}