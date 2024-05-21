package com.plcoding.noteappkmm.domain.note

import com.plcoding.noteappkmm.domain.time.DateTimeUtil

class SearchNotes {

    fun execute(notes: List<Note>, query: String): List<Note> {
        if(query.isBlank()) {
            return notes
        }

        val lowercaseQuery = query.trim().lowercase()
        return notes.filter {note ->
            note.title.lowercase().contains(lowercaseQuery) ||
                    note.content.lowercase().contains(lowercaseQuery)
        }.sortedByDescending {
            DateTimeUtil.toEpochMillis(it.created)
        }
    }
}