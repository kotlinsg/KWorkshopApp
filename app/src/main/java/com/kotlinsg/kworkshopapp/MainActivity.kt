package com.kotlinsg.kworkshopapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject lateinit var interf: MainUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        interf.main()
        findViewById<View>(R.id.icon).setOnClickListener { openGithubScreen() }
    }

    private fun openGithubScreen() {
        startActivity(Intent(this, GithubActivity::class.java))

    }
}
