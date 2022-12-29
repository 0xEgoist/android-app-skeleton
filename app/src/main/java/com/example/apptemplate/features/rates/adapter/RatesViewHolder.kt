package com.example.apptemplate.features.rates.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.domain.features.rates.presentation.rates.RateItem
import com.example.apptemplate.databinding.ItemRateBinding


class RatesViewHolder(
    val binding: ItemRateBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: RateItem) {
        binding.currencyFlagEmoji.text = item.flagEmoji
        binding.currencyTicker.text = item.ticker
        binding.currencyName.text = item.name
        with(binding.currencyRate) {
            if (!isFocused) setText(item.currentRate.toString())
        }
    }
}