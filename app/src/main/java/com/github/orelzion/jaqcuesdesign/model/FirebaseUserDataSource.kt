package com.github.orelzion.jaqcuesdesign.model

import com.github.orelzion.jacques_design.core.data.datasource.UserDataSource
import com.github.orelzion.jacques_design.core.domain.user.User
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

class FirebaseUserDataSource : UserDataSource {

    private val usersRef = Firebase.firestore.collection("users")

    override suspend fun add(user: User): User {
        usersRef.document(user.email).set(user).await()
        return user
    }

    override suspend fun get(email: String): User {
        return usersRef.document(email).get().await().toObject<User>() ?: throw Exception()
    }

    override suspend fun remove(email: String) {
        usersRef.document(email).delete().await()
    }

    override suspend fun update(email: User) {
        usersRef.document(email.email).set(email).await()
    }
}