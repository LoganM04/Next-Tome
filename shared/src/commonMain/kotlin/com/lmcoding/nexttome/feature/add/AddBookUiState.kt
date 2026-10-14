package com.lmcoding.nexttome.feature.add

import com.lmcoding.nexttome.domain.error.LookupError
import com.lmcoding.nexttome.domain.model.BookInfo

sealed interface AddBookUiState {
    data object Idle : AddBookUiState
    data object Loading : AddBookUiState
    data class Found(val book: BookInfo) : AddBookUiState
    data class Error(val error: LookupError) : AddBookUiState
}
