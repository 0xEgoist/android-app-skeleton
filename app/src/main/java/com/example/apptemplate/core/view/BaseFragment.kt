package com.example.apptemplate.core.view

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.apptemplate.R
import com.example.apptemplate.core.presenter.BaseViewModel
import com.example.apptemplate.di.viewmodel.InjectingSavedStateViewModelFactory
import java.lang.reflect.ParameterizedType
import javax.inject.Inject

abstract class BaseFragment<VM : BaseViewModel>(@LayoutRes layoutResId: Int) : Fragment(layoutResId) {

    @Inject lateinit var defaultViewModelFactory: InjectingSavedStateViewModelFactory

    protected lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[getVMClass()]
    }

    override fun getDefaultViewModelProviderFactory(): ViewModelProvider.Factory =
        defaultViewModelFactory.create(this, arguments)

    @Suppress("UNCHECKED_CAST") private fun getVMClass(): Class<VM> {
        val parameterizedType = javaClass.genericSuperclass as ParameterizedType
        val viewModelClass = parameterizedType.actualTypeArguments.first() as? Class<VM>
        return viewModelClass ?: throw AssertionError("ViewModel class $parameterizedType was not found")
    }

    fun navigateTo(@IdRes routeId: Int) {
        requireActivity().findNavController(R.id.nav_host_fragment).navigate(routeId)
    }
}