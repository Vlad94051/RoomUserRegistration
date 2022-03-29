package com.tms.userregistration.data

import com.tms.userregistration.data.storage.entity.UserEntity
import com.tms.userregistration.domain.models.User

fun User.toUserEntity() =
    UserEntity(
        login = login,
        password = password
    )

fun UserEntity.toUser() =
    User(
        login = login,
        password = password
    )