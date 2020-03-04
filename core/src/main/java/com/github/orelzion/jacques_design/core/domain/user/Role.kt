package com.github.orelzion.jacques_design.core.domain.user

data class Role(
    val name: String,
    val properties: List<RoleProperties>
) {
    protected constructor(): this(name = "", properties = emptyList())
}