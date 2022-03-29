package com.tms.userregistration.domain

import com.tms.userregistration.domain.models.User

interface UserRepository {

    suspend fun getSavedUsers(): List<User>

    suspend fun saveUser(user: User)
}