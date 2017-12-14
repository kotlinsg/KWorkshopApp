package com.kotlinsg.kworkshopapp.github

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.kotlinsg.kworkshopapp.GithubProject
import com.kotlinsg.kworkshopapp.R
import com.kotlinsg.kworkshopapp.di.AppComponent
import com.kotlinsg.kworkshopapp.network.di.DaggerNetworkComponent
import com.kotlinsg.kworkshopapp.repo.di.DaggerRepoComponent
import com.kotlinsg.kworkshopapp.tools.Toaster
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class GithubActivity : DaggerAppCompatActivity() {

    @Inject lateinit var appComponent: AppComponent

    @Inject lateinit var toaster: Toaster

    lateinit var refreshButton: Button
    lateinit var starsCountText: TextView
    lateinit var useCase: GithubUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_github)
        inject()

        refreshButton = findViewById(R.id.stars_refresh) as Button
        starsCountText = findViewById(R.id.stars_count_text) as TextView

        refreshButton.setOnClickListener { useCase.loadInfoFromGithub(onLoaded = ::updateUI, onError = ::updateErrorUI) }
    }

    private fun inject() {
        val networkProvider = DaggerNetworkComponent.builder()
                .applicationContextProvider(appComponent).build()

        val repo = DaggerRepoComponent.builder()
                .applicationContextProvider(appComponent)
                .networkClientProvider(networkProvider)
                .build().repo()

        useCase = GithubUseCaseImpl_Factory.create(repo).get()
    }


    private fun updateErrorUI(error: Throwable) {
        toaster.show(error.message ?: "unable to load")
    }

    private fun updateUI(result: GithubProject) {
        starsCountText.setText("${result.name} stars count: ${result.stargazers_count}")
    }
}
