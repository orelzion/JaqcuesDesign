package com.github.orelzion.jacques_design.core.interactors.role

import com.github.orelzion.jacques_design.core.data.repository.RoleRepository
import com.github.orelzion.jacques_design.core.domain.user.Role
import com.github.orelzion.jacques_design.core.domain.user.RoleProperties

class AddPropertiesToRole(private val repository: RoleRepository) {
    suspend operator fun invoke(role: Role, roleProperties: RoleProperties) =
        repository.addRoleProperties(role, roleProperties)
}