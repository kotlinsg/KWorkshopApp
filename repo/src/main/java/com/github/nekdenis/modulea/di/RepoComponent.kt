package com.github.nekdenis.modulea.di

import com.github.nekdenis.modulea.MainRepo
import com.github.nekdenis.mylibrary.di.ApplicationContextProvider
import com.github.nekdenis.mylibrary.di.NetworkClientProvider
import dagger.Component
import javax.inject.Provider

@Component(
        dependencies = [ApplicationContextProvider::class, NetworkClientProvider::class],
        modules = [RepoModule::class])
interface RepoComponent {
    fun repo(): Provider<MainRepo>
}