package com.tms.userregistration.data.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.tms.userregistration.data.storage.entity.UserEntity

@Dao
interface UsersDao {

    @Query("SELECT * FROM users")
    suspend fun getAllUsers(): List<UserEntity>

    @Insert
    suspend fun saveUser(user: UserEntity)
}