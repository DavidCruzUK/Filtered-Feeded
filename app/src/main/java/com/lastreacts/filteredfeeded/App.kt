package com.lastreacts.filteredfeeded

import android.app.Application
import com.lastreacts.filteredfeeded.di.ApplicationComponent
import com.lastreacts.filteredfeeded.di.DaggerApplicationComponent

class App: Application() {

    lateinit var applicationComponent: ApplicationComponent
        private set

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.factory().create(this)
    }
}