package com.kotlinsg.kworkshopapp.di

import com.github.nekdenis.modulea.di.RepoComponent
import com.kotlinsg.kworkshopapp.App
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Scope
import javax.inject.Singleton


@Component(
        dependencies = [RepoComponent::class],
        modules = [AppModule::class, AndroidSupportInjectionModule::class]
)
@Singleton
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()
}

@Scope annotation class ActivityScope
@Scope annotation class ServiceScope
@Scope annotation class FragmentScope
@Scope annotation class ViewScope