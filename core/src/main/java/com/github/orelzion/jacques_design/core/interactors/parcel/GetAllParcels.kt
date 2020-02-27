package com.github.orelzion.jacques_design.core.interactors.parcel

import com.github.orelzion.jacques_design.core.data.repository.ParcelRepository

class GetAllParcels(private val repository: ParcelRepository) {
    suspend operator fun invoke(limit: Int) = repository.getAllParcels(limit)
}