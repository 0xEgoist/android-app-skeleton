package com.example.data.features.rates.repository.remote.models

import com.google.gson.annotations.SerializedName

typealias IsoCode = String
typealias Rate = Float

data class RatesResponse(
    @SerializedName("baseCurrency") val baseCurrency: String,
    @SerializedName("rates") val rates: Map<IsoCode, Rate>
)