package com.github.orelzion.jacques_design.core.domain.user

data class User(
    val uuid: String,
    val name: String,
    val email: String,
    val countryCode: String,
    val mobileNumber: String,
    val roles: List<Role>
)