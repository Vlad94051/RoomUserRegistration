package com.tms.userregistration.presentation

import android.app.Application
import com.tms.userregistration.data.di.dataModule
import com.tms.userregistration.data.di.roomModule
import com.tms.userregistration.domain.di.domainModule
import com.tms.userregistration.domain.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            modules(
                listOf(
                    roomModule,
                    dataModule,
                    domainModule,
                    viewModelModule
                )
            )
        }
    }

}
