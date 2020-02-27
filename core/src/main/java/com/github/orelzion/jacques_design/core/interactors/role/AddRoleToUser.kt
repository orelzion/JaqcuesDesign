package com.github.orelzion.jacques_design.core.interactors.role

import com.github.orelzion.jacques_design.core.data.repository.RoleRepository
import com.github.orelzion.jacques_design.core.domain.user.Role
import com.github.orelzion.jacques_design.core.domain.user.User

class AddRoleToUser(private val repository: RoleRepository) {
    suspend operator fun invoke(user: User, role: Role) = repository.addRole(user, role)
}