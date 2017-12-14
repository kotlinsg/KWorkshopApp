package com.github.nekdenis.mylibrary.di

import android.app.Application

interface ApplicationContextProvider {
    fun provideContext(): Application
}

interface NetworkClientProvider {
    fun provideNetworkClient(): NetworkClient
}

interface NetworkClient {
    fun request(url: String): String
}