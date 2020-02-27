package com.github.orelzion.jacques_design.core.domain.diamond

data class Parcel(
    val lotNumber: String,
    val diamonds: List<Diamond>
) {
    val totalWeight = diamonds.sumByDouble { it.weigth }
}