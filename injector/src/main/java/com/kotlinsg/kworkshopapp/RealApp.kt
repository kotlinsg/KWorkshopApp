package com.kotlinsg.kworkshopapp

import android.app.Activity
import android.app.Application
import android.content.Context
import com.kotlinsg.kworkshopapp.di.AppComponent
import com.kotlinsg.kworkshopapp.di.GithubActivityComponent
import com.kotlinsg.kworkshopapp.di.MainActivityComponent
import com.kotlinsg.kworkshopapp.github.GithubActivity


class RealApp : Application(), App {
    companion object {
        fun component(context: Context): AppComponent = (context.applicationContext as RealApp).appComponent
    }

    lateinit var appComponent: AppComponent
    //    lateinit var featureComponent: FeatureComponent

    override fun inject(activity: Activity) {
        if (activity is MainActivity) MainActivityComponent.Initializer.init(appComponent).inject(activity)
        if (activity is GithubActivity) GithubActivityComponent.Initializer.init(appComponent).inject(activity)
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = initDagger(this)
    }

    private fun initDagger(app: RealApp): AppComponent =
            AppComponent.Initializer.init(app)
    //                    .appModule(AppModule(app))
    //                    .build()
    //                    .apply {
    //                        featureComponent = plusFeatureComponent(DaggerFeatureComponent())
    //                    }
}