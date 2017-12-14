package com.github.nekdenis.mylibrary.di

import dagger.Component

@Component(
        dependencies = [ApplicationContextProvider::class],
        modules = [NetworkModule::class])
interface NetworkComponent : NetworkClientProvider {

}