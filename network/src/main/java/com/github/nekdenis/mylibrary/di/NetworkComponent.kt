package com.github.nekdenis.mylibrary.di

import com.github.nekdenis.modulea.di.NetworkModule
import dagger.Component

@Component(
        dependencies = [AppComponentInterface::class, RepoComponentInterface::class],
        modules = [NetworkModule::class])
interface RepoComponent {

}