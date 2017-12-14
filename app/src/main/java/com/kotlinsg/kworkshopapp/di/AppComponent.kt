package com.kotlinsg.kworkshopapp.di

import com.github.nekdenis.mylibrary.di.ApplicationContextProvider
import com.kotlinsg.kworkshopapp.App
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Scope
import javax.inject.Singleton


@Component(
        modules = [AppModule::class, AndroidSupportInjectionModule::class]
)
@Singleton
interface AppComponent : AndroidInjector<App>, ApplicationContextProvider {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()
}

@Scope annotation class ActivityScope
@Scope annotation class ServiceScope
@Scope annotation class FragmentScope
@Scope annotation class ViewScope