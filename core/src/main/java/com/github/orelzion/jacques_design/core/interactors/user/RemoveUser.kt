package com.github.orelzion.jacques_design.core.interactors.user

import com.github.orelzion.jacques_design.core.data.repository.UserRepository
import com.github.orelzion.jacques_design.core.domain.user.User

class RemoveUser(private val repository: UserRepository) {
    suspend operator fun invoke(user: User) = repository.removeUser(user)
}