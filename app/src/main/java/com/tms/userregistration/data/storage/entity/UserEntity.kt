package com.tms.userregistration.data.storage.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    val login: String,
    val password: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
