package com.tms.userregistration.data.di

import com.tms.userregistration.data.repository.UserRepositoryImpl
import com.tms.userregistration.domain.UserRepository
import org.koin.dsl.module

val dataModule = module {

    single<UserRepository> {
        UserRepositoryImpl(get())
    }
}