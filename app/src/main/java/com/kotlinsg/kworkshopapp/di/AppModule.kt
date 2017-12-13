package com.kotlinsg.kworkshopapp.di

import android.content.Context
import com.kotlinsg.kworkshopapp.App
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
    }

    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
    @ActivityScope
    internal abstract fun mainActivity(): MainActivity

}
