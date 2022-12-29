package com.example.apptemplate.di

import android.content.Context
import com.example.apptemplate.di.viewmodel.CommonViewModelModule
import com.example.apptemplate.features.nextscreen.di.NextScreenComponent
import com.example.apptemplate.features.rates.di.RatesComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class,
        CommonViewModelModule::class
    ]
)
interface ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }

    fun ratesComponent(): RatesComponent.Factory

    fun nextScreenComponent(): NextScreenComponent.Factory
}