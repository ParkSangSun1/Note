package com.pss.note.feature.domain.usecase

import com.pss.note.feature.domain.model.InvalidNoteException
import com.pss.note.feature.domain.model.Note
import com.pss.note.feature.domain.repository.NoteRepository
import kotlin.jvm.Throws

class AddNote(
    private val repository: NoteRepository
) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()){
            throw InvalidNoteException("The title of the note cant be empty")
        }
        if (note.content.isBlank()){
            throw InvalidNoteException("The content of the note cant be empty")
        }
        repository.insertNote(note)
    }
}