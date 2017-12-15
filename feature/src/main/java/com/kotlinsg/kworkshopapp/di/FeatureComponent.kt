package com.kotlinsg.kworkshopapp.di

import com.kotlinsg.kworkshopapp.MainActivity
import com.kotlinsg.kworkshopapp.github.GithubActivity
import com.kotlinsg.kworkshopapp.model.di.ApplicationContextProvider
import dagger.Component

//@Singleton
//@Component(
//        dependencies = [RepoProvider::class],
////        modules = [FeatureModule::class])
//interface FeatureComponent {
//    fun inject(target: MainActivity)
//    fun inject(target: GithubActivity)
//}


@ActivityScope
@Component(
        dependencies = arrayOf(ApplicationContextProvider::class),
        modules = arrayOf(GithubActivityModule::class))
interface GithubActivityComponent {
    fun inject(activity: GithubActivity)

    class Initializer private constructor() {
        companion object {
            fun init(appComponent: ApplicationContextProvider): GithubActivityComponent =
                    DaggerGithubActivityComponent.builder()
                            .applicationContextProvider(appComponent).build()
        }
    }
}


@ActivityScope
@Component(
        dependencies = arrayOf(ApplicationContextProvider::class),
        modules = arrayOf(MainActivityModule::class))
interface MainActivityComponent {
    fun inject(activity: MainActivity)

    class Initializer private constructor() {
        companion object {
            fun init(appComponent: ApplicationContextProvider): MainActivityComponent =
                    DaggerMainActivityComponent.builder()
                            .applicationContextProvider(appComponent).build()
        }
    }
}

