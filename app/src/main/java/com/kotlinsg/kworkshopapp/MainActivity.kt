package com.kotlinsg.kworkshopapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.github.nekdenis.modulea.di.DaggerRepoComponent
import com.github.nekdenis.mylibrary.di.DaggerNetworkComponent
import com.kotlinsg.kworkshopapp.di.AppComponent
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject
import javax.inject.Provider

class MainActivity : DaggerAppCompatActivity() {

    @Inject lateinit var appComponent: AppComponent
    @Inject lateinit var mainActivityProvider: Provider<MainActivity>

    lateinit var interf: MainUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val networkComponent = DaggerNetworkComponent.builder()
                .applicationContextProvider(appComponent).build();

        val repoProvider = DaggerRepoComponent.builder()
                .applicationContextProvider(appComponent)
                .networkClientProvider(networkComponent)
                .build().repo()

        interf = MainUseCaseImpl_Factory.create(mainActivityProvider, repoProvider).get()

        interf.main()
        findViewById<View>(R.id.icon).setOnClickListener { openGithubScreen() }
    }

    private fun openGithubScreen() {
        startActivity(Intent(this, GithubActivity::class.java))

    }
}
