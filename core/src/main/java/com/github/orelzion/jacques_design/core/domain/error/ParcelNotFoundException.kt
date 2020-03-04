package com.github.orelzion.jacques_design.core.domain.error

class ParcelNotFoundException(message: String, exception: Throwable? = null) :
    Exception(message, exception)