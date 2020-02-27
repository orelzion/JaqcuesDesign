package com.github.orelzion.jacques_design.core.data.repository

import com.github.orelzion.jacques_design.core.data.datasource.ParcelDataSource
import com.github.orelzion.jacques_design.core.domain.diamond.Diamond
import com.github.orelzion.jacques_design.core.domain.diamond.Parcel

class ParcelRepository(private val dataSource: ParcelDataSource) {
    suspend fun addParcel(parcel: Parcel) = dataSource.add(parcel)
    suspend fun addDiamond(parcel: Parcel, diamond: Diamond) = dataSource.add(parcel, diamond)
    suspend fun removeParcel(parcel: Parcel) = dataSource.remove(parcel.lotNumber)
    suspend fun removeDiamond(parcel: Parcel, diamond: Diamond) = dataSource.remove(parcel, diamond)
    suspend fun getParcel(lotNumber: String) = dataSource.get(lotNumber)
    suspend fun getAllParcels(limit: Int = Int.MAX_VALUE) = dataSource.getAll(limit)
    suspend fun updateParcel(parcel: Parcel) = dataSource.update(parcel)
    suspend fun updateDiamond(parcel: Parcel, diamond: Diamond) = dataSource.update(parcel, diamond)
}