package com.github.orelzion.jacques_design.core.domain.user

data class User(
    val name: String,
    val email: String,
    val countryCode: String,
    val mobileNumber: String,
    val roles: List<Role>
) {
    protected constructor() : this(name = "", email = "", countryCode = "", mobileNumber = "", roles = emptyList())
}