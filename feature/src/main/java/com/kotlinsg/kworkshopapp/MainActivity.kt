package com.kotlinsg.kworkshopapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.kotlinsg.kworkshopapp.app.R
import com.kotlinsg.kworkshopapp.github.GithubActivity
import com.kotlinsg.kworkshopapp.di.Logger
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var log: Logger

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (applicationContext as App).inject(this)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.icon).setOnClickListener { openGithubScreen() }
        log.d("Main activity created. Logger injected successfully")
    }

    private fun openGithubScreen() {
        startActivity(Intent(this, GithubActivity::class.java))
    }
}
