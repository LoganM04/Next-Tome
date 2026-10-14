package com.lmcoding.nexttome.data.mapper

import com.lmcoding.nexttome.data.remote.util.NetworkError
import com.lmcoding.nexttome.domain.error.LookupError

fun NetworkError.toLookupError() : LookupError = when(this){
    NetworkError.NO_INTERNET, NetworkError.REQUEST_TIMEOUT -> LookupError.NO_INTERNET
    NetworkError.TOO_MANY_REQUESTS,
    NetworkError.SERVER_ERROR,
    NetworkError.SERIALIZATION,
    NetworkError.PAYLOAD_TOO_LARGE,
    NetworkError.UNAUTHORIZED,
    NetworkError.UNKNOWN -> LookupError.SERVICE_UNAVAILABLE
}