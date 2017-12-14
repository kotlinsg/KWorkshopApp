package com.github.nekdenis.mylibrary.di

import com.github.nekdenis.mylibrary.NetworkClientImpl
import dagger.Binds
import dagger.Module

@Module
interface NetworkModule {

    @Binds fun bindsNetworkClient(impl: NetworkClientImpl): NetworkClient

}