package com.kotlinsg.kworkshopapp.repo.di

import com.kotlinsg.kworkshopapp.repo.GithubRepo
import com.kotlinsg.kworkshopapp.model.di.ApplicationContextProvider
import com.kotlinsg.kworkshopapp.model.di.NetworkClientProvider
import dagger.Component
import javax.inject.Provider

@Component(
        dependencies = [ApplicationContextProvider::class, NetworkClientProvider::class],
        modules = [RepoModule::class])
interface RepoComponent {
    fun repo(): Provider<GithubRepo>
}