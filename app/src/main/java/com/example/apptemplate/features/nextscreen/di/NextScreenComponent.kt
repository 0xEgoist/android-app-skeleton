package com.example.apptemplate.features.nextscreen.di

import com.example.apptemplate.features.nextscreen.NextScreenFragment
import dagger.Subcomponent

@Subcomponent(
    modules = [
        NextScreenViewModelModule::class
    ]
)
interface NextScreenComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): NextScreenComponent
    }

    fun inject(nextScreenFragment: NextScreenFragment)
}