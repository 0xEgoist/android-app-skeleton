package com.example.apptemplate.features.nextscreen.di

import androidx.lifecycle.ViewModel
import com.example.apptemplate.di.viewmodel.ViewModelKey
import com.example.apptemplate.features.nextscreen.NextScreenViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface NextScreenViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(NextScreenViewModel::class)
    fun bindsNextScreenViewModel(nextScreenViewModel: NextScreenViewModel): ViewModel
}