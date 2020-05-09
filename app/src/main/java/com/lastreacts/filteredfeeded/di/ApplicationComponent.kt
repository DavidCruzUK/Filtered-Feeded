package com.lastreacts.filteredfeeded.di

import android.app.Application
import com.lastreacts.filteredfeeded.di.modules.ApplicationModule
import com.lastreacts.filteredfeeded.di.modules.ViewModelsModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        ViewModelsModule::class
    ]
)
interface ApplicationComponent: Injections {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): ApplicationComponent
    }
}