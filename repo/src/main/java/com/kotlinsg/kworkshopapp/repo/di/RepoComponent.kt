package com.kotlinsg.kworkshopapp.repo.di

import com.kotlinsg.kworkshopapp.di.ApplicationContextProvider
import com.kotlinsg.kworkshopapp.di.RepoProvider
import com.kotlinsg.kworkshopapp.network.di.NetworkModule
import dagger.Component

@Component(
        dependencies = [ApplicationContextProvider::class],
        modules = [RepoModule::class, NetworkModule::class])
interface RepoComponent : RepoProvider {
    class Initializer private constructor() {
        companion object {
            fun init(appComponent: ApplicationContextProvider): RepoComponent = DaggerRepoComponent.builder()
                    .applicationContextProvider(appComponent)
                    .build()
        }
    }
}