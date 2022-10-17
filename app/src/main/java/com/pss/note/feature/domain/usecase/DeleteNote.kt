package com.pss.note.feature.domain.usecase

import com.pss.note.feature.domain.model.Note
import com.pss.note.feature.domain.repository.NoteRepository

class DeleteNote(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(note: Note){
        repository.deleteNote(note)
    }
}