package com.pss.note.feature.domain.model

import android.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.pss.note.ui.theme.*

@Entity
data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
){
    companion object{
        val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}
