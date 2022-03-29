package com.tms.userregistration.domain.di

import com.tms.userregistration.domain.UserInteractor
import com.tms.userregistration.domain.UserInteractorImpl
import org.koin.dsl.module

val domainModule = module {
    single<UserInteractor> {
        UserInteractorImpl(get())
    }
}