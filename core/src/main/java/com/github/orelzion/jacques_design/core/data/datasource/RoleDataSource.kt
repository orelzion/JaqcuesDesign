package com.github.orelzion.jacques_design.core.data.datasource

import com.github.orelzion.jacques_design.core.domain.user.Role
import com.github.orelzion.jacques_design.core.domain.user.RoleProperties
import com.github.orelzion.jacques_design.core.domain.user.User

interface RoleDataSource {
    suspend fun add(user: User, role: Role)
    suspend fun add(role: Role, roleProperties: RoleProperties)
    suspend fun remove(user: User, role: Role)
    suspend fun remove(role: Role, roleProperties: RoleProperties)
}