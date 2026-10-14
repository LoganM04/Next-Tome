package com.lmcoding.nexttome.domain.error

import com.lmcoding.nexttome.data.remote.util.AppError

enum class LookupError : AppError {
    NOT_FOUND,
    NO_INTERNET,
    SERVICE_UNAVAILABLE,
    INVALID_ISBN,
}