package com.example.apptemplate.features.rates.di

import androidx.lifecycle.ViewModel
import com.example.apptemplate.di.viewmodel.ViewModelKey
import com.example.apptemplate.features.rates.RatesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface RatesViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(RatesViewModel::class)
    fun bindsRatesViewModel(ratesViewModel: RatesViewModel): ViewModel
}