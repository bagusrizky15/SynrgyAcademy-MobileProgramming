package com.example.challengechapter4.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface NoteDao {
    @Insert
    fun addNote(note: Note)

    @Update
    fun updateNote(note:Note)

    @Delete
    fun deleteNote(note: Note)

    @Query("SELECT * FROM note_table")
    fun getNotes(note: Note): List<Note>
}