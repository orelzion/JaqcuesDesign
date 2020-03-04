package com.github.orelzion.jacques_design.core.domain.error

class UnpermittedOperationException(message: String, exception: Throwable? = null) : Exception(message, exception)