package com.pss.note.feature.data.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pss.note.feature.domain.model.Note

@Database(
    entities = [Note::class],
    version = 1
)
abstract class NoteDatabase: RoomDatabase() {

    abstract val noteDao: NoteDao

    companion object{
        const val DATABASE_NAME = "note_db"
    }
}