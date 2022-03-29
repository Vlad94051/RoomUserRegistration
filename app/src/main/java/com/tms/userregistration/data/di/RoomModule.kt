package com.tms.userregistration.data.di

import androidx.room.Room
import com.tms.userregistration.data.storage.AppDatabase
import com.tms.userregistration.data.storage.UsersDao
import org.koin.dsl.module

val roomModule = module {
    single<AppDatabase> {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            "users"
        ).build()
    }

    single<UsersDao> {
        get<AppDatabase>().getUsersDao()
    }
}
