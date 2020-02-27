package com.github.orelzion.jacques_design.core.domain.diamond

import com.github.orelzion.jacques_design.core.domain.Coin

data class Fee(
    val name: String,
    val coin: Coin
)