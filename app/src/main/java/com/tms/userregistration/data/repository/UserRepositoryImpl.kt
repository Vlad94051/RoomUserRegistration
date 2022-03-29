package com.tms.userregistration.data.repository

import com.tms.userregistration.data.storage.UsersDao
import com.tms.userregistration.data.toUser
import com.tms.userregistration.data.toUserEntity
import com.tms.userregistration.domain.UserRepository
import com.tms.userregistration.domain.models.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepositoryImpl(
    private val usersDao: UsersDao
) : UserRepository {

    override suspend fun getSavedUsers(): List<User> {
        return withContext(Dispatchers.IO) {
            usersDao.getAllUsers().map { entity -> entity.toUser() }
        }
    }

    override suspend fun saveUser(user: User) {
        withContext(Dispatchers.IO) {
            usersDao.saveUser(user.toUserEntity())
        }
    }
}