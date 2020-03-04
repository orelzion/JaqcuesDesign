package com.github.orelzion.jacques_design.core.domain.diamond

data class Diamond(
    val lotNumber: String,
    val weight: Double,
    val properties: List<DiamondProperties<*>>,
    val costs: List<Fee>,
    val prices: List<Fee>
) {
    val totalCost: Double = costs.sumByDouble { it.coin.value }
}