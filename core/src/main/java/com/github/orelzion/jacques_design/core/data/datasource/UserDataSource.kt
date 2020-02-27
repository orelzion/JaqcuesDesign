package com.github.orelzion.jacques_design.core.data.datasource

import com.github.orelzion.jacques_design.core.domain.user.User

interface UserDataSource {
    suspend fun add(user: User)
    suspend fun get(uuid: String): User
    suspend fun remove(uuid: String)
    suspend fun update(user: User)
}