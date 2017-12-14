package com.kotlinsg.kworkshopapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.kotlinsg.kworkshopapp.di.AppComponent
import com.kotlinsg.kworkshopapp.github.GithubActivity
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject
import javax.inject.Provider

class MainActivity : DaggerAppCompatActivity() {

    @Inject lateinit var appComponent: AppComponent
    @Inject lateinit var mainActivityProvider: Provider<MainActivity>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.icon).setOnClickListener { openGithubScreen() }
    }

    private fun openGithubScreen() {
        startActivity(Intent(this, GithubActivity::class.java))
    }
}
