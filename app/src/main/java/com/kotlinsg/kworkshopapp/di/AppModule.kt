package com.kotlinsg.kworkshopapp.di

import android.app.Application
import android.content.Context
import com.kotlinsg.kworkshopapp.App
import com.kotlinsg.kworkshopapp.github.GithubActivity
import com.kotlinsg.kworkshopapp.MainActivity
import com.kotlinsg.kworkshopapp.model.di.Logger
import com.kotlinsg.kworkshopapp.tools.LoggerImpl
import com.kotlinsg.kworkshopapp.tools.Toaster
import com.kotlinsg.kworkshopapp.tools.ToasterImpl
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

        @JvmStatic
        @Provides
        @Singleton
        fun provideToaster(app: App): Toaster {
            return ToasterImpl(app)
        }
    }

    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
    @ActivityScope
    internal abstract fun mainActivity(): MainActivity

    @ContributesAndroidInjector(modules = arrayOf(GithubActivityModule::class))
    @ActivityScope
    internal abstract fun githubActivity(): GithubActivity

}
