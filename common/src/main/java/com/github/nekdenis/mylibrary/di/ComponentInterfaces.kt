package com.github.nekdenis.mylibrary.di

import android.app.Application

interface AppComponentInterface {
    fun provideContext(): Application
}

interface RepoComponentInterface {
    fun provideContext(): Application
}