package com.kotlinsg.kworkshopapp.di

import android.app.Application
import android.content.Context
import com.github.nekdenis.mylibrary.di.Logger
import com.kotlinsg.kworkshopapp.App
import com.kotlinsg.kworkshopapp.LoggerImpl
import com.kotlinsg.kworkshopapp.MainActivity
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton


@Module
abstract class AppModule {

    @Module
    companion object {
        @JvmStatic
        @Provides
        @Singleton
        fun context(app: App): Context {
            return app.getApplicationContext()
        }

        @JvmStatic
        @Provides
        @Singleton
        fun application(app: App): Application {
            return app
        }

        @JvmStatic
        @Provides
        @Singleton
        fun provideLogger(): Logger {
            return LoggerImpl()
        }
    }

    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
    @ActivityScope
    internal abstract fun mainActivity(): MainActivity

}
