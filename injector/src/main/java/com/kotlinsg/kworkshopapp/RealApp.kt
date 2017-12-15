package com.kotlinsg.kworkshopapp

import android.app.Activity
import android.app.Application
import android.content.Context
import com.kotlinsg.kworkshopapp.di.AppComponent
import com.kotlinsg.kworkshopapp.di.GithubActivityComponent
import com.kotlinsg.kworkshopapp.di.MainActivityComponent
import com.kotlinsg.kworkshopapp.github.GithubActivity
import com.kotlinsg.kworkshopapp.repo.di.RepoComponent


class RealApp : Application(), App {
    companion object {
        fun component(context: Context): AppComponent = (context.applicationContext as RealApp).appComponent
    }

    lateinit var appComponent: AppComponent
    lateinit var repoComponent: RepoComponent
    //    lateinit var featureComponent: FeatureComponent

    override fun inject(activity: Activity) {
        if (activity is MainActivity) MainActivityComponent.Initializer.init(appComponent).inject(activity)
        if (activity is GithubActivity) GithubActivityComponent.Initializer.init(appComponent, repoComponent).inject(activity)
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = AppComponent.Initializer.init(this)
        repoComponent = RepoComponent.Initializer.init(appComponent)
    }
}