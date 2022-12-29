package com.example.apptemplate.features.rates.di

import com.example.data.features.rates.repository.remote.RatesRepository
import com.example.domain.features.rates.data.repository.IRatesRepository
import dagger.Binds
import dagger.Module

@Module
interface RatesRepositoryModule {

    @Binds
    fun bindRatesRepository(
        ratesRepository: RatesRepository
    ): IRatesRepository
}