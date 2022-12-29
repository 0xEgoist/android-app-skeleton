package com.example.apptemplate.features.rates

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.domain.features.rates.domain.cases.GetRatesFlow
import com.example.domain.features.rates.domain.cases.SetBaseCurrencyTicker
import com.example.domain.features.rates.domain.cases.SetCurrentBaseRate
import com.example.domain.features.rates.presentation.rates.RateItem
import com.example.apptemplate.core.presenter.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.retry
import kotlinx.coroutines.launch
import javax.inject.Inject

class RatesViewModel @Inject constructor(
    private val getRatesFlow: GetRatesFlow,
    private val setBaseCurrencyTicker: SetBaseCurrencyTicker,
    private val setCurrentBaseRate: SetCurrentBaseRate
) : BaseViewModel() {

    private var rateItems = emptyList<RateItem>()
        set(value) {
            field = value
            rates.postValue(field)
        }

    val rates = MutableLiveData<List<RateItem>>()
    val isError = MutableLiveData<Boolean>()
    val errorText = MutableLiveData<String>()
    val isLoading = MutableLiveData<Boolean>()

    init {
        getRates()
    }

    fun onRateClicked(fromPosition: Int) {
        val itemToMove = rateItems.getOrNull(fromPosition) ?: return
        setBaseCurrencyTicker(itemToMove.ticker)
        val changedItems = rateItems.sortedBy { it.ticker }.toMutableList().apply {
            remove(itemToMove)
            add(0, itemToMove)
            setCurrentBaseRate(firstOrNull()?.currentRate ?: return)
        }
        rateItems = changedItems
    }

    fun onRateChanged(rate: String) {
        setCurrentBaseRate(rate.toFloatOrNull() ?: return)
        rateItems = rateItems.mapIndexed { index, item ->
            if (index != 0) item.copy(currentRate = item.unitRate * rate.toFloat())
            else item.copy(currentRate = rate.toFloat())
        }
    }

    private fun getRates() {
        isLoading.postValue(true)
        viewModelScope.launch {
            getRatesFlow(Unit)
                .flowOn(Dispatchers.IO)
                .retry {
                    rateItems = emptyList()
                    isError.postValue(true)
                    errorText.postValue(it.message)
                    isLoading.postValue(false)
                    true
                }
                .collect { items ->
                    isError.postValue(false)
                    rateItems = items
                    isLoading.postValue(false)
                }
        }
    }
}