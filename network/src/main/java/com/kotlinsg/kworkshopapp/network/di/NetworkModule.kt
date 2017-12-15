package com.kotlinsg.kworkshopapp.network.di

import com.kotlinsg.kworkshopapp.di.NetworkClient
import com.kotlinsg.kworkshopapp.network.NetworkClientImpl
import dagger.Binds
import dagger.Module

@Module
interface NetworkModule {

    @Binds fun bindsNetworkClient(impl: NetworkClientImpl): NetworkClient

}