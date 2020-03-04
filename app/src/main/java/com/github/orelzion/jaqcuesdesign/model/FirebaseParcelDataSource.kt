package com.github.orelzion.jaqcuesdesign.model

import com.github.orelzion.jacques_design.core.data.datasource.ParcelDataSource
import com.github.orelzion.jacques_design.core.domain.diamond.Diamond
import com.github.orelzion.jacques_design.core.domain.diamond.Parcel
import com.github.orelzion.jacques_design.core.domain.error.DiamondNotFoundException
import com.github.orelzion.jacques_design.core.domain.error.ParcelNotFoundException
import com.github.orelzion.jaqcuesdesign.copyOf
import com.github.orelzion.jaqcuesdesign.replace
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

class FirebaseParcelDataSource : ParcelDataSource {

    private val parcelRef = Firebase.firestore.collection("parcels")

    override suspend fun add(parcel: Parcel) {
        parcelRef.document(parcel.lotNumber).set(parcel).await()
    }

    override suspend fun add(parcel: Parcel, diamond: Diamond): Parcel {
        parcel.copy(diamonds = parcel.diamonds.copyOf().apply { add(diamond) })
            .let { updatedParcel ->
                parcelRef.document(parcel.lotNumber).set(updatedParcel).await()
                return updatedParcel
            }
    }

    override suspend fun get(lotNumber: String): Parcel {
        return parcelRef.document(lotNumber).get().await().toObject(Parcel::class.java)
            ?: throw Exception()
    }

    override suspend fun getAll(limit: Int): List<Parcel> {
        return parcelRef.get().await().toObjects(Parcel::class.java)
    }

    override suspend fun remove(lotNumber: String) {
        parcelRef.document(lotNumber).delete().await()
    }

    override suspend fun remove(parcel: Parcel, diamondLotNumber: String): Parcel {
        parcel.diamonds.copyOf().apply {
            removeAll { it.lotNumber == diamondLotNumber }
        }.let { updatedDiamondsArray ->
            parcel.copy(diamonds = updatedDiamondsArray).let { updatedParcel ->
                parcelRef.document(parcel.lotNumber).set(updatedParcel).await()
                return updatedParcel
            }
        }
    }

    @Throws(ParcelNotFoundException::class)
    override suspend fun update(parcel: Parcel) {
        getParcelIfExists(parcel.lotNumber)
            .getOrThrow()
            .set(parcel)
            .await()
    }

    @Throws(ParcelNotFoundException::class, DiamondNotFoundException::class)
    override suspend fun update(parcel: Parcel, diamond: Diamond): Parcel {
        val updatedParcel = parcel.copy(
            diamonds = updateDiamondIfExists(
                diamond,
                parcel.diamonds
            ).getOrThrow()
        )

        getParcelIfExists(parcel.lotNumber)
            .getOrThrow()
            .set(updatedParcel)
            .await()

        return updatedParcel
    }

    private suspend fun getParcelIfExists(lotNumber: String): Result<DocumentReference> {
        val currentParcel = parcelRef.document(lotNumber)
        return if (!currentParcel.get().await().exists()) {
            Result.failure(ParcelNotFoundException("Parcel $lotNumber was not found"))
        } else {
            Result.success(currentParcel)
        }
    }

    private fun updateDiamondIfExists(
        diamond: Diamond,
        diamondList: List<Diamond>
    ): Result<List<Diamond>> {
        val index = diamondList.indexOfFirst { it.lotNumber == diamond.lotNumber }
        return if (index < 0) {
            Result.failure(DiamondNotFoundException("Diamond ${diamond.lotNumber} was not found in parcel"))
        } else {
            Result.success(diamondList.replace(index, diamond))
        }
    }
}