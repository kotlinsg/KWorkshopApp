package com.kotlinsg.kworkshopapp.di

import com.kotlinsg.kworkshopapp.App
import com.kotlinsg.kworkshopapp.GithubProject
import com.kotlinsg.kworkshopapp.repo.GithubRepo
import com.kotlinsg.kworkshopapp.tools.Toaster

interface ApplicationContextProvider {
    fun provideContext(): App
    fun provideLogger(): Logger
    fun provideToast(): Toaster
}

interface NetworkClientProvider {
    fun provideNetworkClient(): NetworkClient
}

interface RepoProvider {
    fun provideGithubRepo(): GithubRepo
}

interface NetworkClient {
    fun requestProject(path: String, onResult: (GithubProject) -> Unit, onError: (Throwable) -> Unit)
}