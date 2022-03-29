package com.tms.userregistration.domain

import com.tms.userregistration.domain.models.User


interface UserInteractor {
    suspend fun createUser(login: String, password: String)

    suspend fun getUsers(): List<User>
}

class UserInteractorImpl(
    private val repository: UserRepository
) : UserInteractor {

    override suspend fun createUser(login: String, password: String) {
        repository.saveUser(
            User(login, password)
        )
    }

    override suspend fun getUsers(): List<User> {
        return repository.getSavedUsers()
    }

}