package com.example.apptemplate.features.nextscreen

import android.content.Context
import com.example.apptemplate.App
import com.example.apptemplate.R
import com.example.apptemplate.core.view.BaseFragment

class NextScreenFragment : BaseFragment<NextScreenViewModel>(R.layout.fragment_next_screen) {

    override fun onAttach(context: Context) {
        (activity?.application as App).appComponent.nextScreenComponent().create().inject(this)
        super.onAttach(context)
    }
}