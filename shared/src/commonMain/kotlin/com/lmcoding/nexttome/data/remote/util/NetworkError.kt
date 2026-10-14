package com.lmcoding.nexttome.data.remote.util

enum class NetworkError : AppError{
    NO_INTERNET,
    UNAUTHORIZED,
    REQUEST_TIMEOUT,
    TOO_MANY_REQUESTS,
    SERVER_ERROR,
    PAYLOAD_TOO_LARGE,
    SERIALIZATION,
    UNKNOWN,
}