package com.pss.note.di

import android.app.Application
import androidx.room.Room
import com.pss.note.feature.data.datasource.NoteDatabase
import com.pss.note.feature.data.repository.NoteRepositoryImpl
import com.pss.note.feature.domain.model.Note
import com.pss.note.feature.domain.repository.NoteRepository
import com.pss.note.feature.domain.usecase.DeleteNote
import com.pss.note.feature.domain.usecase.GetNotes
import com.pss.note.feature.domain.usecase.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase{
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository{
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases{
        return NoteUseCases(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository)
        )
    }


}