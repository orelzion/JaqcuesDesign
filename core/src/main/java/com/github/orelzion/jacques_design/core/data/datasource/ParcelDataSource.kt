package com.github.orelzion.jacques_design.core.data.datasource

import com.github.orelzion.jacques_design.core.domain.diamond.Diamond
import com.github.orelzion.jacques_design.core.domain.diamond.Parcel

interface ParcelDataSource {
    suspend fun add(parcel: Parcel)
    suspend fun add(parcel: Parcel, diamond: Diamond)
    suspend fun get(lotNumber: String): Parcel
    suspend fun getAll(limit: Int): List<Parcel>
    suspend fun remove(lotNumber: String)
    suspend fun remove(parcel: Parcel, diamond: Diamond)
    suspend fun update(parcel: Parcel)
    suspend fun update(parcel: Parcel, diamond: Diamond)
}