package com.example.domain.features.rates.domain.cases

import com.example.domain.base.BaseUseCase
import com.example.domain.features.rates.data.repository.IRatesRepository
import javax.inject.Inject

class SetCurrentBaseRate @Inject constructor(
    private val ratesRepository: IRatesRepository
): BaseUseCase<Float, Unit>() {

    override fun create(arg: Float) {
        ratesRepository.setCurrentBaseRate(arg)
    }
}