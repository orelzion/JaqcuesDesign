package com.github.orelzion.jacques_design.core.interactors.parcel

import com.github.orelzion.jacques_design.core.data.repository.ParcelRepository

class GetParcelByLot(private val repository: ParcelRepository) {
    suspend operator fun invoke(lotNumber: String) = repository.getParcel(lotNumber)
}