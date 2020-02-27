package com.github.orelzion.jacques_design.core.data.repository

import com.github.orelzion.jacques_design.core.data.datasource.UserDataSource
import com.github.orelzion.jacques_design.core.domain.user.User

class UserRepository(private val dataSource: UserDataSource) {
    suspend fun addUser(user: User) = dataSource.add(user)
    suspend fun removeUser(user: User) = dataSource.remove(user.uuid)
    suspend fun updateUser(user: User) = dataSource.update(user)
    suspend fun getUser(uuid: String) = dataSource.get(uuid)
}