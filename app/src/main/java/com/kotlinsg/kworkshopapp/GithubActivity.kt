package com.kotlinsg.kworkshopapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.fuel.core.Request
import com.github.kittinunf.fuel.core.Response
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result

class GithubActivity : AppCompatActivity() {

    lateinit var refreshButton: Button
    lateinit var starsCountText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_github)

        refreshButton = findViewById(R.id.stars_refresh) as Button
        starsCountText = findViewById(R.id.stars_count_text) as TextView

        refreshButton.setOnClickListener { loadInfoFromGithub() }
    }

    fun loadInfoFromGithub() {
        "https://api.github.com/repos/kotlinsg/KWorkshopApp".httpGet()
                .responseObject(GithubProject.Deserializer()) { request: Request, response: Response, result: Result<GithubProject, FuelError> ->
                    Log.d("GITHUB::", request.toString())
                    updateUI(result)
                }
    }

    private fun updateUI(result: Result<GithubProject, FuelError>) {
        val (data, error) = result
        if (error != null) {
            Toast.makeText(this, "error updating project!", Toast.LENGTH_SHORT)
        } else {
            starsCountText.setText("${result.get().name} stars count: ${result.get().stargazers_count}")
        }
    }
}
