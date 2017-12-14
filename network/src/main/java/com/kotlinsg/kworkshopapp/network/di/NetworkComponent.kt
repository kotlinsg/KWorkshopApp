package com.kotlinsg.kworkshopapp.network.di

import com.kotlinsg.kworkshopapp.model.di.ApplicationContextProvider
import com.kotlinsg.kworkshopapp.model.di.NetworkClientProvider
import dagger.Component

@Component(
        dependencies = [ApplicationContextProvider::class],
        modules = [NetworkModule::class])
interface NetworkComponent : NetworkClientProvider {

}