package com.github.orelzion.jacques_design.core.interactors.user

import com.github.orelzion.jacques_design.core.data.repository.UserRepository

class GetUser(private val repository: UserRepository) {
    suspend operator fun invoke(uuid: String) = repository.getUser(uuid)
}