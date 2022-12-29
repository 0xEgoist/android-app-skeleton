package com.example.apptemplate.features.rates.di

import com.example.apptemplate.features.rates.RatesFragment
import dagger.Subcomponent

@Subcomponent(
    modules = [
        RatesRepositoryModule::class,
        RatesViewModelModule::class
    ]
)
interface RatesComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): RatesComponent
    }

    fun inject(ratesFragment: RatesFragment)
}