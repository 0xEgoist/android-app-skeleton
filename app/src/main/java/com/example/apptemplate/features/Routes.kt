package com.example.apptemplate.features

import androidx.annotation.IdRes
import com.example.apptemplate.R

class Routes {
    enum class RATES(@IdRes val routeId: Int) {
        TO_NEXT_SCREEN(R.id.action_ratesRoute_to_nextScreenRoute)
    }
}