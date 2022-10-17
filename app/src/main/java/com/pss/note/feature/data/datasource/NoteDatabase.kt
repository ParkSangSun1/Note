package com.pss.note.feature.data.datasource

import androidx.room.Database
import com.pss.note.feature.domain.model.Note

@Database(
    entities = [Note::class],
    version = 1
)
abstract class NoteDatabase {

    abstract val noteDao: NoteDao
}