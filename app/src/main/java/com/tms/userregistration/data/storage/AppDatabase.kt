package com.tms.userregistration.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tms.userregistration.data.storage.entity.UserEntity

@Database(
    entities = [UserEntity::class],
    version = AppDatabase.VERSION
)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        const val VERSION = 1
    }

    abstract fun getUsersDao(): UsersDao
}