package com.github.nekdenis.modulea.di

import com.github.nekdenis.modulea.MainRepo
import com.github.nekdenis.modulea.MainRepoImpl
import dagger.Binds
import dagger.Module

@Module
interface RepoModule {

    @Binds fun bindsMainRepo(impl: MainRepoImpl): MainRepo

}