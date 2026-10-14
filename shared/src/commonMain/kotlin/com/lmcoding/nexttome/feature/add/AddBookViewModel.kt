package com.lmcoding.nexttome.feature.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lmcoding.nexttome.data.remote.util.onError
import com.lmcoding.nexttome.data.remote.util.onSuccess
import com.lmcoding.nexttome.domain.error.LookupError
import com.lmcoding.nexttome.domain.model.Isbn
import com.lmcoding.nexttome.domain.repository.BookLookupRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AddBookViewModel(
    private val repository: BookLookupRepository,
) : ViewModel() {

    private val _state = MutableStateFlow<AddBookUiState>(AddBookUiState.Idle)
    val state: StateFlow<AddBookUiState> = _state.asStateFlow()

    fun onIsbnSubmitted(raw: String) {
        val isbn = Isbn.parse(raw)
        if (isbn == null) {
            _state.value = AddBookUiState.Error(LookupError.INVALID_ISBN)
            return
        }

        _state.value = AddBookUiState.Loading
        viewModelScope.launch {
            repository.findByIsbn(isbn)
                .onSuccess { book -> _state.value = AddBookUiState.Found(book) }
                .onError { error -> _state.value = AddBookUiState.Error(error) }
        }
    }
}
