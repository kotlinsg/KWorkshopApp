package com.kotlinsg.kworkshopapp.model.di

import android.app.Application
import com.kotlinsg.kworkshopapp.GithubProject

interface ApplicationContextProvider {
    fun provideContext(): Application
    fun provideLogger(): Logger
}

interface NetworkClientProvider {
    fun provideNetworkClient(): NetworkClient
}

interface NetworkClient {
    fun requestProject(path: String, onResult: (GithubProject) -> Unit, onError: (Throwable) -> Unit)
}