package com.lmcoding.nexttome.feature.add

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.lmcoding.nexttome.domain.error.LookupError
import com.lmcoding.nexttome.domain.model.BookInfo
import com.lmcoding.nexttome.ui.components.ScreenFrame
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun AddBookScreen(
    onBack: () -> Unit,
    viewModel: AddBookViewModel = koinViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    AddBookContent(
        state = state,
        onSubmit = viewModel::onIsbnSubmitted,
        onBack = onBack,
    )
}

@Composable
private fun AddBookContent(
    state: AddBookUiState,
    onSubmit: (String) -> Unit,
    onBack: () -> Unit,
) {
    var isbn by rememberSaveable { mutableStateOf("") }

    ScreenFrame(
        topBar = {
            Text(
                "Ajouter un livre",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(16.dp),
            )
        },
    ) { padding ->
        Column(
            modifier = Modifier.padding(padding).padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            OutlinedTextField(
                value = isbn,
                onValueChange = { isbn = it },
                label = { Text("ISBN") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth(),
            )

            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                Button(
                    onClick = { onSubmit(isbn) },
                    enabled = state != AddBookUiState.Loading,
                ) { Text("Chercher") }
                OutlinedButton(onClick = onBack) { Text("Annuler") }
            }

            when (state) {
                AddBookUiState.Idle -> Text(
                    "Tape l'ISBN imprimé au dos du livre.",
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
                AddBookUiState.Loading -> CircularProgressIndicator()
                is AddBookUiState.Found -> BookInfoPreview(state.book)
                is AddBookUiState.Error -> Text(
                    state.error.toMessage(),
                    color = MaterialTheme.colorScheme.error,
                )
            }
        }
    }
}

@Composable
private fun BookInfoPreview(book: BookInfo) {
    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Text(book.title, style = MaterialTheme.typography.titleLarge)
        if (book.authors.isNotEmpty()) Text(book.authors.joinToString())
        Text("Éditeur : ${book.publisher ?: "inconnu"}")
        Text("Type détecté : ${book.type}")
        Text(
            "Couverture : ${book.coverUrl ?: "aucune"}",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
    }
}

private fun LookupError.toMessage(): String = when (this) {
    LookupError.NOT_FOUND -> "Aucun livre trouvé pour cet ISBN."
    LookupError.NO_INTERNET -> "Pas de connexion. Vérifie ton réseau."
    LookupError.SERVICE_UNAVAILABLE -> "Le service ne répond pas. Réessaie plus tard."
    LookupError.INVALID_ISBN -> "Cet ISBN n'est pas valide."
}
