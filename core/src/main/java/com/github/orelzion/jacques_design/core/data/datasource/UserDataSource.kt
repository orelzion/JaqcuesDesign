package com.github.orelzion.jacques_design.core.data.datasource

import com.github.orelzion.jacques_design.core.domain.user.User

interface UserDataSource {
    suspend fun add(user: User): User
    suspend fun get(email: String): User
    suspend fun remove(email: String)
    suspend fun update(email: User)
}