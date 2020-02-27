package com.github.orelzion.jacques_design.core.domain.diamond

data class DiamondProperties<T>(
    val name: String,
    val properties: List<T>
)