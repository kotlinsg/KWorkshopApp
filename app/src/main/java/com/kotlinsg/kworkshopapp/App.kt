package com.kotlinsg.kworkshopapp

import com.github.nekdenis.modulea.di.DaggerRepoComponent
import com.kotlinsg.kworkshopapp.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication


class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder()
                .repoComponent(DaggerRepoComponent.create())
                .create(this)
    }
}