package com.github.nekdenis.modulea.di

import com.github.nekdenis.mylibrary.di.AppComponentInterface
import com.github.nekdenis.mylibrary.di.RepoComponentInterface
import dagger.Component

@Component(
        dependencies = [AppComponentInterface::class],
        modules = [RepoModule::class])
interface RepoComponent : RepoComponentInterface {

}