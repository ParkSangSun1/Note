package com.pss.note.feature.presentation.notes

import com.pss.note.feature.domain.model.Note
import com.pss.note.feature.domain.util.NoteOrder
import com.pss.note.feature.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)