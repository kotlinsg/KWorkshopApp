package com.kotlinsg.kworkshopapp.di

import com.kotlinsg.kworkshopapp.RealApp
import com.kotlinsg.kworkshopapp.model.di.ApplicationContextProvider
import com.kotlinsg.kworkshopapp.model.di.RepoProvider
import dagger.Component
import javax.inject.Singleton


@Component(
        dependencies = [RepoProvider::class],
        modules = [AppModule::class, ToolsModule::class]
)
@Singleton
interface AppComponent : ApplicationContextProvider {

    class Initializer private constructor() {
        companion object {
            fun init(app: RealApp): AppComponent = DaggerAppComponent.builder()
                    .appModule(AppModule(app))
                    .build()
        }
    }
}

