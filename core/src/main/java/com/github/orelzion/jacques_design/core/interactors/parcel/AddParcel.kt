package com.github.orelzion.jacques_design.core.interactors.parcel

import com.github.orelzion.jacques_design.core.data.repository.ParcelRepository
import com.github.orelzion.jacques_design.core.domain.diamond.Parcel

class AddParcel(private val repository: ParcelRepository) {
    suspend operator fun invoke(parcel: Parcel) = repository.addParcel(parcel)
}