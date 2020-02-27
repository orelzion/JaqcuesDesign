package com.github.orelzion.jacques_design.core.data.repository

import com.github.orelzion.jacques_design.core.data.datasource.RoleDataSource
import com.github.orelzion.jacques_design.core.domain.user.Role
import com.github.orelzion.jacques_design.core.domain.user.RoleProperties
import com.github.orelzion.jacques_design.core.domain.user.User

class RoleRepository(private val dataSource: RoleDataSource) {
    suspend fun addRole(user: User, role: Role) = dataSource.add(user, role)
    suspend fun addRoleProperties(role: Role, roleProperties: RoleProperties) =
        dataSource.add(role, roleProperties)

    suspend fun removeRole(user: User, role: Role) = dataSource.remove(user, role)
    suspend fun removeRoleProperties(role: Role, roleProperties: RoleProperties) =
        dataSource.remove(role, roleProperties)
}