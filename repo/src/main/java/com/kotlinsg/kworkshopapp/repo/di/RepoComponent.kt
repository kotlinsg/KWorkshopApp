package com.kotlinsg.kworkshopapp.repo.di

import com.kotlinsg.kworkshopapp.model.di.ApplicationContextProvider
import com.kotlinsg.kworkshopapp.model.di.RepoProvider
import dagger.Component

@Component(
        dependencies = [ApplicationContextProvider::class],
        modules = [RepoModule::class])
interface RepoComponent : RepoProvider {

}