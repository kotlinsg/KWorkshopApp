package com.kotlinsg.kworkshopapp.network

import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.fuel.core.Request
import com.github.kittinunf.fuel.core.Response
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import com.kotlinsg.kworkshopapp.GithubProject
import com.kotlinsg.kworkshopapp.model.di.Logger
import com.kotlinsg.kworkshopapp.model.di.NetworkClient
import com.kotlinsg.kworkshopapp.network.model.GithubProjectModel
import javax.inject.Inject

class NetworkClientImpl @Inject constructor(
        val logger: Logger
) : NetworkClient {

    override fun requestProject(path: String, onResult: (GithubProject) -> Unit, onError: (Throwable) -> Unit) {

        val url = "https://api.github.com/repos/$path"

        logger.d("requesting: $url")

        url.httpGet().responseObject(
                deserializer = GithubProjectModel.Deserializer())
        { request: Request, response: Response, (result, error): Result<GithubProjectModel, FuelError> ->

            result?.let(onResult)
            error?.let(onError)
        }
    }
}